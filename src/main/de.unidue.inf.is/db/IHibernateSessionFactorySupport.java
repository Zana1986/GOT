package db;

import org.hibernate.Session;

/**
 * Created by Yafei on 10/01/2017.
 */
public interface IHibernateSessionFactorySupport {
    public Session getSession();
    public void beginTrasaction();
    public void commitTransaction();
    public void closeAll();
}
