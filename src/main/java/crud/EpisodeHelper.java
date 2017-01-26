package crud;

import db.HibernateSessionFactorySupportImpl;
import entities.Episode;
import org.hibernate.query.Query;

import java.util.List;

/**
 * Created by Yafei on 10/01/2017.
 */
public class EpisodeHelper extends HibernateSessionFactorySupportImpl {
    public void addEpisode(Episode episode) {
        this.beginTrasaction();
        this.getSession().save(episode);
        this.commitTransaction();
    }

    public void updateEpisode(Episode episode) {
        this.beginTrasaction();
        this.getSession().update(episode);
        this.commitTransaction();
    }

    public void deleteEpisode(int nummer) {
        this.beginTrasaction();
       // this.getSession().delete(this.getOne(nummer));
        this.commitTransaction();
    }

    public Episode getOne(int nummer, int epiNummer) {
        String queryString = "FROM Episode e WHERE e.staffelNummer = :num AND e.epiNummer = :epiNum";
        Query query = this.getSession().createQuery(queryString);
        query.setParameter("num", nummer);
        query.setParameter("epiNum", epiNummer);
        Episode episode = (Episode) query.uniqueResult();
        this.closeAll();
        return episode;
    }

    public List<Episode> getAllByStaffel(int nummer) {
        String queryString = "FROM Episode e WHERE e.staffelNummer = :num";
        Query query = this.getSession().createQuery(queryString);
        query.setParameter("num", nummer);
        List<Episode> episoden = (List<Episode>) query.list();
        this.closeAll();
        return episoden;
    }

    public List<Episode> getAllOrdered() {
        List episoden = this.getSession().createQuery("FROM Episode").list();
        this.closeAll();
        return episoden;
    }

    public List<Episode> getAll() {
        List episoden = this.getSession().createQuery("FROM Episode").list();
        this.closeAll();
        return episoden;
    }
}
