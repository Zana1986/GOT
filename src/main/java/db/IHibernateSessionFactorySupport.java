package db;

import org.hibernate.Session;

/**
 * Created by Yafei on 10/01/2017.
 */
public interface IHibernateSessionFactorySupport {
    Session getSession();
    void beginTrasaction();
    void commitTransaction();
    void closeAll();
}
