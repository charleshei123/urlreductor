package url.core.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import url.core.entity.Url;

/**
 * Created by N0stress on 20/02/2017.
 */
public interface UrlDAO extends JpaRepository<Url, Long> {
    public Url findOneByUrlLong(String urlLong);

    public Url findOneByUrlCourt(String urlCourt);

    @Query
            (
                    value="SELECT urlCourt FROM url ORDER BY id desc limit 1",
                    nativeQuery = true
            )
    public String getLastGeneratedUrl();
}
