package url.core.entity;

import org.springframework.data.annotation.Id;

import javax.inject.Inject;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

/**
 * Created by N0stress on 20/02/2017.
 */
public class User {


    @Inject
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "pseudo")
    private String pseudo;

    @Column(name = "mail")
    private String mail;

    @Column(name = "password")
    private String pswd;

    public User(){
    }

    public User(String pseudo, String mail, String pswd) {
        this.pseudo = pseudo;
        this.mail = mail;
        this.pswd = pswd;
    }

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPswd() {
        return pswd;
    }

    public void setPswd(String pswd) {
        this.pswd = pswd;
    }

    public long getId() {

        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
