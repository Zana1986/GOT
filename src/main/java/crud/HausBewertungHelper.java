package crud;

import db.HibernateSessionFactorySupportImpl;
import entities.Haus;
import entities.HausBewertung;
import org.hibernate.query.Query;

import java.util.List;

/**
 * Created by Yafei on 10/01/2017.
 */
public class HausBewertungHelper extends HibernateSessionFactorySupportImpl {

    public void addHausBewertung(HausBewertung hauswertung) {
        this.beginTrasaction();
        this.getSession().save(hauswertung);
        this.commitTransaction();
    }

    public void updateHausBewertung(HausBewertung hauswertung) {
        this.beginTrasaction();
        this.getSession().update(hauswertung);
        this.commitTransaction();
    }

    public void deleteHausBewertung(int nummer) {
        this.beginTrasaction();
        //this.getSession().delete(this.getOne();
        this.commitTransaction();
    }

//    public int getAllByHaus(String hausname) {
//        String queryString = "SELECT AVG(hb.rating) FROM HausBewertung hb INNER JOIN Haus h ON(h.id=hb.haus.id)" +
//                "WHERE h.name = :name";
//        Query query = this.getSession().createQuery(queryString);
//        query.setParameter("name", hausname);
//        List<Double> ratings = (List<Double>) query.list();;
//        int rating = 0;
//        if (ratings != null || !ratings.isEmpty()) {
//            if (ratings.get(0) != null) {
//                rating = (int) Math.round(ratings.get(0));
//            }
//        }
//        this.closeAll();
//        return rating;
//    }

//    public Haus getOne(String hausName) {
//        String queryString = "FROM Haus h WHERE h.name = :hname";
//        Query query = this.getSession().createQuery(queryString);
//        query.setParameter("hname", hausName);
//        Haus haus = (Haus) query.uniqueResult();
//        this.closeAll();
//        return haus;
//    }

    public List<HausBewertung> getAll() {
        List hauswertungen = this.getSession().createQuery("FROM HausBewertung").list();
        this.closeAll();
        return hauswertungen;
    }
}
