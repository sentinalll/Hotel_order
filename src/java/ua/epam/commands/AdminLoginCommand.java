/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.epam.commands;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
import ua.epam.dao.LoginLogic;
import ua.epam.manager.PageManager;

/**
 *
 * @author Roman
 */
public class AdminLoginCommand implements Command {

    private static final String PARAM_NAME_LOGIN = "email";
    private static final String PARAM_NAME_PASSWORD = "password";
    static Logger log = Logger.getLogger(AdminLoginCommand.class.getName());

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String page;

        String login = request.getParameter(PARAM_NAME_LOGIN);
        String pass = request.getParameter(PARAM_NAME_PASSWORD);

        request.getSession().setAttribute("admin", login);
        /*Check if admin login and password is correct*/
        if (LoginLogic.checkLoginAdmin(login, pass)) {
            log.info("Admin logined");
            Command command = new NewOrderAdminCommand();
            page = command.execute(request, response);
        } else {
            page = PageManager.getInstance().getProperty(PageManager.ADMIN_LOGIN);
        }
        request.getSession().setAttribute("currentPage", page);
        return page;
    }
}
