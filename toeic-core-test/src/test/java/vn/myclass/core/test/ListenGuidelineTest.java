package vn.myclass.core.test;

import org.testng.annotations.Test;
import vn.myclass.core.dao.ListenGuidelineDao;
import vn.myclass.core.daoimpl.ListenGuidelineDaoImpl;

/**
 * Created by TuanKul on 9/23/2017.
 */
public class ListenGuidelineTest {
    @Test
    public void findByProperties() {
        ListenGuidelineDao listenGuidelineDao = new ListenGuidelineDaoImpl();
        Object[] result = listenGuidelineDao.finByProperty(null,null,null,null,4,2);

    }
}
