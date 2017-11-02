package vn.myclass.core.dao;

import vn.myclass.core.data.dao.GenericDao;
import vn.myclass.core.persistence.entity.UserEntity;

import java.util.List;

/**
 * Created by TuanKul on 9/18/2017.
 */
public interface UserDao extends GenericDao<Integer, UserEntity> {
    Object[] checkLogin(String name, String password);
    List<UserEntity> findByUsers(List<String> names);
}
