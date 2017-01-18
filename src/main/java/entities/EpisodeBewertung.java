package entities;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

/**
 * Created by Yafei on 07/01/2017.
 */
@Entity
@Table(name = "episodenwertung")
@PrimaryKeyJoinColumns(value = {
        @PrimaryKeyJoinColumn(name = "benutzerid"),
        @PrimaryKeyJoinColumn(name = "bewertungid")
})
@OnDelete(action = OnDeleteAction.CASCADE)
public class EpisodeBewertung extends Bewertung {

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumns(value = {
            @JoinColumn(name = "staffelnummer", referencedColumnName = "nummer"),
            @JoinColumn(name = "episodenummer", referencedColumnName = "epinummer")
    })
    private Episode episode;

    public EpisodeBewertung() {}
    public EpisodeBewertung(Episode episode) {
        this.episode = episode;
    }

    public EpisodeBewertung(int benutzerid, String textInhalt, int rating, Episode episode) {
        super(benutzerid, textInhalt, rating);
        this.episode = episode;
    }


    public Episode getEpisode() {
        return episode;
    }

    public void setEpisode(Episode episode) {
        this.episode = episode;
    }

    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj)) return false;

        final EpisodeBewertung that = (EpisodeBewertung) obj;
        if (!that.getEpisode().equals(this.getEpisode())) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (episode != null ? episode.hashCode() : 0);
        return result;
    }
}
