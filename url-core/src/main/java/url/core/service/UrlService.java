package url.core.service;

import url.core.entity.Url;

import java.util.List;

/**
 * Created by N0stress on 20/02/2017.
 */
public interface UrlService {

    List<Url> findAll();

    Url findOne(long id);

    void save(Url url);

    void delete(long id);

    Url findOneByUrlLong(String urlLong);

    Url findOneByUrlCourt(String urlCourt);

    String getLastGeneratedUrl();
}
