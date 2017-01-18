package entities;

import javax.persistence.*;

/**
 * Created by Yafei on 07/01/2017.
 */
@Entity
@Table(name = "bewertung")
@Inheritance(strategy = InheritanceType.JOINED)
@IdClass(BewertungPK.class)
public class Bewertung {

    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bewertungid")
    private int bewertungid;

    @Id
    @Column(name = "benutzerid")
    private int benutzerid;

    private String textInhalt;

    private int rating;

    public Bewertung() {}
    public Bewertung(int benutzerid, String textInhalt, int rating) {
        this.benutzerid = benutzerid;
        this.textInhalt = textInhalt;
        this.rating = rating;
    }

    public Bewertung(int bewertungid, int benutzerid, String textInhalt, int rating) {
        this.bewertungid = bewertungid;
        this.benutzerid = benutzerid;
        this.textInhalt = textInhalt;
        this.rating = rating;
    }

    public int getBewertungid() {
        return bewertungid;
    }

    public void setBewertungid(int bewertungid) {
        this.bewertungid = bewertungid;
    }

    public int getBenutzerid() {
        return benutzerid;
    }

    public void setBenutzerid(int benutzerid) {
        this.benutzerid = benutzerid;
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

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || !(obj instanceof Bewertung)) return false;

        final Bewertung that = (Bewertung) obj;
        if (that.getBenutzerid() != this.getBenutzerid()) return false;
        if (that.getBewertungid() != this.getBewertungid()) return false;
        if (that.getRating() != (this.getRating())) return false;
        if (!that.getTextInhalt().equals(this.getTextInhalt())) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = benutzerid;
        result = 31 * result + bewertungid;
        result = 31 * result + rating;
        result = 31 * result + (textInhalt != null ? textInhalt.hashCode() : 0);
        return result;
    }
}
