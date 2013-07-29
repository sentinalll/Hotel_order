/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.epam.commands;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
import ua.epam.manager.PageManager;

public class NoCommand implements Command {    
    
    static Logger log = Logger.getLogger(NoCommand.class.getName());
    
    @Override
    public String execute(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        /*If there is a reversal without command*/        
        String page = PageManager.getInstance().getProperty(PageManager.USER_LOGIN);
        request.getSession().setAttribute("currentPage", page);
        return page;        
    }    
}
