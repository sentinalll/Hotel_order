/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.epam.filter;

import Utility.Summary;
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import org.apache.log4j.Logger;
import ua.epam.manager.PageManager;

/**
 *
 * @author Roman
 */
public class FilterEmptyRegister implements Filter {

    private FilterConfig filterConfig;
    private static final Logger log = Logger.getLogger(FilterEmptyInputLogin.class.getName());

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain)
            throws IOException, ServletException {

        String req = request.getParameter("command");

        if (req.equals("{register}Accept")) {
            //if register info is empty than return with error message
            log.info("Check register data ");
            String email = request.getParameter("email");
            String pass = request.getParameter("password");
            String name = request.getParameter("name");
            String surname = request.getParameter("surname");
            String tel = request.getParameter("tel");
            if ((email.equals("")) || (pass.equals("")) || (name.equals("")) || (surname.equals("")) || (tel.equals(""))) {
                request.setAttribute("isVisibleAlertReg", "true");
                request.setAttribute("page", PageManager.getInstance().getProperty(PageManager.USER_LOGIN));
                request.getRequestDispatcher("index.jsp").forward(request, response);
            } else {
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
