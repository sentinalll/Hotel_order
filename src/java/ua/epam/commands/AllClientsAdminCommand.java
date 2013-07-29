/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.epam.commands;

import Utility.Order;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.log4j.Logger;
import static ua.epam.commands.ArchivedOrderAdminCommand.log;
import ua.epam.dao.GetOrderLogic;
import ua.epam.manager.PageManager;

/**
 *
 * @author Roman
 */
public class AllClientsAdminCommand implements Command {

    static Logger log = Logger.getLogger(LoginCommand.class.getName());

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String page;
        /*Check if admin is still logined*/
        if (request.getSession().getAttribute("admin") != null) {
            HttpSession session = request.getSession();
            /*Take all clients from datebase*/
            List<Order> allclients = GetOrderLogic.get("allclients");
            session.setAttribute("allclients", allclients);
            log.info("Admin get all clients");
            page = PageManager.getInstance().getProperty(PageManager.ADMIN_ALL_CLIENTS);
            request.getSession().setAttribute("currentPage", page);
            return page;
        } else {
            page = PageManager.getInstance().getProperty(PageManager.ADMIN_LOGIN);
            return page;
        }
    }
}
