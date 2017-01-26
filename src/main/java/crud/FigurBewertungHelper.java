package crud;

import db.HibernateSessionFactorySupportImpl;
import entities.FigurBewertung;
import org.hibernate.query.Query;

import java.util.List;

/**
 * Created by Yafei on 10/01/2017.
 */
public class FigurBewertungHelper extends HibernateSessionFactorySupportImpl {

    public void addFigurBewertung(FigurBewertung figurwertung) {
        this.beginTrasaction();
        this.getSession().save(figurwertung);
        this.commitTransaction();
    }

    public void updateFigurBewertung(FigurBewertung figurwertung) {
        this.beginTrasaction();
        this.getSession().update(figurwertung);
        this.commitTransaction();
    }

    public void deleteFigurBewertung(int nummer) {
        this.beginTrasaction();
        //this.getSession().delete(this.getOne();
        this.commitTransaction();
    }

    public List<FigurBewertung> getAll() {
        List figurwertungen = this.getSession().createQuery("FROM FigurBewertung").list();
        this.closeAll();
        return figurwertungen;
    }
}
