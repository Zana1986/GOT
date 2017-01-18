package crud;

import db.HibernateSessionFactorySupportImpl;
import entities.Ort;
import org.hibernate.query.Query;

import java.util.List;

/**
 * Created by Yafei on 10/01/2017.
 */
public class OrtHelper extends HibernateSessionFactorySupportImpl {
    public void addOrt(Ort ort) {
        this.beginTrasaction();
        this.getSession().save(ort);
        this.commitTransaction();
    }

    public void updateOrt(Ort ort) {
        this.beginTrasaction();
        this.getSession().update(ort);
        this.commitTransaction();
    }

    public void deleteOrt(int nummer) {
        this.beginTrasaction();
       // this.getSession().delete(this.getOne(nummer));
        this.commitTransaction();
    }

//    public List<Ort> getAllByPerson(String personName) {
//        String queryString = "FROM Ort t WHERE t.person.name = :name";
//        Query query = this.getSession().createQuery(queryString);
//        query.setParameter("name", personName);
//        List<Ort> orten = (List<Ort>) query.list();
//        this.closeAll();
//        return orten;
//    }

    public Ort getOneByName(String ortName) {
        String queryString = "FROM Ort o WHERE o.ortName = :name";
        Query query = this.getSession().createQuery(queryString);
        query.setParameter("name", ortName);
        Ort ort = (Ort) query.uniqueResult();
        this.closeAll();
        return ort;
    }


    public List<Ort> getAll() {
        List orte = this.getSession().createQuery("FROM Ort").list();
        this.closeAll();
        return orte;
    }
}
