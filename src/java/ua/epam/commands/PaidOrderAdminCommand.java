/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.epam.commands;

import Utility.Order;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import ua.epam.dao.GetOrderLogic;
import ua.epam.manager.PageManager;

/**
 *
 * @author Roman
 */
public class PaidOrderAdminCommand implements Command {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getSession().getAttribute("admin") != null) {
            /*Take all order and put them intu sessionScope */
            ArrayList<Order> allOrder = GetOrderLogic.get("adminall");
            request.getSession().setAttribute("allorder", allOrder);
            String page = PageManager.getInstance().getProperty(PageManager.ADMIN_PAID_ORDERS_PAGE);
            request.getSession().setAttribute("currentPage", page);
            return page;
        } else {
            return PageManager.getInstance().getProperty(PageManager.ADMIN_LOGIN);
        }

    }
}
