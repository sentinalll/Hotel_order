/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.epam.dao;

import Utility.Order;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.logging.Logger;
import javax.naming.NamingException;
import ua.epam.manager.SQLmanager;

/**
 *
 * @author Roman
 */
public class LeaveOrderLogic {

    private static final Logger log = Logger.getLogger(ConnectOrderWithApartmentLogic.class.getName());

    public static void leave(Order order) {
        

        String sqlSELECT = SQLmanager.getInstance().getProperty(SQLmanager.SELECT_id_FROM_clients_WHERE_login);
        String sqlINSERT = SQLmanager.getInstance().getProperty(SQLmanager.INSERT_INTO_ORDER_clients_id_beds_star_datefrom_dateto_status_apartment_id_summary_paid_show_user_VALUES);
        try {
            Connection cn = null;
            try {
                cn = ConnectToDB.getConnection();
                PreparedStatement st = null;
                PreparedStatement st1 = null;
                try {
                    st = cn.prepareStatement(sqlSELECT);
                    st.setString(1, order.getEmail());
                    ResultSet rs = null;
                    try {
                        String clients_id;
                        synchronized (st) {
                            rs = st.executeQuery();
                        }
                        rs.first();
                        clients_id = rs.getString(1);
                        st1 = cn.prepareStatement(sqlINSERT);
                        st1.setString(1, clients_id);
                        st1.setString(2, order.getRoomBeds());
                        st1.setString(3, order.getRoomStar());
                        st1.setString(4, order.getDateFrom());
                        st1.setString(5, order.getDateTo());
                        synchronized (st1) {
                            st1.executeUpdate();
                        }
                    } finally {
                        if (rs != null) {
                            rs.close();
                        }
                    }
                } finally {
                    if (st != null) {
                        st.close();
                    }
                    if (st1 != null) {
                        st1.close();
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
