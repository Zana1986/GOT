package crud;

import db.HibernateSessionFactorySupportImpl;
import entities.EpisodeBewertung;
import org.hibernate.query.Query;

import java.util.List;

/**
 * Created by Yafei on 10/01/2017.
 */
public class EpisodeBewertungHelper extends HibernateSessionFactorySupportImpl {

    public void addEpisodeBewertung(EpisodeBewertung episodewertung) {
        this.beginTrasaction();
        this.getSession().save(episodewertung);
        this.commitTransaction();
    }

    public void updateEpisodeBewertung(EpisodeBewertung episodewertung) {
        this.beginTrasaction();
        this.getSession().update(episodewertung);
        this.commitTransaction();
    }

    public void deleteEpisodeBewertung(int nummer) {
        this.beginTrasaction();
        //this.getSession().delete(this.getOne();
        this.commitTransaction();
    }

    public int getAllByEpisode(int nummer, int epiNummer) {
        String queryString = "SELECT AVG(eb.rating) FROM EpisodeBewertung eb " +
                "WHERE (eb.episode.staffelNummer = :sNum and eb.episode.epiNummer = :eNum)";
        Query query = this.getSession().createQuery(queryString);
        query.setParameter("sNum", nummer);
        query.setParameter("eNum", epiNummer);
        List<Double> ratings = (List<Double>) query.list();;
        int rating = 0;
        if (ratings != null || !ratings.isEmpty()) {
            if (ratings.get(0) != null) {
                rating = (int) Math.round(ratings.get(0));
            }
        }
        this.closeAll();
        return rating;
    }

    public List<EpisodeBewertung> getAll() {
        List episodewertungen = this.getSession().createQuery("FROM EpisodeBewertung").list();
        this.closeAll();
        return episodewertungen;
    }
}
