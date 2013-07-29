/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.epam.commands;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.log4j.Logger;
import ua.epam.dao.LoginLogic;
import ua.epam.manager.PageManager;

public class LoginCommand implements Command {

    private static final String PARAM_NAME_LOGIN = "email";
    private static final String PARAM_NAME_PASSWORD = "password";
    static Logger log = Logger.getLogger(LoginCommand.class.getName());

    @Override
    public String execute(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        String page;
        String login = request.getParameter(PARAM_NAME_LOGIN);
        String pass = request.getParameter(PARAM_NAME_PASSWORD);
        /*Check user login and password*/
        if (LoginLogic.checkLogin(login, pass)) {
            HttpSession session = request.getSession();
            session.setAttribute("user", login);
            log.info("User : " + login + " login");
            Command command = new UserHistoryCommand();
            page = command.execute(request, response);
        } else {

            page = PageManager.getInstance().getProperty(PageManager.USER_LOGIN);

        }
        request.getSession().setAttribute("currentPage", page);
        return page;
    }
}