package url.core.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import url.core.entity.BaseUrl;

/**
 * Created by Thomas on 26/02/2017.
 */
public interface BaseUrlDAO extends JpaRepository<BaseUrl, Long> {

    @Query (value="SELECT id FROM baseurl ORDER BY id desc limit 1", nativeQuery = true)
    long getLastBaseUrlId();
}
