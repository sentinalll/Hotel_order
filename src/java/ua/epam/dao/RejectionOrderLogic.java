/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.epam.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.NamingException;
import ua.epam.manager.SQLmanager;

/**
 *
 * @author Roman
 */
public class RejectionOrderLogic {

    private static final Logger log = Logger.getLogger(ConnectOrderWithApartmentLogic.class.getName());

    public static void reject(String order_id) {

        String sqlREJECT = SQLmanager.getInstance().getProperty(SQLmanager.UPDATE_order_SET_status_closed_WHERE_id);
        Connection cn = null;
        try {
            cn = ConnectToDB.getConnection();
            try {
                PreparedStatement st = cn.prepareStatement(sqlREJECT);
                st.setString(1, order_id);
                try {
                    synchronized (st) {
                        st.executeUpdate();
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
    }
}
