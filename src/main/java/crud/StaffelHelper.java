package crud;

import db.HibernateSessionFactorySupportImpl;
import entities.Staffel;

import java.util.List;

/**
 * Created by Yafei on 10/01/2017.
 */
public class StaffelHelper extends HibernateSessionFactorySupportImpl {
    public void addStaffel(Staffel staffel) {
        this.beginTrasaction();
        this.getSession().save(staffel);
        this.commitTransaction();
    }

    public void updateStaffel(Staffel staffel) {
        this.beginTrasaction();
        this.getSession().update(staffel);
        this.commitTransaction();
    }

    public void deleteStaffel(int nummer) {
        this.beginTrasaction();
        this.getSession().delete(this.getOne(nummer));
        this.commitTransaction();
    }

    public Staffel getOne(int nummer) {
        Staffel staffel = this.getSession().get(Staffel.class, nummer);
        this.closeAll();
        return staffel;
    }

    public List<Staffel> getAll() {
        List staffeln = this.getSession().createQuery("FROM Staffel").list();
        this.closeAll();
        return staffeln;
    }
}
