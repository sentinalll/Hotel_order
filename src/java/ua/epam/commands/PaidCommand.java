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
import ua.epam.dao.PaidLogic;

/**
 *
 * @author Roman
 */
public class PaidCommand implements Command {

    static Logger log = Logger.getLogger(PaidCommand.class.getName());
    
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String order_id = request.getParameter("order_id");
        /*Change in database info about paid order
         imitation of payment order*/
        PaidLogic.pay(order_id);
        
        log.info("Order : "+order_id+" has been paid");
        
        Command com = new UserHistoryCommand();
        return com.execute(request, response);
    }
}
