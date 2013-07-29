/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.epam.commands;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.log4j.Logger;
import ua.epam.manager.PageManager;

/**
 *
 * @author Roman
 */
public class SignOutAdminCommand implements Command {

    static Logger log = Logger.getLogger(SignOutAdminCommand.class.getName());

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        log.info("Admin sign out");
        session.invalidate();
        return PageManager.getInstance().getProperty(PageManager.ADMIN_LOGIN);
    }
}
