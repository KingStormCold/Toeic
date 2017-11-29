package vn.myclass.controller.admin;

import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.apache.poi.util.StringUtil;
import org.hibernate.exception.ConstraintViolationException;
import vn.myclass.command.ListenGuideLineCommand;
import vn.myclass.core.common.utils.UploadUtil;
import vn.myclass.core.dto.ListenGuidelineDTO;
import vn.myclass.core.service.ListenGuidelineService;
import vn.myclass.core.service.impl.ListenGuidelineServiceImpl;
import vn.myclass.core.web.common.WebConstaint;
import vn.myclass.core.web.utils.FormUtil;
import vn.myclass.core.web.utils.RequestUtil;
import vn.myclass.core.web.utils.SingletonServiceUtil;
import vn.myclass.core.web.utils.WebCommonUtil;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.*;

/**
 * Created by TuanKul on 9/21/2017.
 */
//@WebServlet("/admin-guideline-listen-list.html")
@WebServlet(urlPatterns = {"/admin-guideline-listen-list.html","/admin-guideline-listen-edit.html"})
public class ListenGuidelineController extends HttpServlet {
    private final Logger log = Logger.getLogger(this.getClass());
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ListenGuideLineCommand command = FormUtil.populate(ListenGuideLineCommand.class,request);
        ResourceBundle resourceBundle = ResourceBundle.getBundle("ResourcesBundle");

        /*List<ListenGuidelineDTO> listenGuidelineDTOS = new ArrayList<ListenGuidelineDTO>();
        ListenGuidelineDTO dto = new ListenGuidelineDTO();
        dto.setTitle("Nghe 1");
        dto.setContext("Noi dung nghe 1");
        ListenGuidelineDTO dto1 = new ListenGuidelineDTO();
        dto1.setTitle("Nghe 2");
        dto1.setContext("Noi dung nghe 2");
        listenGuidelineDTOS.add(dto);
        listenGuidelineDTOS.add(dto1);
        command.setListResult(listenGuidelineDTOS);
        command.setMaxPageItems(1);//dua vao cai nay de phan trang
        command.setTotalItems(listenGuidelineDTOS.size());//dua vao cai nay de phan trang
        //de jsp nhan dc gia tri,do du lieu tu controller ra jsp
        request.setAttribute(WebConstaint.LIST_ITEM , command);
        command.setMaxPageItems(2);*/

        /*HttpSession session = request.getSession();
        request.setAttribute(WebConstaint.ALERT, WebConstaint.TYPE_SUCCESS);
        request.setAttribute(WebConstaint.MESSAGE_RESPONSE, resourceBundle.getString("label.guideline.listen.add.succes"));
        if(session != null) {
            session.setAttribute(WebConstaint.ALERT,session.getAttribute(WebConstaint.ALERT));
            session.setAttribute(WebConstaint.MESSAGE_RESPONSE,session.getAttribute((WebConstaint.MESSAGE_RESPONSE)));
        }*/

        if(command.getUrlType() != null && command.getUrlType().equals(WebConstaint.URL_LIST)){
            if(command.getCrudaction() != null && command.getCrudaction().equals(WebConstaint.REDIRECT_DELETE)) {
                List<Integer> ids = new ArrayList<Integer>();
                for(String item: command.getCheckList()) {
                    ids.add(Integer.parseInt(item));
                }
                Integer result = SingletonServiceUtil.getListenGuidelineServiceInstance().delete(ids);
                if(result != ids.size()) {
                    command.setCrudaction(WebConstaint.REDIRECT_ERROR);
                }
            }
            excuteSearchListenGuideline(request,command);
            if(command.getCrudaction() != null ) {
                Map<String,String> mapMessage = buidMapRedirectMessage(resourceBundle);
                WebCommonUtil.addRedirectMessage(request,command.getCrudaction(),mapMessage);
            }
            request.setAttribute(WebConstaint.LIST_ITEM,command);
            RequestDispatcher rd = request.getRequestDispatcher("/views/admin/listenguideline/list.jsp");
            rd.forward(request, response);
        }
        else if (command.getUrlType() != null && command.getUrlType().equals(WebConstaint.URL_EDIT)){
            if(command.getPojo() != null && command.getPojo().getListenguidelineId() != null) {
                command.setPojo(SingletonServiceUtil.getListenGuidelineServiceInstance().findByListenGuidelineId("listenguidelineId",command.getPojo().getListenguidelineId()));
            }
            request.setAttribute(WebConstaint.FROM_ITEM, command);
            RequestDispatcher rd = request.getRequestDispatcher("/views/admin/listenguideline/edit.jsp");
            rd.forward(request, response);
        }
    }

    private Map<String,String> buidMapRedirectMessage(ResourceBundle resourceBundle) {
        Map<String,String> mapMessage = new HashMap<String, String>();
        mapMessage.put(WebConstaint.REDIRECT_INSERT, resourceBundle.getString("label.message.insert"));
        mapMessage.put(WebConstaint.REDIRECT_UPDATE, resourceBundle.getString("label.message.update"));
        mapMessage.put(WebConstaint.REDIRECT_DELETE, resourceBundle.getString("label.message.delete"));
        mapMessage.put(WebConstaint.REDIRECT_ERROR, resourceBundle.getString("label.message.error"));
        return mapMessage;
    }

    private void excuteSearchListenGuideline(HttpServletRequest request, ListenGuideLineCommand command) {
        //String la chua truong` muon search,Object la gia tri search
        Map<String,Object> properies = buildMapProperties(command);
        RequestUtil.initSearchBean(request, command);
        Object[] objects = SingletonServiceUtil.getListenGuidelineServiceInstance().findListenGuidelineByProperties(properies, command.getSortExpression(),command.getSortDirection(),command.getFirstItem(), command.getMaxPageItems());
        command.setListResult((List<ListenGuidelineDTO>) objects[1]);
        command.setTotalItems(Integer.parseInt(objects[0].toString()));
    }

    private Map<String,Object> buildMapProperties(ListenGuideLineCommand command) {
        Map<String,Object> properties = new HashMap<String,Object>();
        //hk dc empty
        if(StringUtils.isNotBlank(command.getPojo().getTitle())) {
            properties.put("title",command.getPojo().getTitle());
        }
        if(StringUtils.isNotBlank(command.getPojo().getContext())) {
            properties.put("context",command.getPojo().getContext());
        }
        return properties;
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ListenGuideLineCommand command =new ListenGuideLineCommand();
        ResourceBundle bundle = ResourceBundle.getBundle("ResourcesBundle");
        UploadUtil uploadUtil = new UploadUtil();
        HttpSession session = request.getSession();
        Set<String> valueTitle = buildSetValueListenGuideline();
        Object[] objects = uploadUtil.writeOrUpdateFile(request,valueTitle,WebConstaint.LISTENGUIDELINE);
        //đưa dữ liệu từ jsp vào DTO
        boolean checkStatusUploadImage = (Boolean)objects[0];
        if(!checkStatusUploadImage) {
            response.sendRedirect("/admin-guideline-listen-list.html?urlType=url_list&&crudaction=redirect_error");
        }
        else {
            ListenGuidelineDTO dto = command.getPojo();
            //không bị empty
            if (StringUtils.isNotBlank(objects[2].toString())) {
                dto.setImage(objects[2].toString());
            }
            Map<String,String> mapValue = (Map<String, String>) objects[3];
            dto = returnValueOfDTO(dto, mapValue);
            if(dto != null) {
                if (dto.getListenguidelineId() != null) {
                    //update
                    ListenGuidelineDTO listenGuidelineDTO = SingletonServiceUtil.getListenGuidelineServiceInstance().findByListenGuidelineId("listenguidelineId", dto.getListenguidelineId());
                    if(dto.getImage() == null) {
                        dto.setImage(listenGuidelineDTO.getImage());
                    }
                    dto.setCreatedDate(listenGuidelineDTO.getCreatedDate());
                    ListenGuidelineDTO result = SingletonServiceUtil.getListenGuidelineServiceInstance().updateListenGuideLine(dto);
                    if(result != null) {
                        response.sendRedirect("/admin-guideline-listen-list.html?urlType=url_list&&crudaction=redirect_update");
                    }
                    else {
                        response.sendRedirect("/admin-guideline-listen-list.html?urlType=url_list&&crudaction=redirect_error");
                    }
                }
                else {
                    try{
                        SingletonServiceUtil.getListenGuidelineServiceInstance().saveListenGuideline(dto);
                        response.sendRedirect("/admin-guideline-listen-list.html?urlType=url_list&&crudaction=redirect_insert");
                    } catch (ConstraintViolationException e) {
                        log.error(e.getMessage(),e);
                        response.sendRedirect("/admin-guideline-listen-list.html?urlType=url_list&&crudaction=redirect_error");
                    }
                }
            }
        }
    }

    private ListenGuidelineDTO returnValueOfDTO(ListenGuidelineDTO dto, Map<String, String> mapValue) {
        for (Map.Entry<String,String> item: mapValue.entrySet()) {
            if(item.getKey().equals("pojo.title")) {
                dto.setTitle(item.getValue());
            } else if(item.getKey().equals("pojo.context")) {
                dto.setContext(item.getValue());
            } else if(item.getKey().equals("pojo.listenguidelineId")) {
                dto.setListenguidelineId(Integer.parseInt(item.getValue().toString()));
            }
        }
        return dto;
    }

    private Set<String> buildSetValueListenGuideline() {
        Set<String> returnValue = new HashSet<String>();
        returnValue.add("pojo.title");
        returnValue.add("pojo.context");
        returnValue.add("pojo.listenguidelineId");
        return returnValue;
    }
}
