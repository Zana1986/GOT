package crud;

import db.HibernateSessionFactorySupportImpl;
import entities.Benutzer;
import entities.Episode;
import entities.Playliste;
import org.hibernate.query.Query;

import java.util.List;

/**
 * Created by Yafei on 10/01/2017.
 */
public class PlaylisteHelper extends HibernateSessionFactorySupportImpl {
    public void addPlayliste(Playliste playliste) {
        this.beginTrasaction();
        this.getSession().save(playliste);
        this.commitTransaction();
    }

    public void updatePlayliste(Playliste playliste) {
        this.beginTrasaction();
        this.getSession().update(playliste);
        this.commitTransaction();
    }

    public void deletePlayliste(int nummer) {
        this.beginTrasaction();
       // this.getSession().delete(this.getOne(nummer));
        this.commitTransaction();
    }

    public Playliste neuePlayliste(String loginKennung) {
        BenutzerHelper benutzerHelper = new BenutzerHelper();
        Benutzer benutzer = benutzerHelper.getOne(loginKennung);
        if (benutzer == null) return null;

        EpisodeHelper episodeHelper = new EpisodeHelper();
        List<Episode> episoden = episodeHelper.getAll();
        Playliste p = new Playliste(benutzer);
        p.setEpisoden(episoden);
        this.addPlayliste(p);

        return p;
    }

    public Playliste getOne(int id) {
        String queryString = "FROM Playliste p WHERE p.id = :id";
        Query query = this.getSession().createQuery(queryString);
        query.setParameter("id", id);
        return (Playliste) query.uniqueResult();
    }

    public List<Playliste> getAll() {
        List playlisten = this.getSession().createQuery("FROM Playliste").list();
        this.closeAll();
        return playlisten;
    }
}
