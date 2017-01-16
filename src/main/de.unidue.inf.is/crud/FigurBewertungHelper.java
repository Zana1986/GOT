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

    public int getAllByFigur(String figurname) {
        String queryString = "SELECT AVG(fb.rating) FROM FigurBewertung fb INNER JOIN Figur f ON(f.id=fb.figur.id)" +
                "WHERE f.name = :name";
        Query query = this.getSession().createQuery(queryString);
        query.setParameter("name", figurname);
        List<Double> ratings = (List<Double>) query.list();;
        int rating = 0;
        if (ratings != null || !ratings.isEmpty()) {
            if (ratings.get(0) != null) {
                rating = (int) Math.round(ratings.get(0));
            }
        }
        this.closeAll();
        return rating;
    }

    public List<FigurBewertung> getAll() {
        List figurwertungen = this.getSession().createQuery("FROM FigurBewertung").list();
        this.closeAll();
        return figurwertungen;
    }
}
