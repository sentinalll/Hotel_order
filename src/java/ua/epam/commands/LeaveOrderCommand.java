/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.epam.commands;

import Utility.Order;
import java.io.IOException;
import java.util.HashMap;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.log4j.Logger;
import ua.epam.dao.LeaveOrderLogic;
import ua.epam.manager.PageManager;

/**
 *
 * @author Roman
 */
public class LeaveOrderCommand implements Command {

    static Logger log = Logger.getLogger(LeaveOrderCommand.class.getName());

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String command = request.getParameter("command");
        String page;
        HttpSession session = request.getSession();
        
        if (command.equals("{leaveOrderDecline}")) {
        /*Clear leave order form*/
            page = PageManager.getInstance().getProperty(PageManager.USER_LEAVE_ORDER);
            session.setAttribute("currentPage", page);
            
            return page;
        }
        
        /*Leave order
         Take from request parametr */
        if (command.equals("{leaveOrderAccept}")) {
            Order order = new Order();
            order.setEmail((String) session.getAttribute("user"));
            order.setRoomStar(request.getParameter("star"));
            order.setRoomBeds(request.getParameter("beds"));
            order.setDateFrom(request.getParameter("datefrom"));
            order.setDateTo(request.getParameter("dateto"));
            /*Add order to database*/
            LeaveOrderLogic.leave(order);
            log.info("User : " + (String) session.getAttribute("user") + " leave order");
            /*forward user to confirm order page*/
            page = PageManager.getInstance().getProperty(PageManager.USER_ORDER_ACCEPTED);
            session.setAttribute("currentPage", page);
            return page;
        }
        return PageManager.getInstance().getProperty(PageManager.USER_LOGIN);


    }
}
