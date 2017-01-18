package crud;

import db.HibernateSessionFactorySupportImpl;
import entities.Tier;
import org.hibernate.query.Query;

import java.util.List;

/**
 * Created by Yafei on 10/01/2017.
 */
public class TierHelper extends HibernateSessionFactorySupportImpl {
    public void addTier(Tier tier) {
        this.beginTrasaction();
        this.getSession().save(tier);
        this.commitTransaction();
    }

    public void updateTier(Tier tier) {
        this.beginTrasaction();
        this.getSession().update(tier);
        this.commitTransaction();
    }

    public void deleteTier(int nummer) {
        this.beginTrasaction();
       // this.getSession().delete(this.getOne(nummer));
        this.commitTransaction();
    }

    public List<Tier> getAllByPerson(String personName) {
        String queryString = "FROM Tier t WHERE t.person.name = :name";
        Query query = this.getSession().createQuery(queryString);
        query.setParameter("name", personName);
        List<Tier> tieren = (List<Tier>) query.list();
        this.closeAll();
        return tieren;
    }

    public Tier getOneByName(String tierName) {
        String queryString = "FROM Tier t WHERE t.name = :name";
        Query query = this.getSession().createQuery(queryString);
        query.setParameter("name", tierName);
        Tier tier = (Tier) query.uniqueResult();
        this.closeAll();
        return tier;
    }

    public List<Tier> getAll() {
        List tiere = this.getSession().createQuery("FROM Tier").list();
        this.closeAll();
        return tiere;
    }
}
