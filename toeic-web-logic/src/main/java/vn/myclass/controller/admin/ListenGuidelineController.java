package vn.myclass.controller.admin;

import org.apache.commons.fileupload.FileUploadException;
import org.apache.log4j.Logger;
import vn.myclass.command.ListenGuideLineCommand;
import vn.myclass.core.common.utils.UploadUtil;
import vn.myclass.core.dto.ListenGuidelineDTO;
import vn.myclass.core.service.ListenGuidelineService;
import vn.myclass.core.service.impl.ListenGuidelineServiceImpl;
import vn.myclass.core.web.common.WebConstaint;
import vn.myclass.core.web.utils.FormUtil;
import vn.myclass.core.web.utils.RequestUtil;

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
    private ListenGuidelineService guidelineService = new ListenGuidelineServiceImpl();
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ListenGuideLineCommand command = FormUtil.populate(ListenGuideLineCommand.class,request);
        ResourceBundle resourceBundle = ResourceBundle.getBundle("ApplicationResources");
        HttpSession session = request.getSession();
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
        /*RequestUtil.initSearchBean(request, command);
        Object[] objects = guidelineService.findListenGuidelineByProperties(null, null, command.getSortExpression(),command.getSortDirection(),command.getFirstItem(), command.getMaxPageItems());
        command.setListResult((List<ListenGuidelineDTO>) objects[1]);
        command.setTotalItems(Integer.parseInt(objects[0].toString()));*/

        /*request.setAttribute(WebConstaint.ALERT, WebConstaint.TYPE_SUCCESS);
        request.setAttribute(WebConstaint.MESSAGE_RESPONSE, resourceBundle.getString("label.guideline.listen.add.succes"));*/
        if(session != null) {
            session.setAttribute(WebConstaint.ALERT,session.getAttribute(WebConstaint.ALERT));
            session.setAttribute(WebConstaint.MESSAGE_RESPONSE,session.getAttribute((WebConstaint.MESSAGE_RESPONSE)));
        }
        request.setAttribute(WebConstaint.LIST_ITEM,command);
        if(command.getUrlType() != null && command.getUrlType().equals(WebConstaint.URL_LIST)){
            RequestDispatcher rd = request.getRequestDispatcher("/views/admin/listenguideline/list.jsp");
            rd.forward(request, response);
        }
        else if (command.getUrlType() != null && command.getUrlType().equals(WebConstaint.URL_EDIT)){
            RequestDispatcher rd = request.getRequestDispatcher("/views/admin/listenguideline/edit.jsp");
            rd.forward(request, response);
        }
        session.removeAttribute(WebConstaint.ALERT);
        session.removeAttribute(WebConstaint.MESSAGE_RESPONSE);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ListenGuideLineCommand command =new ListenGuideLineCommand();
        ResourceBundle bundle = ResourceBundle.getBundle("ApplicationResources");
        UploadUtil uploadUtil = new UploadUtil();
        HttpSession session = request.getSession();
        Set<String> valueTitle = buildSetValueListenGuideline();
        /*try {
            Object[] objects = uploadUtil.writeOrUpdateFile(request,valueTitle,WebConstaint.LISTENGUIDELINE);
            //đưa dữ liệu từ jsp vào DTO
            Map<String, String> mapValue = (Map<String, String>) objects[3];
            command = returnValueListenGuidelineCommand(valueTitle, command, mapValue);
            session.setAttribute(WebConstaint.ALERT,WebConstaint.TYPE_SUCCESS);
            session.setAttribute(WebConstaint.MESSAGE_RESPONSE, bundle.getString("label.guideline.listen.add.succes"));
        } catch (FileUploadException e) {
            log.error(e.getMessage(),e);
            session.setAttribute(WebConstaint.ALERT,WebConstaint.TYPE_ERROR);
            session.setAttribute(WebConstaint.MESSAGE_RESPONSE, bundle.getString("label.error"));
        }
        catch (Exception e){
            log.error(e.getMessage(),e);
            session.setAttribute(WebConstaint.ALERT,WebConstaint.TYPE_ERROR);
            session.setAttribute(WebConstaint.MESSAGE_RESPONSE, bundle.getString("label.error"));
        }*/
        response.sendRedirect("/admin-guideline-listen-list.html?urlType=url_list");
    }

    private ListenGuideLineCommand returnValueListenGuidelineCommand(Set<String> valueTitle, ListenGuideLineCommand command, Map<String, String> mapValue) {
        for(String item : valueTitle) {
            if(mapValue.containsKey(item)) {
                if(item.equals("pojo.title")) {
                    command.getPojo().setTitle(mapValue.get(item));
                }
                else if(item.equals("pojo.context")){
                    command.getPojo().setContext(mapValue.get(item));
                }

            }
        }
        return command;
    }

    private Set<String> buildSetValueListenGuideline() {
        Set<String> returnValue = new HashSet<String>();
        returnValue.add("pojo.title");
        returnValue.add("pojo.context");
        return returnValue;
    }
}
