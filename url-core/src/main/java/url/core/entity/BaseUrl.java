package url.core.entity;

import javax.persistence.*;

/**
 * Created by Thomas on 26/02/2017.
 */
@Entity
public class BaseUrl {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "baseUrl")
    private String baseUrl;

    public BaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    public BaseUrl() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getBaseUrl() {
        return baseUrl;
    }

    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    @Override
    public String toString() {
        return "BaseUrl{" +
                "id=" + id +
                ", baseUrl='" + baseUrl + '\'' +
                '}';
    }
}
