package db;

import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * Created by Yafei on 10/01/2017.
 */
public class HibernateSessionFactorySupportImpl implements IHibernateSessionFactorySupport {
    private Transaction transaction = null;

    @Override
    public Session getSession() {
        return DBUtil.getSession();
    }

    @Override
    public void beginTrasaction() {
        transaction = this.getSession().beginTransaction();
    }

    @Override
    public void commitTransaction() {
        try {
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            closeAll();
        }

    }

    @Override
    public void closeAll() {
        DBUtil.closeSession();
    }
}
