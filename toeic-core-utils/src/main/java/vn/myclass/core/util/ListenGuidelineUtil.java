package vn.myclass.core.util;

import vn.myclass.core.dto.ListenGuidelineDTO;
import vn.myclass.core.persistence.entity.ListenGuidelineEntity;

/**
 * Created by TuanKul on 9/24/2017.
 */
public class ListenGuidelineUtil {
    //entity qua dto
    public static ListenGuidelineDTO entity2Dto (ListenGuidelineEntity entity) {
        ListenGuidelineDTO dto = new ListenGuidelineDTO();
        dto.setListenguidelineId(entity.getListenguidelineId());
        dto.setContext(entity.getContext());
        dto.setImage(entity.getImage());
        dto.setTitle(entity.getTitle());
        dto.setCreatedDate(entity.getCreatedDate());
        dto.setModifieddate(entity.getModifieddate());
        return dto;
    }
    public static ListenGuidelineEntity dto2Entity (ListenGuidelineDTO dto) {
        ListenGuidelineEntity entity = new ListenGuidelineEntity();
        entity.setListenguidelineId(dto.getListenguidelineId());
        entity.setContext(dto.getContext());
        entity.setImage(dto.getImage());
        entity.setTitle(dto.getTitle());
        entity.setCreatedDate(dto.getCreatedDate());
        entity.setModifieddate(dto.getModifieddate());
        return entity;
    }
}
