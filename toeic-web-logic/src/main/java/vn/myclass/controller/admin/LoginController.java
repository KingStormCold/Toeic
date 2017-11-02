package vn.myclass.controller.admin;

import org.apache.log4j.Logger;
import vn.myclass.command.UserCommand;
import vn.myclass.core.dto.CheckLogin;
import vn.myclass.core.dto.UserDTO;
import vn.myclass.core.service.UserService;
import vn.myclass.core.service.impl.UserServiceImpl;
import vn.myclass.core.web.common.WebConstaint;
import vn.myclass.core.web.utils.FormUtil;
import vn.myclass.core.web.utils.SingletonServiceUtil;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ResourceBundle;

/**
 * Created by TuanKul on 9/18/2017.
 */
@WebServlet("/login.html")
public class LoginController extends HttpServlet {
    private final Logger log = Logger.getLogger(this.getClass());
    ResourceBundle bundle = ResourceBundle.getBundle("ApplicationResources");
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher rd = request.getRequestDispatcher("/views/web/login.jsp");
        rd.forward(request, response);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        UserCommand command = FormUtil.populate(UserCommand.class, request);
        UserDTO pojo = command.getPojo();
        if (pojo != null) {
            CheckLogin login = SingletonServiceUtil.getUserServiceInstance().checkLogin(pojo.getName(), pojo.getPassword());
            if(login.isUserExist()) {
                if(login.getRoleName().equals(WebConstaint.ROLE_ADMIN)) {
                    response.sendRedirect("/admin-home.html");
                } else if(login.getRoleName().equals(WebConstaint.ROLE_USER)) {
                    response.sendRedirect("/home.html");
                }
            } else {
                request.setAttribute(WebConstaint.ALERT,WebConstaint.TYPE_ERROR);
                request.setAttribute(WebConstaint.MESSAGE_RESPONSE,bundle.getString("label.name.password.wrong"));
                RequestDispatcher rd = request.getRequestDispatcher("/views/web/login.jsp");
                rd.forward(request, response);
            }
        }
        /*try{
            if(SingletonServiceUtil.getUserServiceInstance().isUserExist(pojo) != null){
                if(SingletonServiceUtil.getUserServiceInstance().findRoleByUser(pojo) != null
                        && SingletonServiceUtil.getUserServiceInstance().findRoleByUser(pojo).getRoleDTO() != null){
                    if(SingletonServiceUtil.getUserServiceInstance().findRoleByUser(pojo).getRoleDTO().getName().equals(WebConstaint.ROLE_ADMIN)) {
                        session.setAttribute("pojo.name",pojo.getName());
                        response.sendRedirect("/admin-home.html");
                        return;
                    }
                    else if(SingletonServiceUtil.getUserServiceInstance().findRoleByUser(pojo).getRoleDTO().getName().equals(WebConstaint.ROLE_USER)){
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
        rd.forward(request, response);*/
    }
}
