/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.epam.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Logger;
import javax.naming.NamingException;
import ua.epam.manager.SQLmanager;

/**
 *
 * @author Roman
 */
public class RegisterLogic {

    private static final Logger log = Logger.getLogger(ConnectOrderWithApartmentLogic.class.getName());

    public static boolean checkAvailableEmail(String email) {
        String sql = SQLmanager.getInstance().getProperty(SQLmanager.SELECT_ALL_FROM_clients_WHERE_login);
        try {
            Connection cn = null;
            try {
                cn = ConnectToDB.getConnection();
                PreparedStatement st = null;
                try {
                    st = cn.prepareStatement(sql);
                    st.setString(1, email);
                    ResultSet rs = null;
                    try {
                        synchronized (st) {
                            rs = st.executeQuery();
                        }
                        return !rs.next();

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
            Logger.getLogger(ex.getMessage());
        } catch (SQLException ex) {
            Logger.getLogger(ex.getMessage());
        }
        return true;


    }

    public static void reg(List<String> newUser) {

        String sql = SQLmanager.getInstance().getProperty(SQLmanager.INSERT_INTO_clients_VALUES);
        String timeStamp = new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime());
        Connection cn = null;
        PreparedStatement st = null;
        try {
            try {

                cn = ConnectToDB.getConnection();
                st = cn.prepareStatement(sql);
                st.setString(1, newUser.get(0));
                st.setString(2, newUser.get(1));
                st.setString(3, newUser.get(2));
                st.setString(4, newUser.get(3));
                st.setString(5, newUser.get(0));
                st.setString(6, newUser.get(4));
                st.setString(7, timeStamp);
                synchronized (st) {
                    st.executeUpdate();
                }

            } finally {

                if (st != null) {
                    st.close();
                }
                if (cn != null) {
                    cn.close();
                }
            }
        } catch (NamingException ex) {
            log.warning(ex.getMessage());
        } catch (SQLException ex) {
            log.warning(ex.getMessage());
        }
    }
}
