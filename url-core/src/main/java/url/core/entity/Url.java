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

    @Column(name= "nomUrl")
    private String nomUrl;

    public Url() {
    }

    public Url(String urlCourt, String urlLong, String nomUrl) {
        this.urlCourt = urlCourt;
        this.urlLong = urlLong;
        this.nomUrl = nomUrl;
    }

    public Url(String urlLong, String nomUrl) {
        this.urlLong = urlLong;
        this.nomUrl = nomUrl;
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

    public String getNomUrl() {
        return nomUrl;
    }

    public void setNomUrl(String nomUrl) {
        this.nomUrl = nomUrl;
    }

    @Override
    public String toString() {
        return "Url{" +
                "id=" + id +
                ", urlCourt='" + urlCourt + '\'' +
                ", urlLong='" + urlLong + '\'' +
                ", nomUrl='" + nomUrl + '\'' +
                '}';
    }

    public void createUrlCourt(String lastUrl) {
        char derniereLettre = lastUrl.charAt(lastUrl.length() - 1);
        int acsii = (int) derniereLettre;
        if(acsii == 122) {
            this.urlCourt = lastUrl + "a";
        }else{
            this.urlCourt = lastUrl.substring(0, lastUrl.lastIndexOf(derniereLettre)) + Character.toChars(acsii + 1);
        }
    }
}
