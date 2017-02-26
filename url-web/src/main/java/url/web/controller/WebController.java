package url.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import url.core.entity.Url;
import url.core.service.UrlService;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by Thomas on 25/02/2017.
 */
@Controller
public class WebController {
    private final static Logger LOGGER = LoggerFactory.getLogger(WebController.class);

    @Inject
    private UrlService urlService;

    @RequestMapping(value="/",method = RequestMethod.GET)
    public String recupererFormulaire(ModelMap model){
        LOGGER.info("Formulaire d'ajout d'URL");
        model.addAttribute("url",new Url());
        model.addAttribute("genere", false);
        return "index";
    }

    @RequestMapping(value = "/raccourcir", method = RequestMethod.POST)
    public String ajouterUrl(@ModelAttribute("url") Url url, ModelMap model, HttpServletRequest req){
        LOGGER.info("Ajout d'un URL");

        StringBuffer base = req.getRequestURL();
        String baseURI = req.getRequestURI();
        String baseContext = req.getContextPath();
        String urlBase = base.substring(0, base.length() - baseURI.length() + baseContext.length()) + "/";

        if(urlService.findOneByUrlLong(url.getUrlLong()) != null) {
            Url urlExistant = new Url();
            urlExistant = urlService.findOneByUrlLong(url.getUrlLong());
            url.setUrlCourt(urlExistant.getUrlCourt());
            model.addAttribute("urlApres", url);
            model.addAttribute("urlBase", urlBase);
            model.addAttribute("genere", true);
        }else{
            url.createUrlCourt(urlService.getLastGeneratedUrl());
            urlService.save(url);
            model.addAttribute("urlApres", url);
            model.addAttribute("urlBase", urlBase);
            model.addAttribute("genere", true);
        }
        return "index";
    }

    @RequestMapping(value="/all",method = RequestMethod.GET)
    public String getAllUrl(ModelMap model, HttpServletRequest req){
        LOGGER.info("Liste des URLs");
        StringBuffer base = req.getRequestURL();
        String baseURI = req.getRequestURI();
        String baseContext = req.getContextPath();
        String urlBase = base.substring(0, base.length() - baseURI.length() + baseContext.length()) + "/";
        List<Url> url = urlService.findAll();
        model.addAttribute("urls",url);
        model.addAttribute("urlBase", urlBase);
        return "tableau";
    }

    @RequestMapping(value="/contact",method = RequestMethod.GET)
    public String getContact(ModelMap model){
        LOGGER.info("Page Contact");
        return "contact";
    }

    @RequestMapping("/*")
    public String redirectionUrl(HttpServletRequest req){
        LOGGER.info("Tentative d'ouverture d'une page non prédéfinie");

        String uri = req.getRequestURI();
        uri = uri.substring(1, uri.length());
        Url urlRedirection = urlService.findOneByUrlCourt(uri);

        if(urlRedirection != null){
            LOGGER.info("Url de redirection trouvé");
            return "redirect:" + urlRedirection.getUrlLong();
        }else{
            LOGGER.info("Lien invalide : 404");
            return "error";
        }
    }
}
