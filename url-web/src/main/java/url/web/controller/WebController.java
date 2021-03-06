package url.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import url.core.entity.Url;
import url.core.service.BaseUrlService;
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

    @Inject
    private BaseUrlService baseUrlService;

    @RequestMapping(value="/",method = RequestMethod.GET)
    public String recupererFormulaire(ModelMap model, HttpServletRequest req){
        LOGGER.info("WebController recupererFormulaire(model, req) : Formulaire d'ajout d'URL");

        StringBuffer base = req.getRequestURL();
        String baseURI = req.getRequestURI();
        String baseContext = req.getContextPath();
        String urlBase = base.substring(0, base.length() - baseURI.length() + baseContext.length()) + "/";

        LOGGER.info("WebController recupererFormulaire(model, req) : Enregistrement de la nouvelle base pour les Urls courts et suppression de l'ancienne");
        baseUrlService.deleteById(baseUrlService.getLastBaseUrlId());
        baseUrlService.save(urlBase);

        model.addAttribute("url",new Url());
        model.addAttribute("genere", false);

        return "index";
    }

    @RequestMapping(value = "/raccourcir", method = RequestMethod.POST)
    public String ajouterUrl(@ModelAttribute("url") Url url, ModelMap model){
        LOGGER.info("WebController ajouterUrl(" + url.getUrlLong() + ", model) : Enregistrement de l'URL " + url.getUrlLong());

        String urlBase = baseUrlService.findOne(baseUrlService.getLastBaseUrlId()).getBaseUrl();

        if(urlService.findOneByUrlLong(url.getUrlLong()) != null) {
            Url urlExistant = new Url();
            urlExistant = urlService.findOneByUrlLong(url.getUrlLong());
            url.setUrlCourt(urlExistant.getUrlCourt());

            LOGGER.info("WebController ajouterUrl(" + url.getUrlLong() + ", model) : L'URL possède déjà un URL court associé : " + urlBase + url.getUrlCourt());

            model.addAttribute("urlApres", url);
            model.addAttribute("urlBase", urlBase);
            model.addAttribute("genere", true);
        } else {
            url.createUrlCourt(urlService.getLastGeneratedUrl());
            urlService.save(url);

            LOGGER.info("WebController ajouterUrl(" + url.getUrlLong() + ", model) : URL court généré associé généré et enregistré : " + urlBase + url.getUrlCourt());

            model.addAttribute("urlApres", url);
            model.addAttribute("urlBase", urlBase);
            model.addAttribute("genere", true);
        }

        return "index";
    }

    @RequestMapping(value="/all",method = RequestMethod.GET)
    public String getAllUrl(ModelMap model){
        LOGGER.info("WebController getAllUrl(model) : Récupératin de la liste des URLs enregistrés");

        String urlBase = baseUrlService.findOne(baseUrlService.getLastBaseUrlId()).getBaseUrl();

        List<Url> url = urlService.findAll();
        model.addAttribute("urls",url);
        model.addAttribute("urlBase", urlBase);

        return "tableau";
    }

    @RequestMapping(value="/contact",method = RequestMethod.GET)
    public String getContact(ModelMap model){
        LOGGER.info("WebController getContact(model) : Renvoie de la page COntact");

        return "contact";
    }

    @RequestMapping("/*")
    public String redirectionUrl(HttpServletRequest req){
        LOGGER.info("WebController redirectionUrl(req) : Ouverture d'une page associé à un URL court ou simplement erreur dans la saisie");

        String uri = req.getRequestURI();
        uri = uri.substring(1, uri.length());
        Url urlRedirection = urlService.findOneByUrlCourt(uri);

        if(urlRedirection != null){
            LOGGER.info("WebController redirectionUrl(req) : Url de redirection trouvé");

            return "redirect:" + urlRedirection.getUrlLong();
        }else{
            LOGGER.info("WebController redirectionUrl(req) : Lien invalide : 404");

            return "error";
        }
    }

    @RequestMapping(value="/supprimer/{id}", method = RequestMethod.GET)
    public String suppressionUrl(@PathVariable("id") Long id){
        LOGGER.info("WebController suppressionUrl(" + id + ") : suppression de l'URL ayant l'id : " + id);

        urlService.delete(id);

        return "redirect: /all";
    }
}
