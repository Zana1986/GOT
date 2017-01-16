package entities;

import org.hibernate.annotations.Columns;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Yafei on 06/01/2017.
 */
@Entity
@Table(name = "auftretenIn")
public class AuftretenIn implements Serializable {

    @Id
    @ManyToOne
    @JoinColumn(name = "figurid")
    private Figur figur;

    @Id
    @ManyToOne
    @JoinColumns(value = {
            @JoinColumn(name = "nummer", referencedColumnName = "nummer"),
            @JoinColumn(name = "episodenummer", referencedColumnName = "epinummer")
    })
    private Episode episode;

    public AuftretenIn() {}
    public AuftretenIn(Figur figur, Episode episode) {
        this.figur = figur;
        this.episode = episode;
    }

    public Figur getFigur() {
        return figur;
    }

    public void setFigur(Figur figur) {
        this.figur = figur;
    }

    public Episode getEpisode() {
        return episode;
    }

    public void setEpisode(Episode episode) {
        this.episode = episode;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || !(obj instanceof AuftretenIn)) return false;

        final AuftretenIn that = (AuftretenIn) obj;
        if (!that.figur.equals(this.figur)) return false;
        if (!that.episode.equals((this.episode))) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        result = (figur != null ? figur.hashCode() : 0);
        result = 31 * result + (episode != null ? episode.hashCode() : 0);
        return result;
    }
}
