/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.epam.commands;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
import ua.epam.dao.ConnectOrderWithApartmentLogic;
import ua.epam.dao.RejectionOrderLogic;
import ua.epam.manager.PageManager;

/**
 *
 * @author Roman
 */
public class ApartmentToOrderCommand implements Command {

    static Logger log = Logger.getLogger(ApartmentToOrderCommand.class.getName());

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String command = request.getParameter("command");
        String page = "";
        /*Check if admin is still logined*/
        if (request.getSession().getAttribute("admin") != null) {
            
            if (command.equals("{apartmentToOrderAccept}")) {
                String apartment_id = request.getParameter("selectAp");
                String order_id = request.getParameter("order_id");
                /*Connect compatible apartment with client order*/
                ConnectOrderWithApartmentLogic.connect(order_id, apartment_id);
                log.info("Apartment = " + apartment_id + "connect with" + "Order = " + order_id);
            }
            if (command.equals("{apartmentToOrderDecline}")) {
                String order_id = request.getParameter("order_id");
                /*Reject order*/
                RejectionOrderLogic.reject(order_id);

            }
            Command com = new NewOrderAdminCommand();
            page = com.execute(request, response);
            request.getSession().setAttribute("currentPage", page);
            return page;
        } else {
            
            return PageManager.getInstance().getProperty(PageManager.ADMIN_LOGIN);
        }
    }
}
