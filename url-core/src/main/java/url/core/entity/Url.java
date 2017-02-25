package url.core.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by N0stress on 20/02/2017.
 */
@Entity
public class Url {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "urlCourt")
    private String urlCourt;

    @Column(name = "urlLong")
    private String urlLong;

    public Url() {
    }

    public Url(String urlCourt, String urlLong) {
        this.urlCourt = urlCourt;
        this.urlLong = urlLong;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUrlCourt() {
        return urlCourt;
    }

    public void setUrlCourt(String urlCourt) {
        this.urlCourt = urlCourt;
    }

    public String getUrlLong() {
        return urlLong;
    }

    public void setUrlLong(String urlLong) {
        this.urlLong = urlLong;
    }

    @Override
    public String toString() {
        return "Url{" +
                "id=" + id +
                ", urlCourt='" + urlCourt + '\'' +
                ", urlLong='" + urlLong + '\'' +
                '}';
    }
}
