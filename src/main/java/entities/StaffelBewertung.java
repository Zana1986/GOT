package entities;

import javax.persistence.*;

/**
 * Created by Yafei on 07/01/2017.
 */
@Entity
@Table(name = "staffelwertung")
@PrimaryKeyJoinColumns(value = {
        @PrimaryKeyJoinColumn(name = "benutzerid"),
        @PrimaryKeyJoinColumn(name = "bewertungid")
})
public class StaffelBewertung extends Bewertung {

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "staffelnummer", referencedColumnName = "nummer")
    private Staffel staffel;

    public StaffelBewertung() {}
    public StaffelBewertung(Staffel staffel) {
        this.staffel = staffel;
    }

    public StaffelBewertung(int bewertungid, int benutzerid, String textInhalt, int rating, Staffel staffel) {
        super(bewertungid, benutzerid, textInhalt, rating);
        this.staffel = staffel;
    }

    public Staffel getStaffel() {
        return staffel;
    }

    public void setStaffel(Figur figur) {
        this.staffel = staffel;
    }

    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj)) return false;

        final StaffelBewertung that = (StaffelBewertung) obj;
        if (!that.getStaffel().equals(this.getStaffel())) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (staffel != null ? staffel.hashCode() : 0);
        return result;
    }
}
