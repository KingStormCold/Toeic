package vn.myclass.core.daoimpl;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import vn.myclass.core.common.utils.HibernateUtil;
import vn.myclass.core.dao.UserDao;
import vn.myclass.core.data.daoimpl.AbstractDao;
import vn.myclass.core.persistence.entity.UserEntity;

/**
 * Created by TuanKul on 9/18/2017.
 */
public class UserDaoImpl extends AbstractDao<Integer,UserEntity> implements UserDao {

    public UserEntity isUserExist(String name, String password) {
        UserEntity entity = new UserEntity();
        Session session = HibernateUtil.getSesstionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        try{
            //HQL
            StringBuilder sql = new StringBuilder("FROM UserEntity WHERE name= :name AND password= :password");
            Query query = session.createQuery(sql.toString());
            query.setParameter("name",name);
            query.setParameter("password",password);
            entity = (UserEntity) query.uniqueResult();
            transaction.commit();
        }catch (HibernateException e) {
            transaction.rollback();
            throw  e;
        }
        finally {
            session.close();
        }
        return entity;
    }

    public UserEntity findRoleByUser(String name, String password) {
        UserEntity entity = new UserEntity();
        Session session = HibernateUtil.getSesstionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        try{
            //HQL
            StringBuilder sql = new StringBuilder("FROM UserEntity WHERE name= :name AND password= :password");
            Query query = session.createQuery(sql.toString());
            query.setParameter("name",name);
            query.setParameter("password",password);
            entity = (UserEntity) query.uniqueResult();
            transaction.commit();
        }catch (HibernateException e) {
            transaction.rollback();
            throw  e;
        }
        finally {
            session.close();
        }
        return entity;
    }
}
