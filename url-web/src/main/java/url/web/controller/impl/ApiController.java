package url.web.controller.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import url.core.entity.Url;
import url.core.service.BaseUrlService;
import url.core.service.UrlService;
import url.web.controller.RestController;
import url.web.controller.WebController;

import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Created by Thomas on 25/02/2017.
 */
@Named
@Path("/")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ApiController implements RestController {

    private final static Logger LOGGER = LoggerFactory.getLogger(WebController.class);

    @Inject
    private UrlService urlService;

    @Inject
    private BaseUrlService baseUrlService;

    @GET
    @Path("/list")
    public List<Url> getList() {
        LOGGER.info("ApiController getList() : liste de tous les URLs");

        String baseUrl = baseUrlService.findOne(baseUrlService.getLastBaseUrlId()).getBaseUrl();
        List<Url> listUrl = urlService.findAll();
        listUrl.forEach(itemUrl -> itemUrl.setUrlCourt(baseUrl + itemUrl.getUrlCourt()));

        return listUrl;
    }


    @GET
    @Path("/{id}")
    public Url getOne(@PathParam("id") long id) {
        LOGGER.info("ApiController getOne(" + id + ") : récupération d'un URL par son id");

        String baseUrl = baseUrlService.findOne(baseUrlService.getLastBaseUrlId()).getBaseUrl();
        Url urlRetour = new Url();

        if(urlService.findOne(id) != null) {
            urlRetour = urlService.findOne(id);
            urlRetour.setUrlCourt(baseUrl + urlRetour.getUrlCourt());
            LOGGER.info("ApiController getOne(" + id + ") : URL trouvé : " + urlRetour.getUrlCourt());
        } else {
            LOGGER.error("ApiController getOne(" + id + ") : Aucun URL ne possède l'id : " + id);
            urlRetour.setId(404);
            urlRetour.setUrlCourt(baseUrl);
            urlRetour.setUrlLong(baseUrl);
            urlRetour.setNomUrl("Erreur 404 : aucun URL possédant l'id : " + id);
        }

        return urlRetour;
    }


    @POST
    @Path("/")
    public Url saveUrl(String url) {
        LOGGER.info("ApiController saveURL(" + url + ") : Enregistrement de l'URL");

        String baseUrl = baseUrlService.findOne(baseUrlService.getLastBaseUrlId()).getBaseUrl();
        Url urlRetour = new Url();
        if(urlService.findOneByUrlLong(url) != null) {
            urlRetour = urlService.findOneByUrlLong(url);
            urlRetour.setUrlCourt(baseUrl + urlRetour.getUrlCourt());
            LOGGER.info("ApiController saveURL(" + url + ") : l'URL long : " + urlRetour.getUrlLong() + "possède déjà un URL court associé : " + baseUrl + urlRetour.getUrlCourt());
        }else{
            urlRetour.createUrlCourt(urlService.getLastGeneratedUrl());
            urlRetour.setUrlLong(url);
            urlService.save(urlRetour);
            LOGGER.info("ApiController saveURL(" + url + ") : URL court généré : " + baseUrl + urlRetour.getUrlCourt());
        }

        urlRetour.setUrlCourt(baseUrl + urlRetour.getUrlCourt());

        return urlRetour;
    }
}
