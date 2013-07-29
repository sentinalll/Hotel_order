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
public class FilterCorrectOrderData implements Filter {

    private FilterConfig filterConfig;
    private static final Logger log = Logger.getLogger(FilterEmptyInputLogin.class.getName());

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain)
            throws IOException, ServletException {

        String req = request.getParameter("command");

        if (req.equals("{leaveOrderAccept}")) {
            String datefrom = request.getParameter("datefrom");
            String dateto = request.getParameter("dateto");

            if ((datefrom.equals("")) || (dateto.equals(""))) {
                request.setAttribute("isVisibleAlertLeaveOrder", "true");
                request.setAttribute("page", PageManager.getInstance().getProperty(PageManager.USER_LEAVE_ORDER));
                request.getRequestDispatcher("index.jsp").forward(request, response);
            } else {
                int result = Integer.parseInt(Summary.getSummary("1", datefrom, dateto));
                if (result <= 0) {
                    request.setAttribute("isVisibleAlertLeaveOrder", "true");
                    request.setAttribute("page", PageManager.getInstance().getProperty(PageManager.USER_LEAVE_ORDER));
                    request.getRequestDispatcher("index.jsp").forward(request, response);
                } else {
                    request.setAttribute("isVisibleAlertLeaveOrder", "false");
                    request.getRequestDispatcher("controller").forward(request, response);
                }
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
