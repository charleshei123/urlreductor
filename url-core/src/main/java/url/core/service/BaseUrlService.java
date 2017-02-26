package url.core.service;

import url.core.entity.BaseUrl;

import java.util.List;

/**
 * Created by Thomas on 26/02/2017.
 */
public interface BaseUrlService {

    List<BaseUrl> findAll();

    BaseUrl findOne(long id);

    void save(String baseUrl);

    long getLastBaseUrlId();

    void deleteById(long id);
}
