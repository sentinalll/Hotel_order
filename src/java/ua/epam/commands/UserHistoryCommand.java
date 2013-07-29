/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.epam.commands;

import Utility.Order;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import ua.epam.dao.GetOrderLogic;
import ua.epam.manager.PageManager;

/**
 *
 * @author Roman
 */
public class UserHistoryCommand implements Command {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<Order> history;
        HttpSession session = request.getSession();
        String user = (String) session.getAttribute("user");
        /*Get history of all user orders*/
        history = GetOrderLogic.get(user);
        session.setAttribute("history", history);
        request.getSession().setAttribute("currentPage", PageManager.getInstance().getProperty(PageManager.USER_HISTORY_ORDERS));
        return PageManager.getInstance().getProperty(PageManager.USER_HISTORY_ORDERS);
    }
}
