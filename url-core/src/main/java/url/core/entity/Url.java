package url.core.entity;

import org.springframework.data.annotation.Id;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

/**
 * Created by N0stress on 20/02/2017.
 */
@Entity
public class Url {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "urlLong")
    private String urlLong;

    @Column(name = "urlCourt")
    private String urlCourt;

    public Url(String urlLong, String urlCourt) {
        this.urlLong = urlLong;
        this.urlCourt = urlCourt;
    }

    public Url() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUrlLong() {
        return urlLong;
    }

    public void setUrlLong(String urlLong) {
        this.urlLong = urlLong;
    }

    public String getUrlCourt() {
        return urlCourt;
    }

    public void setUrlCourt(String urlCourt) {
        this.urlCourt = urlCourt;
    }

    @Override
    public String toString() {
        return "Url{" +
                "id=" + id +
                ", urlLong='" + urlLong + '\'' +
                ", urlCourt='" + urlCourt + '\'' +
                '}';
    }
}
