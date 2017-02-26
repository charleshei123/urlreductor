package url.core.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;
import url.core.config.AppConfig;
import url.core.dao.UrlDAO;
import url.core.entity.Url;
import url.core.service.UrlService;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

/**
 * Created by N0stress on 20/02/2017.
 */
@Named
@Transactional
public class UrlServiceImpl implements UrlService{

    private final static Logger LOGGER = LoggerFactory.getLogger(AppConfig.class);

    @Inject
    private UrlDAO urlDAO;

    @Override
    public List<Url> findAll() {
        LOGGER.info("UrlServiceImpl findAll() : Renvoye la liste des URLs enregistrés");

        return urlDAO.findAll();
    }

    @Override
    public Url findOne(long id) {
        LOGGER.info("UrlServiceImpl findOne("+ id +") : Renvoye l'URL ayant l'id " + id);

        return urlDAO.findOne(id);
    }

    @Override
    public void save(Url url) {
        LOGGER.info("UrlServiceImpl save(url) : Enregistre l'URL long suivant " + url.getUrlLong() + "avec l'URL court " + url.getUrlCourt());

        urlDAO.save(url);
    }

    @Override
    public void delete(long id) {
        LOGGER.info("UrlServiceImpl delete("+ id +") : Supprime l'URL ayant l'id " + id);

        urlDAO.delete(id);
    }

    @Override
    public Url findOneByUrlLong(String urlLong) {
        LOGGER.info("UrlServiceImpl findOneByUrlLong("+ urlLong +") : Cherche l'URL ayant comme URL long " + urlLong);

        return urlDAO.findOneByUrlLong(urlLong);
    }

    @Override
    public Url findOneByUrlCourt(String urlCourt) {
        LOGGER.info("UrlServiceImpl findOneByUrlCourt("+ urlCourt +") : Cherche l'URL ayant comme URL court " + urlCourt);

        return urlDAO.findOneByUrlCourt(urlCourt);
    }

    @Override
    public String getLastGeneratedUrl() {
        LOGGER.info("UrlServiceImpl getLastGeneratedUrl() : Cherche le dernier URL enregistré dans la BDD");

        return urlDAO.getLastGeneratedUrl();
    }
}
