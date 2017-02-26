package url.core.service.impl;

import org.springframework.transaction.annotation.Transactional;
import url.core.dao.BaseUrlDAO;
import url.core.entity.BaseUrl;
import url.core.service.BaseUrlService;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

/**
 * Created by Thomas on 26/02/2017.
 */
@Named
@Transactional
public class BaseUrlServiceImpl implements BaseUrlService {

    @Inject
    private BaseUrlDAO baseUrlDAO;

    @Override
    public List<BaseUrl> findAll() {
        return baseUrlDAO.findAll();
    }

    @Override
    public BaseUrl findOne(long id) {
        return baseUrlDAO.findOne(id);
    }

    @Override
    public void save(String baseUrl) {
        BaseUrl baseUrlSave = new BaseUrl();
        baseUrlSave.setBaseUrl(baseUrl);
        baseUrlDAO.save(baseUrlSave);
    }

    @Override
    public long getLastBaseUrlId() {
        return baseUrlDAO.getLastBaseUrlId();
    }
}
