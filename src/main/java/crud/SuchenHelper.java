package crud;

import db.HibernateSessionFactorySupportImpl;
import entities.Figur;
import entities.Haus;
import entities.Playliste;
import entities.Staffel;
import org.hibernate.query.Query;

import java.util.List;

/**
 * Created by Yafei on 10/01/2017.
 */
public class SuchenHelper extends HibernateSessionFactorySupportImpl {


    public List<Figur> getFigurLimit(int limit) {
        Query query = this.getSession().createQuery("FROM Figur f");
        query.setMaxResults(limit);
        List<Figur> figuren = query.list();
        this.closeAll();
        return figuren;
    }

    public List<Haus> getHausLimit(int limit) {
        Query query = this.getSession().createQuery("FROM Haus h");
        query.setMaxResults(limit);
        List<Haus> Haeuser = query.list();
        this.closeAll();
        return Haeuser;
    }

    public List<Staffel> getStaffelLimit(int limit) {
        Query query = this.getSession().createQuery("FROM Staffel s");
        query.setMaxResults(limit);
        List<Staffel> Staffeln = query.list();
        this.closeAll();
        return Staffeln;
    }

    public List<Playliste> getPlaylisteLimit(int limit) {
        Query query = this.getSession().createQuery("FROM Playliste p");
        query.setMaxResults(limit);
        List<Playliste> playlisten = query.list();
        this.closeAll();
        return playlisten;
    }

    public List<Figur> getFigurLike(String inhalt) {
        Query query = this.getSession().createQuery("FROM Figur f WHERE (f.name LIKE :inhalt " +
                "OR f.herkunftsort.ortName LIKE :inhalt) ORDER BY f.id");
        query.setParameter("inhalt", '%'+inhalt+'%');
        //query.setMaxResults(5);
        List<Figur> figuren = query.list();
        if (figuren != null && !figuren.isEmpty()) {
            this.closeAll();
            return figuren;
        } else {
            query = this.getSession().createQuery("FROM Person p WHERE (p.titel LIKE :inhalt)");
            query.setParameter("inhalt", '%'+inhalt+'%');
            query.setMaxResults(5);
            figuren = query.list();
            this.closeAll();
            return figuren;
        }
    }

    public List<Haus> getHausLike(String inhalt) {
        Query query = this.getSession().createQuery("FROM Haus h WHERE (h.name LIKE :inhalt) ORDER BY h.id");
        query.setParameter("inhalt", '%'+inhalt+'%');
        //query.setMaxResults(5);
        List<Haus> Haeuser = query.list();
        this.closeAll();
        return Haeuser;
    }

    public List<Staffel> getStaffelLike(int inhalt) {
        Query query = this.getSession().createQuery("FROM Staffel s WHERE (s.nummer = :inhalt) ORDER BY s.nummer");
        query.setParameter("inhalt", inhalt);
        //query.setMaxResults(5);
        List<Staffel> Staffeln = query.list();
        this.closeAll();
        return Staffeln;
    }

    public List<Playliste> getPlaylisteLike(int inhalt) {
        Query query = this.getSession().createQuery("FROM Playliste p WHERE (p.id = :inhalt) order by p.id");
        query.setParameter("inhalt", inhalt);
        //query.setMaxResults(5);
        List<Playliste> playlisten = query.list();
        this.closeAll();
        return playlisten;
    }
}
