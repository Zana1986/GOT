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
    private List<Relation> relations = new ArrayList<Relation>();

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "personen", cascade = CascadeType.ALL)
    private List<Relation> personen = new ArrayList<>();

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

    public List<Relation> getRelations() {
        return relations;
    }

    public void setRelations(List<Relation> relations) {
        this.relations = relations;
    }

    public List<Relation> getPersonen() {
        return personen;
    }

    public void setPersonen(List<Relation> personen) {
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

        final Person that = (Person) obj;
        if (that.getName() != this.getName()) return false;
        if (that.getTitel() != this.getTitel()) return false;
        if (that.getId() != this.getId()) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = getId();
        result = 31 * result + (titel != null ? titel.hashCode() : 0);
        result = 31 * result + (getName() != null ? getName().hashCode() : 0);
        return result;
    }
}
