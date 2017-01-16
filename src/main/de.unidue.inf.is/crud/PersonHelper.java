package crud;

import db.HibernateSessionFactorySupportImpl;
import entities.Person;
import org.hibernate.query.Query;

import java.util.List;

/**
 * Created by Yafei on 10/01/2017.
 */
public class PersonHelper extends HibernateSessionFactorySupportImpl {
    public void addPerson(Person person) {
        this.beginTrasaction();
        this.getSession().save(person);
        this.commitTransaction();
    }

    public void updatePerson(Person person) {
        this.beginTrasaction();
        this.getSession().update(person);
        this.commitTransaction();
    }

    public void deletePerson(int nummer) {
        this.beginTrasaction();
       // this.getSession().delete(this.getOne(nummer));
        this.commitTransaction();
    }

    public List<Person> getAllByStaffel(int personName) {
        String queryString = "FROM Person h WHERE h.name = :name";
        Query query = this.getSession().createQuery(queryString);
        query.setParameter("name", personName);
        List<Person> personen = (List<Person>) query.list();
        this.closeAll();
        return personen;
    }

    public List<Person> getAll() {
        List personen = this.getSession().createQuery("FROM Person").list();
        this.closeAll();
        return personen;
    }
}
