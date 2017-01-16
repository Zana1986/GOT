package crud;

import db.HibernateSessionFactorySupportImpl;
import entities.Angehoert;
import org.hibernate.query.Query;

import java.util.List;

/**
 * Created by Yafei on 10/01/2017.
 */
public class AngehoertHelper extends HibernateSessionFactorySupportImpl {
    public void addAngehoert(Angehoert angehoert) {
        this.beginTrasaction();
        this.getSession().save(angehoert);
        this.commitTransaction();
    }

    public void updateAngehoert(Angehoert angehoert) {
        this.beginTrasaction();
        this.getSession().update(angehoert);
        this.commitTransaction();
    }

    public void deleteAngehoert(int nummer) {
        this.beginTrasaction();
       // this.getSession().delete(this.getOne(nummer));
        this.commitTransaction();
    }

    public List getAllByHaus(String hausName) {
        String queryString = "FROM Angehoert a WHERE a.haus.name = :hName";
        Query query = this.getSession().createQuery(queryString);
        query.setParameter("hName", hausName);
        List angehoert =  query.list();
        this.closeAll();
        return angehoert;
    }

//    public List<Object[]> getAllWithRatingByHaus(String hausName) {
//        String queryString = "SELECT a, f FROM Angehoert a INNER JOIN FigurBewertung f ON(a.person.id = f.figur.id) " +
//                "WHERE a.haus.name = :hName";
//        Query query = this.getSession().createQuery(queryString);
//        query.setParameter("hName", hausName);
//        List angehoert =  query.list();
//        this.closeAll();
//        return angehoert;
//    }

    public List<Angehoert> getAll() {
        List angehoert = this.getSession().createQuery("FROM Angehoert").list();
        this.closeAll();
        return angehoert;
    }
}
