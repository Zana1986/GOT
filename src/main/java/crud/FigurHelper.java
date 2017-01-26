package crud;

import db.HibernateSessionFactorySupportImpl;
import entities.Figur;
import org.hibernate.query.Query;

import java.util.List;

/**
 * Created by Yafei on 10/01/2017.
 */
public class FigurHelper extends HibernateSessionFactorySupportImpl {
    public void addFigur(Figur figur) {
        this.beginTrasaction();
        this.getSession().save(figur);
        this.commitTransaction();
    }

    public void updateFigur(Figur figur) {
        this.beginTrasaction();
        this.getSession().update(figur);
        this.commitTransaction();
    }

    public void deleteFigur(int nummer) {
        this.beginTrasaction();
       // this.getSession().delete(this.getOne(nummer));
        this.commitTransaction();
    }

//    public List<Figur> getAllByStaffel(int figurName) {
//        String queryString = "FROM Figur h WHERE h.name = :name";
//        Query query = this.getSession().createQuery(queryString);
//        query.setParameter("name", figurName);
//        List<Figur> figuren = (List<Figur>) query.list();
//        this.closeAll();
//        return figuren;
//    }

    public Figur getOne(String figurName) {
        String queryString = "FROM Figur f WHERE f.name = :name";
        Query query = this.getSession().createQuery(queryString);
        query.setParameter("name", figurName);
        Figur figur = (Figur) query.uniqueResult();
        this.closeAll();
        return figur;
    }

    public Figur getOneById(int figurid) {
        String queryString = "FROM Figur f WHERE f.id = :fid";
        Query query = this.getSession().createQuery(queryString);
        query.setParameter("fid", figurid);
        Figur figur = (Figur) query.uniqueResult();
        this.closeAll();
        return figur;
    }

    public List<Figur> getAll() {
        List figuren = this.getSession().createQuery("FROM Figur").list();
        this.closeAll();
        return figuren;
    }
}
