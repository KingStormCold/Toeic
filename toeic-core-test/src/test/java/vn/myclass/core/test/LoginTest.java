package vn.myclass.core.test;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;
import vn.myclass.core.dao.UserDao;
import vn.myclass.core.daoimpl.UserDaoImpl;
import vn.myclass.core.persistence.entity.UserEntity;

/**
 * Created by TuanKul on 9/19/2017.
 */
public class LoginTest {
   /* private final Logger log = Logger.getLogger(this.getClass());
    @Test
    public void checkUserExist() {
        UserDao userDao = new UserDaoImpl();
        String name = "tuan";
        String password = "123456";
        UserEntity entity = userDao.isUserExist(name,password);

        if(entity != null){
            log.error("login access");
        }
        else {
            log.error("login fail");
        }
    }
    @Test
    public void checkRoleFindByUser() {
        UserDao userDao = new UserDaoImpl();
        String name = "admin";
        String password = "admin";
        UserEntity entity = userDao.isUserExist(name,password);
        log.error(entity.getRoleEntity().getRoleId()+"-"+entity.getRoleEntity().getName());
    }*/
}
