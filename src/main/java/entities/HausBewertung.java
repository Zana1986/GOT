package entities;

import javax.persistence.*;

/**
 * Created by Yafei on 07/01/2017.
 */
@Entity
@Table(name = "hauswertung")
@PrimaryKeyJoinColumns(value = {
        @PrimaryKeyJoinColumn(name = "benutzerid"),
        @PrimaryKeyJoinColumn(name = "bewertungid")
})
public class HausBewertung extends Bewertung {

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "hausid", referencedColumnName = "hausid")
    private Haus haus;

    public HausBewertung() {}
    public HausBewertung(Haus haus) {
        this.haus = haus;
    }

    public HausBewertung(int bewertungid, int benutzerid, String textInhalt, int rating, Haus haus) {
        super(bewertungid, benutzerid, textInhalt, rating);
        this.haus = haus;
    }

    public Haus getHaus() {
        return haus;
    }

    public void setHaus(Haus haus) {
        this.haus = haus;
    }

    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj)) return false;

        final HausBewertung that = (HausBewertung) obj;
        if (!that.getHaus().equals(this.getHaus())) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (haus != null ? haus.hashCode() : 0);
        return result;
    }
}
