package url.core.service.impl;

import org.springframework.transaction.annotation.Transactional;
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

    @Inject
    private UrlDAO urlDAO;

    @Override
    public List<Url> findAll() {
        return urlDAO.findAll();
    }

    @Override
    public Url findOne(long id) {
        return urlDAO.findOne(id);
    }

    @Override
    public void save(Url url) {
        urlDAO.save(url);
    }

    @Override
    public void delete(long id) {
        urlDAO.delete(id);
    }

    @Override
    public Url findOneByUrlLong(String urlLong) {
        return urlDAO.findOneByUrlLong(urlLong);
    }

    @Override
    public Url findOneByUrlCourt(String urlCourt) {
        return urlDAO.findOneByUrlCourt(urlCourt);
    }

    @Override
    public String getLastGeneratedUrl() {
        return urlDAO.getLastGeneratedUrl();
    }
}
