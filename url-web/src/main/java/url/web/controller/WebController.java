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
        model.addAttribute("url", new Url());
        LOGGER.info("Liste des URLs");
        List<Url> urls = urlService.findAll();
        model.addAttribute("urls",urls);
        return "index";
    }

    @RequestMapping(value="/all",method = RequestMethod.GET)
    public String getAllUrl(ModelMap model){
        LOGGER.info("Liste des URLs");
        List<Url> url = urlService.findAll();
        model.addAttribute("urls",url);
        return "tableau";
    }

    @RequestMapping(value="/form", method=RequestMethod.POST)
    public String submitForm(@ModelAttribute("url") Url url){
        LOGGER.info("Ajout d'un URL");
        urlService.save(url);
        return "redirect:";
    }

    @RequestMapping("/*")
    public String error(){
        return "404";
    }
}
