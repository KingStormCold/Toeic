package vn.myclass.core.test;

import org.testng.annotations.Test;
import vn.myclass.core.dao.RoleDao;
import vn.myclass.core.daoimpl.RoleDaoImpl;
import vn.myclass.core.persistence.entity.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by TuanKul on 9/14/2017.
 */
public class RoleTest {
    /*@Test
    public void checkFindAll() {
        RoleDao roleDao = new RoleDaoImpl();
        List<RoleEntity> list = roleDao.findAll();
    }

    @Test
    public void checkUpdateRole() {
        RoleDao roleDao = new RoleDaoImpl();
        RoleEntity entity = new RoleEntity();
        entity.setRoleId(3);
        entity.setName("USER");
        roleDao.update(entity);
    }

    @Test
    public void checkSaveRole() {
        RoleDao roleDao = new RoleDaoImpl();
        RoleEntity entity = new RoleEntity();
        entity.setRoleId(1);
        entity.setName("ADMIN");
        RoleEntity entity2 = new RoleEntity();
        entity2.setRoleId(2);
        entity2.setName("USER");
        roleDao.save(entity);
        roleDao.save(entity2);
    }

    @Test
    public void checkFindByIdRole() {
        RoleDao roleDao = new RoleDaoImpl();
        RoleEntity entity = roleDao.findById(1);
    }

    @Test
    public void checkFindByProperty() {
        RoleDao roleDao = new RoleDaoImpl();
        String property = null;
        Object value = null;
        String sortExpression = null;
        String sortDirection = null;
        Object[] objects = roleDao.finByProperty(property, value, sortExpression, sortDirection);
    }

    @Test
    public void checkDeleteRole() {
        RoleDao roleDao = new RoleDaoImpl();
        List<Integer> listId = new ArrayList<Integer>();
        listId.add(1);
        listId.add(2);
        listId.add(3);
        Integer count = roleDao.delete(listId);
    }*/
}
