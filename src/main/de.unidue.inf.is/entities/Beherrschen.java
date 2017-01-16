package entities;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Yafei on 07/01/2017.
 */
@Entity
@Table(name = "beherrschen")
public class Beherrschen implements Serializable {

    @Id
    @ManyToOne
    @JoinColumn(name = "hausid", referencedColumnName = "hausid")
    private Haus haus;

    @Id
    @ManyToOne
    @JoinColumn(name = "ortid", referencedColumnName = "ortid")
    private Ort ort;

    @Id
    @ManyToOne
    @JoinColumns(value = {
            @JoinColumn(name = "startstaffel", referencedColumnName = "nummer"),
            @JoinColumn(name = "startepisode", referencedColumnName = "epinummer")
    })
    private Episode startEpisode;

    @Id
    @ManyToOne
    @JoinColumns(value = {
            @JoinColumn(name = "endstaffel", referencedColumnName = "nummer"),
            @JoinColumn(name = "endepisode", referencedColumnName = "epinummer")
    })
    private Episode endEpisode;

    public Beherrschen() {}
    public Beherrschen(Haus haus, Ort ort, Episode startEpisode, Episode endEpisode) {
        this.haus = haus;
        this.ort = ort;
        this.startEpisode = startEpisode;
        this.endEpisode = endEpisode;
    }

    public Haus getHaus() {
        return haus;
    }

    public void setHaus(Haus haus) {
        this.haus = haus;
    }

    public Ort getOrt() {
        return ort;
    }

    public void setOrt(Ort ort) {
        this.ort = ort;
    }

    public Episode getStartEpisode() {
        return startEpisode;
    }

    public void setStartEpisode(Episode startEpisode) {
        this.startEpisode = startEpisode;
    }

    public Episode getEndEpisode() {
        return endEpisode;
    }

    public void setEndEpisode(Episode endEpisode) {
        this.endEpisode = endEpisode;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || !(obj instanceof Beherrschen)) return false;

        final Beherrschen that = (Beherrschen) obj;
        if (!that.getHaus().equals(this.getHaus())) return false;
        if (!that.getOrt().equals(this.getOrt())) return false;
        if (!that.getStartEpisode().equals(this.getStartEpisode())) return false;
        if (!that.getEndEpisode().equals(this.getEndEpisode())) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
