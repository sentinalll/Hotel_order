/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.epam.commands;

import Utility.Apartment;
import Utility.Order;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
import ua.epam.dao.NewOrderAdminLogic;
import ua.epam.manager.PageManager;

/**
 *
 * @author Roman
 */
public class NewOrderAdminCommand implements Command {

    static Logger log = Logger.getLogger(NewOrderAdminCommand.class.getName());

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getSession().getAttribute("admin") != null) {
            /*Admin get all opened order and compatible apartment*/
            HashMap<String, Object> newOrderAdmin = NewOrderAdminLogic.get();
            /*Select only opened orders*/
            ArrayList<Order> newOrder = (ArrayList<Order>) newOrderAdmin.get("orders");
            /*Select compatible apartment to each order*/
            HashMap<String, ArrayList<Apartment>> compatibleAp = (HashMap<String, ArrayList<Apartment>>) newOrderAdmin.get("compatible");
            /*Put all in session to use this in jsp page*/
            request.getSession().setAttribute("neworderadmin", newOrder);
            request.getSession().setAttribute("compatAp", compatibleAp);
            log.info("admin get opened order");
            String page = PageManager.getInstance().getProperty(PageManager.ADMIN_NEW_ORDER);
            request.getSession().setAttribute("currentPage", page);
            return page;
        } else {
            return PageManager.getInstance().getProperty(PageManager.ADMIN_LOGIN);
        }

    }
}
