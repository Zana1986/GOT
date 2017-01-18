package entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

/**
 * Created by Yafei on 05/01/2017.
 */
@Entity
@Table(name = "staffel")
public class Staffel {
    @Id
    private int nummer;
    @Column(name = "episodenanzahl")
    private int episodenAnzahl;
    @Column(name = "startsdatum")
    private Date startsDatum;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "staffel")
    private Collection<Episode> episoden = new ArrayList<Episode>();

    public Staffel() {}
    public Staffel(int nummer, int episodenAnzahl, Date startsDatum) {
        this.nummer = nummer;
        this.episodenAnzahl = episodenAnzahl;
        this.startsDatum = startsDatum;
    }

    public int getNummer() {
        return nummer;
    }

    public void setNummer(int nummer) {
        this.nummer = nummer;
    }

    public int getEpisodenAnzahl() {
        return episodenAnzahl;
    }

    public void setEpisodenAnzahl(int episodenAnzahl) {
        this.episodenAnzahl = episodenAnzahl;
    }

    public Date getStartsDatum() {
        return startsDatum;
    }

    public void setStartsDatum(Date startsDatum) {
        this.startsDatum = startsDatum;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || !(obj instanceof Staffel)) return false;

        final Staffel that = (Staffel) obj;
        if (that.episodenAnzahl != this.episodenAnzahl) return false;
        if (!that.startsDatum.equals(this.startsDatum)) return false;
        if (that.nummer != this.nummer) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = nummer;
        result = 31 * result + episodenAnzahl;
        result = 31 * result + (startsDatum != null ? startsDatum.hashCode() : 0);
        return result;
    }
}
