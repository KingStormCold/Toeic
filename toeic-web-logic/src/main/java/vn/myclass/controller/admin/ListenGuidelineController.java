package vn.myclass.controller.admin;

import vn.myclass.command.ListenGuideLineCommand;
import vn.myclass.core.dto.ListenGuidelineDTO;
import vn.myclass.core.service.ListenGuidelineService;
import vn.myclass.core.service.impl.ListenGuidelineServiceImpl;
import vn.myclass.core.web.common.WebConstaint;
import vn.myclass.core.web.utils.RequestUtil;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by TuanKul on 9/21/2017.
 */
@WebServlet("/admin-guideline-listen-list.html")
public class ListenGuidelineController extends HttpServlet {
    private ListenGuidelineService guidelineService = new ListenGuidelineServiceImpl();
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ListenGuideLineCommand command = new ListenGuideLineCommand();
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
        request.setAttribute(WebConstaint.LIST_ITEM , command);*/
        command.setMaxPageItems(2);
        RequestUtil.initSearchBean(request, command);
        /*Object[] objects = guidelineService.findListenGuidelineByProperties(null, null, command.getSortExpression(),command.getSortDirection(),command.getFirstItem(), command.getMaxPageItems());
        command.setListResult((List<ListenGuidelineDTO>) objects[1]);
        command.setTotalItems(Integer.parseInt(objects[0].toString()));
        request.setAttribute(WebConstaint.LIST_ITEM,command);*/
        RequestDispatcher rd = request.getRequestDispatcher("/views/admin/listenguideline/list.jsp");
        rd.forward(request, response);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }
}
