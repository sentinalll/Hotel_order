/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.epam.controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
import ua.epam.commands.Command;
import ua.epam.commands.NoCommand;
import ua.epam.manager.PageManager;

public class Controller extends HttpServlet
        implements javax.servlet.Servlet {

    static Logger log = Logger.getLogger(NoCommand.class.getName());
    RequestHelper requestHelper = RequestHelper.getInstance();

    public Controller() {
        super();
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String page = null;
        try {
//Get command 
            Command command = requestHelper.getCommand(request);

            page = command.execute(request, response);
// Get next page
        } catch (ServletException e) {
            log.warn(e.getMessage());
        } catch (IOException e) {
            log.warn(e.getMessage());
        }
        request.setAttribute("page", page);
        String req;
        req = PageManager.getInstance().getProperty(PageManager.INDEX);
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(req);
        dispatcher.forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
}
