package crud;

import db.HibernateSessionFactorySupportImpl;
import entities.Burg;
import org.hibernate.query.Query;

import java.util.List;

/**
 * Created by Yafei on 10/01/2017.
 */
public class BurgHelper extends HibernateSessionFactorySupportImpl {
    public void addBurg(Burg burg) {
        this.beginTrasaction();
        this.getSession().save(burg);
        this.commitTransaction();
    }

    public void updateBurg(Burg burg) {
        this.beginTrasaction();
        this.getSession().update(burg);
        this.commitTransaction();
    }

    public void deleteBurg(int nummer) {
        this.beginTrasaction();
       // this.getSession().delete(this.getOne(nummer));
        this.commitTransaction();
    }

//    public Burg getOneByName(String ortName) {
//        String queryString = "FROM Burg o WHERE o.ortName = :name";
//        Query query = this.getSession().createQuery(queryString);
//        query.setParameter("name", ortName);
//        Burg burg = (Burg) query.uniqueResult();
//        this.closeAll();
//        return burg;
//    }

    public List<Burg> getAllByOrtname(String ortName) {
        String queryString = "FROM Burg b WHERE b.standOrt.ortName = :name";
        Query query = this.getSession().createQuery(queryString);
        query.setParameter("name", ortName);
        List<Burg> burge = query.list();
        this.closeAll();
        return burge;
    }

    public List<Burg> getAll() {
        List burge = this.getSession().createQuery("FROM Burg").list();
        this.closeAll();
        return burge;
    }
}
