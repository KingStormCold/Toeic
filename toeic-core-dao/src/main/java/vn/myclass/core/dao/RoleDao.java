package vn.myclass.core.dao;

import vn.myclass.core.data.dao.GenericDao;
import vn.myclass.core.persistence.entity.*;

import java.util.List;

/**
 * Created by TuanKul on 9/14/2017.
 */
//Integer là do bên lớp RoleEntity roleid có kiểu là Integer
public interface RoleDao extends GenericDao<Integer, RoleEntity> {
    List<RoleEntity> findByRoles(List<String> roles);
}
