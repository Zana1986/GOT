package entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Yafei on 05/01/2017.
 */
@Entity
@Table(name = "person")
@PrimaryKeyJoinColumn(name = "figurid")
public class Person extends Figur {
    private String titel;
    private String biografie;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "person", cascade = CascadeType.ALL)
    private Set<Angehoert> haeuse = new HashSet<>();

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "freunde", cascade = CascadeType.ALL)
    private Set<Relation> relations = new HashSet<>();

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "personen", cascade = CascadeType.ALL)
    private Set<Relation> personen = new HashSet<>();

    public Person() {}
    public Person(String name, Ort herkunftsort, String titel, String biografie) {
        super(name, herkunftsort);
        this.titel = titel;
        this.biografie = biografie;
    }

    public String getTitel() {
        return titel;
    }

    public void setTitel(String titel) {
        this.titel = titel;
    }

    public String getBiografie() {
        return biografie;
    }

    public void setBiografie(String biografie) {
        this.biografie = biografie;
    }

    public Set<Relation> getRelations() {
        return relations;
    }

    public void setRelations(Set<Relation> relations) {
        this.relations = relations;
    }

    public Set<Relation> getPersonen() {
        return personen;
    }

    public void setPersonen(Set<Relation> personen) {
        this.personen = personen;
    }

    public Set<Angehoert> getHaeuse() {
        return haeuse;
    }

    public void setHaeuse(Set<Angehoert> haeuse) {
        this.haeuse = haeuse;
    }

    public void addHaus(Haus haus, Episode start, Episode end) {
        Angehoert personZuHaus = new Angehoert(this, haus, start, end);
        haeuse.add(personZuHaus);
        haus.getOwners().add(personZuHaus);
    }

    public void removeHaus(Haus haus, Episode start, Episode end) {
        Angehoert personZuHaus = new Angehoert(this, haus, start, end);
        haus.getOwners().remove(personZuHaus);
        haeuse.remove(personZuHaus);
        personZuHaus.setHaus(null);
        personZuHaus.setPerson(null);
        personZuHaus.setStartPunkt(null);
        personZuHaus.setEndPunkt(null);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || !(obj instanceof Person)) return false;
        if (!super.equals(obj)) return false;

        Person that = (Person) this;
        if (!that.getTitel().equals(this.getTitel())) return false;
        if (!that.getBiografie().equals(this.getBiografie())) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (getTitel() != null ? getTitel().hashCode() : 0);
        result = 31 * result + (getBiografie() != null ? getBiografie().hashCode() : 0);
        return result;
    }
}
