package crud;

import db.HibernateSessionFactorySupportImpl;
import entities.AuftretenIn;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;

import java.util.List;

/**
 * Created by Yafei on 10/01/2017.
 */
public class AuftretenInHelper extends HibernateSessionFactorySupportImpl {
    public void addAuftretenIn(AuftretenIn auftretenIn) {
        this.beginTrasaction();
        this.getSession().save(auftretenIn);
        this.commitTransaction();
    }

    public void updateAuftretenIn(AuftretenIn auftretenIn) {
        this.beginTrasaction();
        this.getSession().update(auftretenIn);
        this.commitTransaction();
    }

    public void deleteAuftretenIn(int nummer) {
        this.beginTrasaction();
       // this.getSession().delete(this.getOne(nummer));
        this.commitTransaction();
    }

    public List getAllByEpisode(int staffelNummer, int episodeNummer) {
        String queryString = "FROM AuftretenIn a WHERE a.episode.staffelNummer = :sNummer AND a.episode.epiNummer = :eNummer";
        Query query = this.getSession().createQuery(queryString);
        query.setParameter("sNummer", staffelNummer);
        query.setParameter("eNummer", episodeNummer);
        List figurenInEpisode =  query.list();
        this.closeAll();
        return figurenInEpisode;
    }

    public List<AuftretenIn> getAll() {
        List auftretenIn = this.getSession().createQuery("FROM AuftretenIn").list();
        this.closeAll();
        return auftretenIn;
    }
}
