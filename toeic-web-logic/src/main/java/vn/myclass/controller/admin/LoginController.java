package vn.myclass.controller.admin;

import org.apache.log4j.Logger;
import vn.myclass.command.UserCommand;
import vn.myclass.core.common.utils.SessionUtil;
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
 *///mullti url
@WebServlet(urlPatterns = {"/login.html","/logout.html"})
public class LoginController extends HttpServlet {
    private final Logger log = Logger.getLogger(this.getClass());
    ResourceBundle bundle = ResourceBundle.getBundle("ResourcesBundle");
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //trên url có 1 cái parameter có tên là action thì khi gọi request.getParameter sẽ lấy giá trị của action đó
        //dựa vào action này là ta mún là login hay là logout
        String action = request.getParameter("action");
        if(action.equals(WebConstaint.LOGIN)) {
            RequestDispatcher rd = request.getRequestDispatcher("/views/web/login.jsp");
            rd.forward(request, response);
        }
        else if(action.equals(WebConstaint.LOGOUT)) {
            SessionUtil.getInstance().remove(request,WebConstaint.LOGIN_NAME);
            response.sendRedirect("/home.html");
        }

    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        UserCommand command = FormUtil.populate(UserCommand.class, request);
        UserDTO pojo = command.getPojo();
        if (pojo != null) {
            CheckLogin login = SingletonServiceUtil.getUserServiceInstance().checkLogin(pojo.getName(), pojo.getPassword());
            if(login.isUserExist()) {
                SessionUtil.getInstance().putValue(request, WebConstaint.LOGIN_NAME, pojo.getName());
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
    }
}
