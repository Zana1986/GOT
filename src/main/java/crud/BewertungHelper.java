package crud;

import db.HibernateSessionFactorySupportImpl;
import entities.Bewertung;
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

    public void deleteBewertung(int nummer) {
        this.beginTrasaction();
        //this.getSession().delete(this.getOne();
        this.commitTransaction();
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

    public List<Bewertung> getAll() {
        List wertungen = this.getSession().createQuery("FROM Bewertung").list();
        this.closeAll();
        return wertungen;
    }
}
