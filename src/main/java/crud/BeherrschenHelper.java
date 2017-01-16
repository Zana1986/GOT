package crud;

import db.HibernateSessionFactorySupportImpl;
import entities.Beherrschen;
import org.hibernate.query.Query;

import java.util.List;

/**
 * Created by Yafei on 10/01/2017.
 */
public class BeherrschenHelper extends HibernateSessionFactorySupportImpl {
    public void addBeherrschen(Beherrschen beherrschen) {
        this.beginTrasaction();
        this.getSession().save(beherrschen);
        this.commitTransaction();
    }

    public void updateBeherrschen(Beherrschen beherrschen) {
        this.beginTrasaction();
        this.getSession().update(beherrschen);
        this.commitTransaction();
    }

    public void deleteBeherrschen(int nummer) {
        this.beginTrasaction();
       // this.getSession().delete(this.getOne(nummer));
        this.commitTransaction();
    }

    public List getAllByHaus(String hausName) {
        String queryString = "FROM Beherrschen a WHERE a.haus.name = :hName";
        Query query = this.getSession().createQuery(queryString);
        query.setParameter("hName", hausName);
        List beherrschen =  query.list();
        this.closeAll();
        return beherrschen;
    }

    public List<Beherrschen> getAll() {
        List beherrschen = this.getSession().createQuery("FROM Beherrschen").list();
        this.closeAll();
        return beherrschen;
    }
}
