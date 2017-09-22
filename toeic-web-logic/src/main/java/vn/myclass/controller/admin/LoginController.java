package vn.myclass.controller.admin;

import org.apache.log4j.Logger;
import vn.myclass.command.UserCommand;
import vn.myclass.core.dto.UserDTO;
import vn.myclass.core.service.UserService;
import vn.myclass.core.service.impl.UserServiceImpl;
import vn.myclass.core.web.common.WebConstaint;
import vn.myclass.core.web.utils.FormUtil;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by TuanKul on 9/18/2017.
 */
@WebServlet("/login.html")
public class LoginController extends HttpServlet {
    private final Logger log = Logger.getLogger(this.getClass());
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher rd = request.getRequestDispatcher("/views/web/login.jsp");
        rd.forward(request, response);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        UserCommand command = FormUtil.populate(UserCommand.class, request);
        UserDTO pojo = command.getPojo();
        UserService userService = new UserServiceImpl();
        try{
            if(userService.isUserExist(pojo) != null){
                if(userService.findRoleByUser(pojo) != null && userService.findRoleByUser(pojo).getRoleDTO() != null){
                    if(userService.findRoleByUser(pojo).getRoleDTO().getName().equals(WebConstaint.ROLE_ADMIN)) {
                        response.sendRedirect("/admin-home.html");
                        return;
                    }
                    else if(userService.findRoleByUser(pojo).getRoleDTO().getName().equals(WebConstaint.ROLE_USER)){
                        response.sendRedirect("home.html");
                        return;
                    }
                }

            }
        }
        catch (NullPointerException e) {
            log.error(e.getMessage(),e);
            request.setAttribute(WebConstaint.ALERT,WebConstaint.TYPE_ERROR);
            request.setAttribute(WebConstaint.MESSAGE_RESPONSE,"Tài khoản hoặc mật khẩu không đúng!!");
        }
        RequestDispatcher rd = request.getRequestDispatcher("/views/web/login.jsp");
        rd.forward(request, response);
    }
}
