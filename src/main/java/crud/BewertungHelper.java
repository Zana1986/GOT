package crud;

import db.HibernateSessionFactorySupportImpl;
import entities.Benutzer;
import entities.Bewertung;
import entities.BewertungPK;
import org.hibernate.query.Query;

import java.util.List;

/**
 * Created by Yafei on 10/01/2017.
 */
public class BewertungHelper extends HibernateSessionFactorySupportImpl {

    public void addBewertung(Bewertung wertung) {
        this.beginTrasaction();
        this.getSession().save(wertung);
        this.commitTransaction();
    }

    public void updateBewertung(Bewertung wertung) {
        this.beginTrasaction();
        this.getSession().update(wertung);
        this.commitTransaction();
    }

    public Bewertung deleteBewertung(int benutzerId) {
        Bewertung b = this.getOne(benutzerId);
        // get persistented object
        Object o = this.getSession().load(Bewertung.class, new BewertungPK(b.getBewertungid(), b.getBenutzerid()));
        this.beginTrasaction();
        this.getSession().delete(o);
        this.commitTransaction();
        return b;
    }

    public Bewertung getOne(int benutzerId) {
        String queryString = "FROM Bewertung b WHERE b.benutzerid = :id";
        Query query = this.getSession().createQuery(queryString);
        query.setParameter("id", benutzerId);
        Bewertung bewertung = (Bewertung) query.uniqueResult();
        this.closeAll();

        return bewertung;
    }

    public List getAllByBenutzer(String loginKennung) {
        String queryString = "SELECT b FROM Bewertung b INNER JOIN Benutzer u ON(b.benutzerid=u.id)" +
                "WHERE u.loginKennung = :kennung";
        Query query = this.getSession().createQuery(queryString);
        query.setParameter("kennung", loginKennung);
        List ratings =  query.list();
        this.closeAll();
        return ratings;
    }

    public List getAllWithNutzer() {
        String queryString = "SELECT b, u FROM Bewertung b INNER JOIN Benutzer u ON(b.benutzerid=u.id)";
        Query query = this.getSession().createQuery(queryString);
        List ratingsWithNutzer =  query.list();
        this.closeAll();
        return ratingsWithNutzer;
    }

    public int getDurchschnitt() {
        String queryString = "SELECT AVG(rating) FROM Bewertung";
        Query query = this.getSession().createQuery(queryString);
        Double d = (Double) query.uniqueResult();
        if (d != null) {
            int avgRating = (int) Math.round(d);
            return avgRating;
        } else {
            return 0;
        }
    }

    public boolean isExisted(int benutzerId) {

        return this.getOne(benutzerId) != null;
    }

    public List<Bewertung> getAll() {
        List wertungen = this.getSession().createQuery("FROM Bewertung").list();
        this.closeAll();
        return wertungen;
    }
}
