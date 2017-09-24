package vn.myclass.core.service.impl;

import vn.myclass.core.dao.ListenGuidelineDao;
import vn.myclass.core.daoimpl.ListenGuidelineDaoImpl;
import vn.myclass.core.dto.ListenGuidelineDTO;
import vn.myclass.core.persistence.entity.ListenGuidelineEntity;
import vn.myclass.core.service.ListenGuidelineService;
import vn.myclass.core.util.ListenGuidelineUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by TuanKul on 9/24/2017.
 */
public class ListenGuidelineServiceImpl implements ListenGuidelineService {
    private ListenGuidelineDao listenGuidelineDao = new ListenGuidelineDaoImpl();
    /*public Object[] findListenGuidelineByProperties(String property, Object value, String sortExpression, String sortDirection, Integer offset, Integer limit) {
        List<ListenGuidelineDTO> result = new ArrayList<ListenGuidelineDTO>();
        Object[] objects = listenGuidelineDao.finByProperty(property,value,sortExpression,sortDirection,offset,limit);
        for (ListenGuidelineEntity item: (List<ListenGuidelineEntity>)objects[1]){
            ListenGuidelineDTO dto = ListenGuidelineUtil.entity2Dto(item);
            result.add(dto);
        }
        objects[1] = result;
        return objects;
    }*/
    //cần truyền vào 4 tham số
    //sortExpression tên column muốn sort
    //sortDirection trả về giá trị 1 hay 2
    //firstItem trả về giá trị
    //maxPageItems số items hiển thị trong 1 trang

}
