package vn.myclass.core.service.impl;

import vn.myclass.core.dao.RoleDao;
import vn.myclass.core.daoimpl.RoleDaoImpl;
import vn.myclass.core.dto.RoleDTO;
import vn.myclass.core.persistence.entity.RoleEntity;
import vn.myclass.core.service.RoleService;
import vn.myclass.core.service.utils.SingletonDaoUtil;
import vn.myclass.core.util.RoleBeanUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by TuanKul on 10/23/2017.
 */
public class RoleServiceImpl implements RoleService {
    public List<RoleDTO> findAll() {
        List<RoleEntity> entities = SingletonDaoUtil.getRoleDaoInstance().findAll();
        List<RoleDTO> dtos = new ArrayList<RoleDTO>();
        for(RoleEntity item:entities) {
            RoleDTO dto = RoleBeanUtil.entity2Dto(item);
            dtos.add(dto);
        }
        return  dtos;
    }
}
