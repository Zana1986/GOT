package entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "enthalten")
public class Enthalten implements Serializable {

    @Id
    @ManyToOne
    @JoinColumn(name = "playlisteid", referencedColumnName = "playlisteid")
    private Playliste playliste;
    @Id
    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "episodenummer", referencedColumnName = "epinummer"),
            @JoinColumn(name = "nummer", referencedColumnName = "nummer")
    })
    private Episode episode;

    public Enthalten() {
    }
    public Enthalten(Playliste playliste, Episode episode) {
        this.playliste = playliste;
        this.episode = episode;
    }


    public Playliste getPlayliste() {
        return playliste;
    }

    public void setPlayliste(Playliste playliste) {
        this.playliste = playliste;
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
        if (obj == null || !(obj instanceof Enthalten)) return false;

        Enthalten that = (Enthalten) obj;

        if (!that.getEpisode().equals(this.getEpisode())) return false;
        if (!that.getPlayliste().equals(this.getPlayliste())) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + (episode != null ? episode.hashCode() : 0);
        result = 31 * result + (playliste != null ? playliste.hashCode() : 0);
        return result;
    }
}
