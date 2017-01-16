package crud;

import db.HibernateSessionFactorySupportImpl;
import entities.StaffelBewertung;
import org.hibernate.query.Query;

import java.util.Iterator;
import java.util.List;

/**
 * Created by Yafei on 10/01/2017.
 */
public class StaffelBewertungHelper extends HibernateSessionFactorySupportImpl {

    public void addStaffelBewertung(StaffelBewertung staffelwertung) {
        this.beginTrasaction();
        this.getSession().save(staffelwertung);
        this.commitTransaction();
    }

    public void updateStaffelBewertung(StaffelBewertung staffelwertung) {
        this.beginTrasaction();
        this.getSession().update(staffelwertung);
        this.commitTransaction();
    }

    public void deleteStaffelBewertung(int nummer) {
        this.beginTrasaction();
        //this.getSession().delete(this.getOne();
        this.commitTransaction();
    }

    public int getAllByStaffel(int nummer) {
        String queryString = "SELECT AVG(b.rating) FROM StaffelBewertung sb INNER JOIN Bewertung b " +
                "ON (sb.bewertungid = b.bewertungid and sb.benutzerid = b.benutzerid) " +
                "WHERE sb.staffel.nummer = :num ";
        Query query = this.getSession().createQuery(queryString);
        query.setParameter("num", nummer);
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

    public List<StaffelBewertung> getAll() {
        List staffelwertungen = this.getSession().createQuery("FROM StaffelBewertung").list();
        this.closeAll();
        return staffelwertungen;
    }
}
