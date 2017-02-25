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
    public String getFormAndList(ModelMap model){
        LOGGER.info("Formulaire d'ajout d'URL");
        model.addAttribute("url",new Url());
        model.addAttribute("genere", false);
        return "index";
    }

    @RequestMapping(value = "/raccourcir", method = RequestMethod.POST)
    public String submitForm(@ModelAttribute("url") Url url, ModelMap model){
        LOGGER.info("Ajoute d'un URL");
        Url urlExistant = new Url();
        urlExistant = urlService.findOneByUrlLong(url.getUrlLong());
        //String test = Assert.notNull(urlExistant, "vide");
        if(urlExistant.getUrlCourt() != null) {
            url.setUrlCourt(urlExistant.getUrlCourt());
            model.addAttribute("urlApres", url);
            model.addAttribute("genere", true);
        }else{
            url.createUrlCourt(urlService.getLastGeneratedUrl());
            model.addAttribute("urlApres", url);
            model.addAttribute("genere", true);
            urlService.save(url);
        }
        return "/";
    }

    @RequestMapping(value="/all",method = RequestMethod.GET)
    public String getAllUrl(ModelMap model){
        LOGGER.info("Liste des URLs");
        List<Url> url = urlService.findAll();
        model.addAttribute("urls",url);
        return "tableau";
    }

    @RequestMapping(value="/contact",method = RequestMethod.GET)
    public String getContact(ModelMap model){
        LOGGER.info("Page Contact");
        return "contact";
    }

    @RequestMapping("/*")
    public String error(){
        return "error";
    }
}
