/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.epam.filter;

import Utility.Summary;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import org.apache.log4j.Logger;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import ua.epam.manager.PageManager;

/*Check correct values before its come to controller*/
public class FilterEmptyInputLogin implements Filter {

    private FilterConfig filterConfig;
    private static final Logger log = Logger.getLogger(FilterEmptyInputLogin.class.getName());

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain)
            throws IOException, ServletException {

        String req = request.getParameter("command");

        if (req.equals("{login}")) {
            String email = request.getParameter("email");
            String pass = request.getParameter("password");

            if ((email.equals("")) || (pass.equals(""))) {
                log.info("Check login ");
                //If email or password is empty than return with error message
                request.setAttribute("isVisibleAlertLoginUser", "true");
                request.setAttribute("page", PageManager.getInstance().getProperty(PageManager.USER_LOGIN));
                request.getRequestDispatcher("index.jsp").forward(request, response);
            } else {
                //if is not empty than forward to controller
                request.getRequestDispatcher("controller").forward(request, response);
            }
        } else {
            filterChain.doFilter(request, response);
        }
    }

    public FilterConfig getFilterConfig() {
        return filterConfig;
    }

    @Override
    public void init(FilterConfig filterConfig) {
        this.filterConfig = filterConfig;
    }

    @Override
    public void destroy() {
    }
}