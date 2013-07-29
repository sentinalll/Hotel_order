/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.epam.commands;

import Utility.Apartment;
import Utility.Order;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import static ua.epam.commands.AllClientsAdminCommand.log;
import ua.epam.dao.GetOrderLogic;
import ua.epam.manager.PageManager;

/**
 *
 * @author Roman
 */
public class AllRoomsAdminCommand implements Command{

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String page;
        /*Check if admin is still logined*/
        if (request.getSession().getAttribute("admin") != null) {
            HttpSession session = request.getSession();
            /*Take all rooms from database*/
            List<Apartment> allrooms = GetOrderLogic.getAllRooms();
            session.setAttribute("allrooms", allrooms);
            log.info("Admin get all rooms");
            page = PageManager.getInstance().getProperty(PageManager.ADMIN_ALL_ROOMS);
            request.getSession().setAttribute("currentPage", page);
            return page;
        } else {
            page = PageManager.getInstance().getProperty(PageManager.ADMIN_LOGIN);
            return page;
        }
    }
    
}
