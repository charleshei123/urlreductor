package url.web.controller.impl;

import url.core.entity.Url;
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
public class UrlController implements RestController {
    @Inject
    private UrlService urlService;


    @GET
    @Path("/list")
    public List<Url> getList() {
        return urlService.findAll();
    }


    @GET
    @Path("/{id}")
    public Url getOne(@PathParam("id") long id) {
        return urlService.findOne(id);
    }


    @POST
    @Path("/")
    public void saveEvenement(Url url) {
        urlService.save(url);
    }
}
