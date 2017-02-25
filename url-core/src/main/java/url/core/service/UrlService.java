package url.core.service;

import url.core.entity.Url;

import java.util.List;

/**
 * Created by N0stress on 20/02/2017.
 */
public interface UrlService {

    public List<Url> findAll();

    public Url findOne(long id);

    public void save(Url url);

    public void delete(long id);
}
