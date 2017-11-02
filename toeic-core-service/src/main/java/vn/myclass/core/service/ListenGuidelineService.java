package vn.myclass.core.service;

import java.util.Map;

/**
 * Created by TuanKul on 9/24/2017.
 */
public interface ListenGuidelineService {
    Object[] findListenGuidelineByProperties(Map<String, Object> property, String sortExpression, String sortDirection, Integer offset, Integer limit);
}
