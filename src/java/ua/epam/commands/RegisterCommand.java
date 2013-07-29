/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.epam.commands;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
import ua.epam.dao.*;
import ua.epam.manager.PageManager;

/**
 *
 * @author Roman
 */
public class RegisterCommand implements Command {

    static Logger log = Logger.getLogger(RegisterCommand.class.getName());

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<String> newUser = new ArrayList();
        String email = request.getParameter("email");
        String page;
        String command = request.getParameter("command");
        /*register new client*/
        if (command.equals("{register}Accept")) {
            /*Check if email is available*/
            if (RegisterLogic.checkAvailableEmail(email)) {
                newUser.add(email);
                newUser.add(request.getParameter("password"));
                newUser.add(request.getParameter("name"));
                newUser.add(request.getParameter("surname"));
                newUser.add(request.getParameter("tel"));
                RegisterLogic.reg(newUser);
                request.getSession().setAttribute("user", email);
                log.info("New clients registered : " + email);
                page = PageManager.getInstance().getProperty(PageManager.USER_HISTORY_ORDERS);
                request.getSession().setAttribute("currentPage", page);
                return page;
            } else {
                /*Show user that this email is not available*/
                request.setAttribute("isEmailReg", true);
                page = PageManager.getInstance().getProperty(PageManager.USER_LOGIN);
            }
            request.getSession().setAttribute("currentPage", page);
            return page;
        } else {

            page = PageManager.getInstance().getProperty(PageManager.USER_LOGIN);
            request.getSession().setAttribute("currentPage", page);
            return page;
        }


    }
}
