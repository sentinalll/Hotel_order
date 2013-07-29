
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.epam.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Logger;
import javax.naming.NamingException;
import ua.epam.manager.SQLmanager;

/**
 *
 * @author Roman
 */
public class DeleteOrderAdminLogic {

    private static final Logger log = Logger.getLogger(ConnectOrderWithApartmentLogic.class.getName());

    public static void delete(String order_id) {

        String sqlDELETE = SQLmanager.getInstance().getProperty(SQLmanager.DELETE_FROM_order_WHERE_id);


        try {
            Connection cn = null;
            try {
                cn = ConnectToDB.getConnection();
                PreparedStatement st = null;
                try {
                    st = cn.prepareStatement(sqlDELETE);
                    st.setString(1, order_id);
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
