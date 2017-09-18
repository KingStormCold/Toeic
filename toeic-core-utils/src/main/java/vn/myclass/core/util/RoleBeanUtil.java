package vn.myclass.core.util;

import vn.myclass.core.dto.RoleDTO;
import vn.myclass.core.persistence.entity.RoleEntity;

/**
 * Created by TuanKul on 9/18/2017.
 */
//chuyen doi entity qua dto va nguoc lai
public class RoleBeanUtil {
    //entity qua dto
    public static RoleDTO entity2Dto (RoleEntity entity) {
        RoleDTO dto = new RoleDTO();
        dto.setRoleId(entity.getRoleId());
        dto.setName(entity.getName());
        return dto;
    }
    public static RoleEntity dto2Entity (RoleDTO dto) {
        RoleEntity entity = new RoleEntity();
        entity.setRoleId(dto.getRoleId());
        entity.setName(dto.getName());
        return entity;
    }
}
