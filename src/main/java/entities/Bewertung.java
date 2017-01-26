package entities;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Yafei on 07/01/2017.
 */
@Entity
@Table(name = "bewertung")
@Inheritance(strategy = InheritanceType.JOINED)
public class Bewertung implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bewertungid")
    private int bewertungid;

    private String textInhalt;

    private int rating;

    @ManyToOne
    @JoinColumn(name = "benutzerid", referencedColumnName = "benutzerid")
    private Benutzer benutzer;

    public Bewertung() {}
    public Bewertung(String textInhalt, int rating, Benutzer benutzer) {
        this.textInhalt = textInhalt;
        this.rating = rating;
        this.benutzer = benutzer;
    }

    public int getBewertungid() {
        return bewertungid;
    }

    public void setBewertungid(int bewertungid) {
        this.bewertungid = bewertungid;
    }

    public String getTextInhalt() {
        return textInhalt;
    }

    public void setTextInhalt(String textInhalt) {
        this.textInhalt = textInhalt;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public Benutzer getBenutzer() {
        return benutzer;
    }

    public void setBenutzer(Benutzer benutzer) {
        this.benutzer = benutzer;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || !(obj instanceof Bewertung)) return false;

        final Bewertung that = (Bewertung) obj;
        if (!that.getBenutzer().equals(this.getBenutzer())) return false;
        if (that.getBewertungid() != this.getBewertungid()) return false;
        if (that.getRating() != (this.getRating())) return false;
        if (!that.getTextInhalt().equals(this.getTextInhalt())) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + bewertungid;
        result = 31 * result + (benutzer != null ? benutzer.hashCode() : 0);
        result = 31 * result + rating;
        result = 31 * result + (textInhalt != null ? textInhalt.hashCode() : 0);
        return result;
    }
}
