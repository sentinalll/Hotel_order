/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.epam.commands;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import ua.epam.manager.PageManager;

/**
 *
 * @author Roman
 */
public class LeaveOrderPageCommand implements Command {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String page= PageManager.getInstance().getProperty(PageManager.USER_LEAVE_ORDER);
        request.getSession().setAttribute("currentPage", page);
        return page;
    }
}
