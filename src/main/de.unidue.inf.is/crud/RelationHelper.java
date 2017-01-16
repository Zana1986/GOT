package crud;

import db.HibernateSessionFactorySupportImpl;
import entities.Person;
import entities.Relation;
import org.hibernate.Criteria;
import org.hibernate.query.Query;

import java.util.List;

/**
 * Created by Yafei on 10/01/2017.
 */
public class RelationHelper extends HibernateSessionFactorySupportImpl {
    public void addRelation(Relation relation) {
        this.beginTrasaction();
        this.getSession().save(relation);
        this.commitTransaction();
    }

    public void updateRelation(Relation relation) {
        this.beginTrasaction();
        this.getSession().update(relation);
        this.commitTransaction();
    }

    public void deleteRelation(int nummer) {
        this.beginTrasaction();
       // this.getSession().delete(this.getOne(nummer));
        this.commitTransaction();
    }

    public List<Relation> getAllByStaffel(int relationName) {
        String queryString = "FROM Relation r WHERE r.id.figurida = :sId";
        Query query = this.getSession().createQuery(queryString);
        query.setParameter("sId", relationName);
        List<Relation> relationen = (List<Relation>) query.list();
        this.closeAll();
        return relationen;
    }

    public List<Relation> getAll() {
        List relationen = this.getSession().createQuery("FROM Relation").list();
        this.closeAll();
        return relationen;
    }

    public List getAllWithPeronen() {
        String queryString = "SELECT r.figurida, r.figuridb, f1.name as namea, f2.name as nameb FROM beziehung r " +
                "INNER JOIN person p1 ON(r.figurida = p1.figurid)" +
                "INNER JOIN Person p2 ON(r.figuridb = p2.figurid) " +
                "LEFT OUTER JOIN figur f1 ON(f1.figurid=r.figurida) " +
                "LEFT OUTER JOIN figur f2 ON(f2.figurid=r.figuridb)";
        Query query = this.getSession().createNativeQuery(queryString);
        List relationen = query.list();

        this.closeAll();
        return relationen;
    }
}
