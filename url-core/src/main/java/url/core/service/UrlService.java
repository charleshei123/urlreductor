package url.core.service;

import url.core.entity.Url;

import java.util.List;

/**
 * Created by N0stress on 20/02/2017.
 */
public interface UrlService {

public List<Url> findAll();

public Url findById(long id);

public Url findByUrlLong(String urlLong);

public void saveUrl(Url url);

public void deleteUrl(long id);
}
