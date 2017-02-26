package url.web.controller.impl;

import url.core.entity.Url;
import url.core.service.BaseUrlService;
import url.core.service.UrlService;
import url.web.controller.RestController;

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
    @Inject
    private UrlService urlService;

    @Inject
    private BaseUrlService baseUrlService;

    @GET
    @Path("/list")
    public List<Url> getList() {

        String baseUrl = baseUrlService.findOne(baseUrlService.getLastBaseUrlId()).getBaseUrl();
        List<Url> listUrl = urlService.findAll();
        listUrl.forEach(itemUrl -> itemUrl.setUrlCourt(baseUrl + itemUrl.getUrlCourt()));

        return listUrl;
    }


    @GET
    @Path("/{id}")
    public Url getOne(@PathParam("id") long id) {

        String baseUrl = baseUrlService.findOne(baseUrlService.getLastBaseUrlId()).getBaseUrl();
        Url urlRetour = urlService.findOne(id);
        urlRetour.setUrlCourt(baseUrl + urlRetour.getUrlCourt());

        return urlRetour;
    }


    @POST
    @Path("/")
    public Url saveEvenement(Url url) {

        String baseUrl = baseUrlService.findOne(baseUrlService.getLastBaseUrlId()).getBaseUrl();

        if(urlService.findOneByUrlLong(url.getUrlLong()) != null) {
            Url urlExistant = new Url();
            urlExistant = urlService.findOneByUrlLong(url.getUrlLong());
            url.setUrlCourt(urlExistant.getUrlCourt());
        }else{
            url.createUrlCourt(urlService.getLastGeneratedUrl());
            urlService.save(url);
        }

        url.setUrlCourt(baseUrl + url.getUrlCourt());

        return url;
    }
}
