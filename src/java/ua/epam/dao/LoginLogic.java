/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.epam.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Logger;
import javax.naming.NamingException;
import ua.epam.manager.SQLmanager;

/**
 *
 * @author Roman
 */
public class LoginLogic {

    private static final Logger log = Logger.getLogger(ConnectOrderWithApartmentLogic.class.getName());
    
    public static boolean checkLogin(String login, String pass) {
      
        String sql = SQLmanager.getInstance().getProperty(SQLmanager.SELECT_ALL_FROM_clients_WHERE_login_AND_pass);
        return check(login, pass, sql);
    }

     public static boolean checkLoginAdmin(String login, String pass) {
      
        String sql = SQLmanager.getInstance().getProperty(SQLmanager.SELECT_ALL_FROM_admin_WHERE_login_AND_pass);
        return check(login, pass, sql);
    }

    private static boolean check(String login, String pass, String sql) {
        try {
          
            Connection cn = null;
          
            try {
                cn = ConnectToDB.getConnection();
                PreparedStatement st = null;
                try {
                    st = cn.prepareStatement(sql);
                    st.setString(1, login);
                    st.setString(2, pass);
                    ResultSet rs = null;
                    try {
                        rs = st.executeQuery();
                        return rs.next();

                    } finally {
                        if (rs != null) {
                            rs.close();
                        }
                    }
                } finally {
                    if (st != null) {
                        st.close();
                    }
                }
            } finally {
                if (cn != null) {
                    cn.close();
                }
            }
        } catch (NamingException ex) {
           log.warning(ex.getMessage());
        } catch (SQLException ex) {
           log.warning(ex.getMessage());
        }
        return false;

    }
}
