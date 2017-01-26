package entities;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

/**
 * Created by Yafei on 07/01/2017.
 */
@Entity
@Table(name = "hauswertung")
@PrimaryKeyJoinColumns(value = {
        @PrimaryKeyJoinColumn(name = "bewertungid")
})
//@OnDelete(action = OnDeleteAction.CASCADE)
public class HausBewertung extends Bewertung {

    @ManyToOne
    @JoinColumn(name = "hausid", referencedColumnName = "hausid")
    private Haus haus;

    public HausBewertung() {}

    public HausBewertung(String textInhalt, int rating, Benutzer benutzer, Haus haus) {
        super(textInhalt, rating, benutzer);
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
        if (this == obj) return true;
        if (obj == null || !(obj instanceof HausBewertung)) return false;
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
