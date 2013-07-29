/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.epam.commands;

import Utility.Order;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
import ua.epam.dao.TakeInvoiceLogic;
import ua.epam.manager.PageManager;

/**
 *
 * @author Roman
 */
public class TakeUserInvoiceCommand implements Command {

    static Logger log = Logger.getLogger(TakeUserInvoiceCommand.class.getName());

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String order_id = request.getParameter("order_id");
        String page;
        /*Take invoice that user can pay for order*/
        Order invoice = TakeInvoiceLogic.take(order_id);
        log.info("Client take invoice to pay order with id : " + order_id);
        request.getSession().setAttribute("invoice", invoice);
        page = PageManager.getInstance().getProperty(PageManager.USER_INVOICE);
        request.getSession().setAttribute("currentPage", page);
        return page;
    }
}
