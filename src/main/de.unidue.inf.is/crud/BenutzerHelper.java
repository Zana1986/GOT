package crud;

import db.HibernateSessionFactorySupportImpl;
import entities.Benutzer;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * Created by Yafei on 10/01/2017.
 */
public class BenutzerHelper extends HibernateSessionFactorySupportImpl {
    public void addBenutzer(Benutzer benutzer) {
        this.beginTrasaction();
        this.getSession().save(benutzer);
        this.commitTransaction();
    }

    public void updateBenutzer(Benutzer benutzer) {
        this.beginTrasaction();
        this.getSession().update(benutzer);
        this.commitTransaction();
    }

    public void deleteBenutzer(int nummer) {
        this.beginTrasaction();
       // this.getSession().delete(this.getOne(nummer));
        this.commitTransaction();
    }

    public boolean isExisted(String loginkennung) {
        Query query = this.getSession().createQuery("FROM Benutzer b WHERE b.loginKennung = :kennung");
        query.setParameter("kennung", loginkennung);
        return query.uniqueResult() != null;
    }

    public boolean checkUser(String loginkennung, String passwort) {
        Criteria criteria = this.getSession().createCriteria(Benutzer.class);
        Benutzer b = (Benutzer) criteria.add(Restrictions.eq("loginKennung", loginkennung)).uniqueResult();
        this.closeAll();
        if (b.getPasswort().equals(passwort)) {
            return true;
        } else {
            return false;
        }
    }

    public List getAllByLoginkennung(String loginKennung) {
        String queryString = "SELECT b, p FROM Benutzer b INNER JOIN Playliste p ON(b.id=p.benutzer.id) WHERE b.loginKennung = :kennung";
        Query query = this.getSession().createQuery(queryString);
        query.setParameter("kennung", loginKennung);
        List benutzerPlayliste =  query.list();
        this.closeAll();
        return benutzerPlayliste;
    }

    public List<Benutzer> getAll() {
        List benutzer = this.getSession().createQuery("FROM Benutzer").list();
        this.closeAll();
        return benutzer;
    }
}
