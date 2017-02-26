package url.core.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;
import url.core.config.AppConfig;
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

    private final static Logger LOGGER = LoggerFactory.getLogger(AppConfig.class);

    @Inject
    private BaseUrlDAO baseUrlDAO;

    @Override
    public List<BaseUrl> findAll() {
        LOGGER.info("BaseUrlServiceImpl findAll() : Renvoye la liste des Urls de base");

        return baseUrlDAO.findAll();
    }

    @Override
    public BaseUrl findOne(long id) {
        LOGGER.info("BaseUrlServiceImpl findOne("+ id +") : Renvoye l'URL de base ayant l'id " + id);

        return baseUrlDAO.findOne(id);
    }

    @Override
    public void save(String baseUrl) {
        LOGGER.info("BaseUrlServiceImpl save("+ baseUrl +") : Enregistre l'URL de base suivant " + baseUrl);

        BaseUrl baseUrlSave = new BaseUrl();
        baseUrlSave.setBaseUrl(baseUrl);
        baseUrlDAO.save(baseUrlSave);
    }

    @Override
    public long getLastBaseUrlId() {
        LOGGER.info("BaseUrlServiceImpl getLastBaseUrlId() : Récupère le dernier URL de base enregistré");

        return baseUrlDAO.getLastBaseUrlId();
    }

    @Override
    public void deleteById(long id) {
        LOGGER.info("BaseUrlServiceImpl deleteById("+ id +") : Supprime le dernier URL de base enregistré pour éviter un remplissage intempestif de la BDD" );

        baseUrlDAO.delete(id);
    }
}
