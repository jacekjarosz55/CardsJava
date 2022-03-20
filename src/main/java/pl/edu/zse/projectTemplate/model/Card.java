package pl.edu.zse.projectTemplate.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.Set;

@Entity
public class Card {

    public Card(Integer damage, Integer health, String name) {
        this.damage = damage;
        this.health = health;
        this.name = name;
    }

    public Card() {
    }

    @Id
    @GeneratedValue
    protected Long id;

    protected Integer damage;
    protected Integer health;
    protected String name;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getDamage() {
        return damage;
    }

    public void setDamage(Integer damage) {
        this.damage = damage;
    }

    public Integer getHealth() {
        return health;
    }

    public void setHealth(Integer health) {
        this.health = health;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
