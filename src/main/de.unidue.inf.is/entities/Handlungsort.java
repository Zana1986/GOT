package entities;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Yafei on 07/01/2017.
 */
@Entity
@Table(name = "handlungsort")
public class Handlungsort implements Serializable {

    @Id
    @ManyToOne
    @JoinColumns(value = {
            @JoinColumn(name = "episodenummer", referencedColumnName = "epinummer"),
            @JoinColumn(name = "staffelnummer", referencedColumnName = "nummer")
    })
    private Episode episode;

    @Id
    @ManyToOne
    @JoinColumn(name = "ortid", referencedColumnName = "ortid")
    private Ort ort;

    public Handlungsort() {
    }

    public Handlungsort(Episode episode, Ort ort) {
        this.episode = episode;
        this.ort = ort;
    }

    public Episode getEpisode() {
        return episode;
    }

    public void setEpisode(Episode episode) {
        this.episode = episode;
    }

    public Ort getOrt() {
        return ort;
    }

    public void setOrt(Ort ort) {
        this.ort = ort;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || !(obj instanceof Handlungsort)) return false;

        final Handlungsort that = (Handlungsort) obj;
        if (!that.getOrt().equals(this.getOrt())) return false;
        if (!that.getEpisode().equals(this.getEpisode())) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (ort != null ? ort.hashCode() : 0);
        result = 31 * result + (episode != null ? episode.hashCode() : 0);
        return result;
    }
}
