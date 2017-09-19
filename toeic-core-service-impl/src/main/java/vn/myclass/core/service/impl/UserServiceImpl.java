package vn.myclass.core.service.impl;

import vn.myclass.core.dao.UserDao;
import vn.myclass.core.daoimpl.UserDaoImpl;
import vn.myclass.core.dto.UserDTO;
import vn.myclass.core.persistence.entity.UserEntity;
import vn.myclass.core.service.UserService;
import vn.myclass.core.util.UserBeanUtil;

/**
 * Created by TuanKul on 9/18/2017.
 */
public class UserServiceImpl implements UserService {
    public UserDTO isUserExist(UserDTO dto) {
        UserDao userDao = new UserDaoImpl();
        UserEntity entity = userDao.isUserExist(dto.getName(),dto.getPassword());
        return UserBeanUtil.entity2Dto(entity);
    }

    public UserDTO findRoleByUser(UserDTO dto) {
        UserDao userDao = new UserDaoImpl();
        UserEntity entity = userDao.findRoleByUser(dto.getName(),dto.getPassword());
        return UserBeanUtil.entity2Dto(entity);
    }
}
