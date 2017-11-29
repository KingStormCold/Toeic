package vn.myclass.core.service;

import vn.myclass.core.dto.ListenGuidelineDTO;

import java.util.List;
import java.util.Map;

/**
 * Created by TuanKul on 9/24/2017.
 */
public interface ListenGuidelineService {
    Object[] findListenGuidelineByProperties(Map<String, Object> property, String sortExpression, String sortDirection, Integer offset, Integer limit);
    ListenGuidelineDTO findByListenGuidelineId(String property, Integer listenGuidelineId);
    void saveListenGuideline(ListenGuidelineDTO dto);
    ListenGuidelineDTO updateListenGuideLine(ListenGuidelineDTO dto);
    Integer delete(List<Integer> ids);
}
