package vn.myclass.core.common.utils;

import jdk.jfr.events.ThrowablesEvent;
import org.hibernate.SessionFactory;

import javax.security.auth.login.Configuration;

/**
 * Created by TuanKul on 9/6/2017.
 */
public class HibernateUtil {
    private static final SessionFactory sesstionFactory = buildSessionFactory();
    private static SessionFactory buildSessionFactory(){
        try{
            //create sessionFactory from hibernate.cfg.xml
            // se tra ve 1 thang sessionFactory dc load tu file hibernate.cfg.xml
            return new org.hibernate.cfg.Configuration().configure().buildSessionFactory();
        }
        catch (Throwable e){
            System.out.println("Khong tao duoc session !");
            throw new ExceptionInInitializerError(e);
        }
    }
    public static SessionFactory getSesstionFactory(){
        return sesstionFactory;
    }
}
