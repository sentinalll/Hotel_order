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
import ua.epam.dao.GetOrderLogic;
import ua.epam.manager.PageManager;

/**
 *
 * @author Roman
 */
public class ArchivedOrderAdminCommand implements Command {

    static Logger log = Logger.getLogger(LoginCommand.class.getName());

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String page;
        if (request.getSession().getAttribute("admin") != null) {
            HttpSession session = request.getSession();
            /*Select all order from database*/
            List<Order> allorder = GetOrderLogic.get("adminall");
            /*Put order into session to operate with them into jsp page */
            session.setAttribute("allorder", allorder);
            log.info("Admin get all order");
            page = PageManager.getInstance().getProperty(PageManager.ADMIN_ARCHIVE_ORDERS);
            request.getSession().setAttribute("currentPage", page);
            return page;
        } else {
            page = PageManager.getInstance().getProperty(PageManager.ADMIN_LOGIN);
            return page;
        }
    }
}
