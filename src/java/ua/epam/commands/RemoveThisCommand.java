/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.epam.commands;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import ua.epam.dao.RemoveFromUserLogic;

/**
 *
 * @author Roman
 */
public class RemoveThisCommand implements Command {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String order_id = request.getParameter("order");
        /*Remove order from user list, dont remove it from data base*/
        RemoveFromUserLogic.remove(order_id);
        Command command = new UserHistoryCommand();
        String page = command.execute(request, response);
        request.getSession().setAttribute("currentPage", page);
        return page;
    }
}
