package pl.edu.zse.projectTemplate.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.Set;

@Entity
public class User {
    @Id
    @GeneratedValue
    protected Long id;
    protected String username;
    protected String hashedpassword;
    protected String email;

    @ManyToMany
    protected Set<Card> cards;

    protected int lvl;

    public User(String username, String hashedpassword, String email, int lvl) {
        this.username = username;
        this.hashedpassword = hashedpassword;
        this.email = email;
        this.lvl = lvl;

    }

    public User() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getHashedpassword() {
        return hashedpassword;
    }

    public void setHashedpassword(String hashedpassword) {
        this.hashedpassword = hashedpassword;
    }

    public String getEmail() {
        return this.email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public int getLvl() {
        return lvl;
    }

    public void setLvl(int lvl) {
        this.lvl = lvl;
    }

}
