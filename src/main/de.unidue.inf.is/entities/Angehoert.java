package entities;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Yafei on 05/01/2017.
 */
@Entity
@Table(name = "angehoert")
public class Angehoert implements Serializable {

    @Id
    @ManyToOne
    @JoinColumn(name = "figurid", referencedColumnName = "figurid")
    private Person person;

    @Id
    @ManyToOne
    @JoinColumn(name = "hausid", referencedColumnName = "hausid")
    private Haus haus;

    @Id
    @ManyToOne
    @JoinColumns(value = {
            @JoinColumn(name = "startstaffel", referencedColumnName = "nummer"),
            @JoinColumn(name = "startepisode", referencedColumnName = "epinummer")
    })
    private Episode startPunkt;
    @Id
    @ManyToOne
    @JoinColumns(value = {
            @JoinColumn(name = "endstaffel", referencedColumnName = "nummer"),
            @JoinColumn(name = "endepisode", referencedColumnName = "epinummer")
    })
    private Episode endPunkt;

    public Angehoert() {}
    public Angehoert(Person person, Haus haus, Episode startPunkt, Episode endPunkt) {
        this.person = person;
        this.haus = haus;
        this.startPunkt = startPunkt;
        this.endPunkt = endPunkt;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Haus getHaus() {
        return haus;
    }

    public void setHaus(Haus haus) {
        this.haus = haus;
    }

    public Episode getStartPunkt() {
        return startPunkt;
    }

    public void setStartPunkt(Episode startPunkt) {
        this.startPunkt = startPunkt;
    }

    public Episode getEndPunkt() {
        return endPunkt;
    }

    public void setEndPunkt(Episode endPunkt) {
        this.endPunkt = endPunkt;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || !(obj instanceof Angehoert)) return false;

        final Angehoert that = (Angehoert) obj;
        if (!that.getPerson().equals(this.getPerson())) return false;
        if (!that.getHaus().equals(this.getHaus())) return false;
        if (!that.getStartPunkt().equals(this.getStartPunkt())) return false;
        if (!that.getEndPunkt().equals(this.getEndPunkt())) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (person != null ? person.hashCode() : 0);
        result = 31 * result + (haus != null ? haus.hashCode() : 0);
        result = 31 * result + (startPunkt != null ? startPunkt.hashCode() : 0);
        result = 31 * result + (endPunkt != null ? endPunkt.hashCode() : 0);
        return result;
    }
}
