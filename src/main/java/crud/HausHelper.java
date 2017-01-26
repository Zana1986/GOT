package crud;

import db.HibernateSessionFactorySupportImpl;
import entities.Haus;
import org.hibernate.query.Query;

import java.util.List;

/**
 * Created by Yafei on 10/01/2017.
 */
public class HausHelper extends HibernateSessionFactorySupportImpl {
    public void addHaus(Haus haus) {
        this.beginTrasaction();
        this.getSession().save(haus);
        this.commitTransaction();
    }

    public void updateHaus(Haus haus) {
        this.beginTrasaction();
        this.getSession().update(haus);
        this.commitTransaction();
    }

    public void deleteHaus(int nummer) {
        this.beginTrasaction();
       // this.getSession().delete(this.getOne(nummer));
        this.commitTransaction();
    }

    public Haus getOne(String hausName) {
        String queryString = "FROM Haus h WHERE h.name = :name";
        Query query = this.getSession().createQuery(queryString);
        query.setParameter("name", hausName);
        Haus haus = (Haus) query.uniqueResult();
        this.closeAll();
        return haus;
    }

    public Haus getOneById(int hausid) {
        String queryString = "FROM Haus h WHERE h.id = :hid";
        Query query = this.getSession().createQuery(queryString);
        query.setParameter("hid", hausid);
        Haus haus = (Haus) query.uniqueResult();
        this.closeAll();
        return haus;
    }

    public List<Haus> getAll() {
        List haeusern = this.getSession().createQuery("FROM Haus").list();
        this.closeAll();
        return haeusern;
    }
}
