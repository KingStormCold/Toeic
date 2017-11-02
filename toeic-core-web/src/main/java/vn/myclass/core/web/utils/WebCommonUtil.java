package vn.myclass.core.web.utils;

import org.apache.commons.lang.StringUtils;
import vn.myclass.core.web.common.WebConstaint;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * Created by TuanKul on 10/25/2017.
 */
public class WebCommonUtil {
    public static void addRedirectMessage(HttpServletRequest request, String crudaction, Map<String, String> mapMessage) {
        if (StringUtils.isNotBlank(crudaction) && crudaction.equals(WebConstaint.REDIRECT_INSERT)) {
            request.setAttribute(WebConstaint.ALERT, WebConstaint.TYPE_SUCCESS);
            request.setAttribute(WebConstaint.MESSAGE_RESPONSE, mapMessage.get(WebConstaint.REDIRECT_INSERT));
        } else if (StringUtils.isNotBlank(crudaction) && crudaction.equals(WebConstaint.REDIRECT_UPDATE)) {
            request.setAttribute(WebConstaint.ALERT, WebConstaint.TYPE_SUCCESS);
            request.setAttribute(WebConstaint.MESSAGE_RESPONSE, mapMessage.get(WebConstaint.REDIRECT_UPDATE));
        } else if (StringUtils.isNotBlank(crudaction) && crudaction.equals(WebConstaint.REDIRECT_DELETE)) {
            request.setAttribute(WebConstaint.ALERT, WebConstaint.TYPE_SUCCESS);
            request.setAttribute(WebConstaint.MESSAGE_RESPONSE, mapMessage.get(WebConstaint.REDIRECT_DELETE));
        } else if (StringUtils.isNotBlank(crudaction) && crudaction.equals(WebConstaint.REDIRECT_ERROR)) {
            request.setAttribute(WebConstaint.ALERT, WebConstaint.TYPE_ERROR);
            request.setAttribute(WebConstaint.MESSAGE_RESPONSE, mapMessage.get(WebConstaint.REDIRECT_ERROR));
        }
    }

}
