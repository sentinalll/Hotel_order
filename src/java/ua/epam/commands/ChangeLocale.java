/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.epam.commands;

import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;

/**
 *
 * @author Roman
 */
public class ChangeLocale implements Command {

    static Logger log = Logger.getLogger(LeaveOrderCommand.class.getName());

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String command = request.getParameter("command");
        Locale current = Locale.getDefault();
        /*change locale*/
        if (command.equals("{localeEN}")) {
            current = new Locale("en", "US");
        }else{
            if (command.equals("{localeRU}")){
            current = new Locale("ru", "RU");}
        }
        /*Take ResourceBundle with select locale */
        ResourceBundle currentLanguage = ResourceBundle.getBundle("ua.epam.properties.locale.language", current);
        request.getSession().setAttribute("currentLanguage", currentLanguage);
        String page = (String) request.getSession().getAttribute("currentPage");
        log.info(page);
        return page ;
    }
}
