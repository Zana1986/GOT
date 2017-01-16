import entities.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Date;
import java.util.List;

/**
 * Created by Yafei on 06/01/2017.
 */
public class main {
    public static void main(String[] args) {
//        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ws2016.got.jpa");
//        EntityManager entityManager = entityManagerFactory.createEntityManager();
//        entityManager.getTransaction().begin();
//        entityManager.persist(new Figur("apple", new Ort("Duisbug")));
//        entityManager.getTransaction().commit();
//        entityManager.close();
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        Session session = factory.openSession();
        Transaction ta = session.beginTransaction();

        Ort ho1 = new Ort("Essen");
        Ort ho2 = new Ort("Bochum");
        Figur f = new Figur("apple", ho1);
//        Person p1 = new Person("John", ho1, "Knight", "Winter Fall");
//        Person p2 = new Person("Snow", ho1, "Knight", "Winter Fall");
        Person p1 = (Person) session.createQuery("FROM Person WHERE id=3").getSingleResult();
        Person p2 = (Person) session.createQuery("FROM Person WHERE id=4").getSingleResult();
//        session.update(p1);
//        session.update(p2);
        System.out.print(p1.getName() + ' ' + p1.getId());

        RelationsId relationsId = new RelationsId(p1.getId(), p2.getId());
        Relation freund1 = new Relation();
        freund1.setId(relationsId);
        freund1.setRelationsTyp("self");
//        p1.getRelations().add(freund1);
        session.save(freund1);
        session.getTransaction().commit();
        session.close();
        factory.close();

//        Staffel s1 = new Staffel(1, 12, new Date());
//        EpisodePK e1pk = new EpisodePK(1, 1);
//        EpisodePK e2pk = new EpisodePK(1, 2);
//        Episode e1 = new Episode(1, 1, "Winter is coming", "None", new Date(), s1);
//        Episode e2 = new Episode(1, 2, "Winter is coming", "None", new Date(), s1);
//        Session session = factory.openSession();
//        Transaction ta = session.beginTransaction();
//        session.save(e1);
////        session.save(e2);

        //auftretenIn
//        Figur f1  = new Figur("orange", ho);
//        Figur f2  = new Figur("ananas", ho);
//
//        Staffel s1 = new Staffel(1, 12, new Date());
//        Episode e1 = new Episode(1, 5, "Winter is coming", "None", new Date(), null);
//        Episode e2 = new Episode(1, 6, "Winter is coming", "None", new Date(), null);
//        Session session = factory.openSession();
//        session.beginTransaction();
//        session.save(f1);
//        session.save(f2);
//
//        session.save(e1);
//        session.save(e2);
//
//        f1.addEpisode(e1);
//        f1.addEpisode(e2);
//
//        f2.addEpisode(e1);
////        session.flush();
//        f1.removeEpisode(e1);
//        session.getTransaction().commit();

        //angehoert
//        Person p1 = new Person("banana", ho, "Obst", "gegessen");
//        Burg b1 = new Burg("Winterfall", ho);
//        Haus h1 = new Haus("snows", "Winter", "Sword", b1);
//        Episode es1 = new Episode(1, 3, "Winter is coming", "None", new Date(), null);
//        Episode ee1 = new Episode(1, 4, "Winter is coming", "None", new Date(), null);
//        Session session = factory.openSession();
//        session.beginTransaction();
//        session.save(p1);
//        session.save(h1);
//
//        p1.addHaus(h1, es1, ee1);
//        session.getTransaction().commit();

        //ansehen
//        Burg b1 = new Burg("Blackwater", ho1);
//        Burg b2 = new Burg("Whitehouse", ho2);
//        Haus h1 = new Haus("yan", "W", "Gabel", b1);
//        Haus h2 = new Haus("Li", "M", "Messe", b1);
//
//        Session session = factory.openSession();
//        session.beginTransaction();
//        session.save(b1);
//        session.save(b2);
//        session.save(h1);
//        session.save(h2);
//
//        b2.addHaus(h1);
//        b2.addHaus(h2);

        //beherrschen
//        Burg b1 = new Burg("Blackwater", ho1);
//        Haus h1 = new Haus("Xie", "W", "Gabel", b1);
//        Ort o1 = new Ort("Lianhua");
//
//        Episode e1 = new Episode(1, 5, "Winter is coming", "None", new Date(), null);
//        Episode e2 = new Episode(1, 6, "Winter is coming", "None", new Date(), null);
//
//
//        Session session = factory.openSession();
//        session.beginTransaction();
//        session.save(h1);
//        session.save(o1);
//        h1.addOrt(o1, e1, e2);
//        session.getTransaction().commit();

        //handlungsort
//        Staffel s1 = new Staffel(1, 12, new Date());
//        Episode e1 = new Episode(1, 5, "Winter is coming", "None", new Date(), s1);
//        Ort o1 = new Ort("Lianhua");
//        Ort o2 = new Ort("Pingxiang");
//        Session session = factory.openSession();
//        session.beginTransaction();
//        session.update(e1);
//        session.save(o1);
//        e1.addHOrt(o1);
//        session.getTransaction().commit();

        //enthalten
//        Staffel s1 = new Staffel(1, 12, new Date());
//        Episode e1 = new Episode(1, 5, "Winter is coming", "None", new Date(), s1);
//        Episode e2 = new Episode(1, 6, "Winter is coming", "None", new Date(), s1);
//        Benutzer b1 = new Benutzer("user1", "user1", "user1kennung");
//        Playliste p1 = new Playliste(b1);
//        Session session = factory.openSession();
//        session.beginTransaction();
//        session.save(p1);
//        p1.addEpisode(e1);
//        p1.addEpisode(e2);
//        session.getTransaction().commit();


//        Burg b1 = new Burg("KingCastle", ho1);
//        Haus h1 = new Haus("Xiaoshui", "Friendly", "Stick", b1);
//        Figur f1 = new Figur("Dragon", ho1);
//        Staffel s1 = new Staffel(1, 12, new Date());
//        Episode e1 = new Episode(1, 5, "Winter is coming", "None", new Date(), s1);
//
//        FigurBewertung fb1 = new FigurBewertung(1, 2, "Good", Bewertung.RatingLevel.FIVE, f1);
//        EpisodeBewertung eb1 = new EpisodeBewertung(2, 2, "Good", Bewertung.RatingLevel.FIVE, e1);
//        StaffelBewertung sf1 = new StaffelBewertung(3, 2, "Good", Bewertung.RatingLevel.FIVE, s1);
//        HausBewertung hb1 = new HausBewertung(4, 2, "Good", Bewertung.RatingLevel.FIVE, h1);
//
//
//        Session session = factory.openSession();
//        session.beginTransaction();
//        session.update(fb1);
//        session.update(eb1);
//        session.update(sf1);
//        session.saveOrUpdate(hb1);
//        session.getTransaction().commit();
//        session.close();
//        factory.close();


    }
}
