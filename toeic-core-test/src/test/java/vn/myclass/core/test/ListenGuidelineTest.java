package vn.myclass.core.test;

import org.apache.commons.collections.map.HashedMap;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import vn.myclass.core.dao.ListenGuidelineDao;
import vn.myclass.core.daoimpl.ListenGuidelineDaoImpl;

import java.util.HashMap;
import java.util.Map;


/**
 * Created by TuanKul on 9/23/2017.
 */
public class ListenGuidelineTest {
    ListenGuidelineDao listenGuidelineDao;
    @BeforeTest
    public void initData() {
        listenGuidelineDao = new ListenGuidelineDaoImpl();
    }
    /*@Test
    public void findByProperties() {
        ListenGuidelineDao listenGuidelineDao = new ListenGuidelineDaoImpl();
        Object[] result = listenGuidelineDao.finByProperty(null,null,null,null,4,2);

    }*/

    @Test
    public void checkApiFindByProperty() {
        Map<String,Object> property = new HashMap<String,Object>();
        property.put("title","Bai hd 7");
        property.put("context","Noi dung bai hd 7");
        Object[] objects = listenGuidelineDao.finByProperty(property,null,null,null,null);
    }
}
