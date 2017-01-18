package entities;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

/**
 * Created by Yafei on 07/01/2017.
 */
@Entity
@Table(name = "figurwertung")
@PrimaryKeyJoinColumns(value = {
        @PrimaryKeyJoinColumn(name = "benutzerid"),
        @PrimaryKeyJoinColumn(name = "bewertungid")
})
@OnDelete(action = OnDeleteAction.CASCADE)
public class FigurBewertung extends Bewertung {

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "figurid", referencedColumnName = "figurid")
    private Figur figur;

    public FigurBewertung() {}
    public FigurBewertung(Figur figur) {
        this.figur = figur;
    }

    public FigurBewertung(int benutzerid, String textInhalt, int rating, Figur figur) {
        super(benutzerid, textInhalt, rating);
        this.figur = figur;
    }

    public Figur getFigur() {
        return figur;
    }

    public void setFigur(Figur figur) {
        this.figur = figur;
    }

    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj)) return false;

        final FigurBewertung that = (FigurBewertung) obj;
        if (!that.getFigur().equals(this.getFigur())) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (figur != null ? figur.hashCode() : 0);
        return result;
    }
}
