package entities;

import org.hibernate.annotations.*;
import org.hibernate.annotations.CascadeType;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.Table;

@Entity
@Table(name = "staffelwertung")
@PrimaryKeyJoinColumns(value = {
        @PrimaryKeyJoinColumn(name = "bewertungid")
})
@OnDelete(action = OnDeleteAction.CASCADE)
public class StaffelBewertung extends Bewertung {

    @ManyToOne
    @JoinColumn(name = "staffelnummer", referencedColumnName = "nummer")
    private Staffel staffel;

    public StaffelBewertung() {}
    public StaffelBewertung(String textInhalt, int rating, Benutzer benutzer, Staffel staffel) {
        super(textInhalt, rating, benutzer);
        this.staffel = staffel;
    }

    public Staffel getStaffel() {
        return staffel;
    }

    public void setStaffel(Staffel staffel) {
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
