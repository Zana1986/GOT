package crud;

import db.HibernateSessionFactorySupportImpl;
import entities.*;
import org.hibernate.query.Query;

import java.util.List;

/**
 * Created by Yafei on 10/01/2017.
 */
public class BewertungHelper extends HibernateSessionFactorySupportImpl {

    public void addBewertung(Bewertung wertung) {
        this.beginTrasaction();
        this.getSession().save(wertung);
        this.commitTransaction();
    }

    public void updateBewertung(Bewertung wertung) {
        this.beginTrasaction();
        this.getSession().update(wertung);
        this.commitTransaction();
    }

    public void deleteBewertung(Bewertung wertung) {
//        Bewertung b = this.getOne(benutzerId);
        // get persistented object
//        Object o = this.getSession().load(Bewertung.class, new BewertungPK(b.getBewertungid(), b.getBenutzerid()));
        this.beginTrasaction();
        this.getSession().delete(wertung);
        this.commitTransaction();
    }

    public Bewertung getOne(int benutzerId) {
        String queryString = "FROM Bewertung b WHERE b.benutzer.id = :id";
        Query query = this.getSession().createQuery(queryString);
        query.setParameter("id", benutzerId);
        Bewertung bewertung = (Bewertung) query.uniqueResult();
        this.closeAll();

        return bewertung;
    }

    public int getDurchschnitt() {
        String queryString = "SELECT AVG(rating) FROM Bewertung";
        Query query = this.getSession().createQuery(queryString);
        Double d = (Double) query.uniqueResult();
        this.closeAll();
        if (d != null) {
            int avgRating = (int) Math.round(d);
            return avgRating;
        } else {
            return 0;
        }
    }

    public HausBewertung isExistedByHaus(int benutzerId, int hausid) {
        String queryString = "FROM HausBewertung h WHERE h.benutzer.id = :bid AND h.haus.id = :hid";
        Query query = this.getSession().createQuery(queryString);
        query.setParameter("bid", benutzerId);
        query.setParameter("hid", hausid);
        HausBewertung hausBewertung = (HausBewertung) query.uniqueResult();
        this.closeAll();

        return hausBewertung;
    }

    public FigurBewertung isExistedByFigur(int benutzerId, int figurid) {
        String queryString = "FROM FigurBewertung f WHERE f.benutzer.id = :bid AND f.figur.id = :fid";
        Query query = this.getSession().createQuery(queryString);
        query.setParameter("bid", benutzerId);
        query.setParameter("fid", figurid);
        FigurBewertung figurBewertung = (FigurBewertung) query.uniqueResult();
        this.closeAll();

        return figurBewertung;
    }

    public StaffelBewertung isExistedByStaffel(int benutzerId, int staffelnummer) {
        String queryString = "FROM StaffelBewertung s WHERE s.benutzer.id = :bid AND s.staffel.id = :nummer";
        Query query = this.getSession().createQuery(queryString);
        query.setParameter("bid", benutzerId);
        query.setParameter("nummer", staffelnummer);
        StaffelBewertung staffelBewertung = (StaffelBewertung) query.uniqueResult();
        this.closeAll();

        return  staffelBewertung;
    }

    public EpisodeBewertung isExistedByEpisode(int benutzerId, int staffelnummer, int episodenummer) {
        String queryString = "FROM EpisodeBewertung e WHERE e.benutzer.id = :bid " +
                "AND e.episode.staffelNummer = :nummer AND e.episode.epiNummer = :epiNummer";
        Query query = this.getSession().createQuery(queryString);
        query.setParameter("bid", benutzerId);
        query.setParameter("nummer", staffelnummer);
        query.setParameter("epiNummer", episodenummer);
        EpisodeBewertung episodeBewertung = (EpisodeBewertung) query.uniqueResult();
        this.closeAll();

        return episodeBewertung;
    }

    public List<Bewertung> getAll() {
        List<Bewertung> wertungen = this.getSession().createQuery("FROM Bewertung").list();
        this.closeAll();
        return wertungen;
    }
}
