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

import java.util.logging.Logger;
import javax.naming.NamingException;
import ua.epam.manager.SQLmanager;

/**
 *
 * @author Roman
 */
public class TakeInvoiceLogic {

    private static final Logger log = Logger.getLogger(ConnectOrderWithApartmentLogic.class.getName());

    public static Order take(String order_id) {

        Order result = new Order();

        String sqlSELECTORDER = SQLmanager.getInstance().getProperty(SQLmanager.SELECT_ALL_FROM_order_WHERE_id);
        String sqlSELECTCLIENT = SQLmanager.getInstance().getProperty(SQLmanager.SELECT_ALL_FROM_clients_WHERE_id);
        String sqlSELECTAPARTMENT = SQLmanager.getInstance().getProperty(SQLmanager.SELECT_name_room_FROM_apartments_WHERE_id);
        try {
            Connection cn = null;
            try {
                cn = ConnectToDB.getConnection();
                PreparedStatement st = null;
                PreparedStatement st1 = null;
                PreparedStatement st2 = null;
                try {
                    st = cn.prepareStatement(sqlSELECTORDER);
                    st.setString(1, order_id);
                    ResultSet rs = null;
                    ResultSet rs1 = null;
                    ResultSet rs2 = null;
                    try {
                        synchronized (st) {
                            rs = st.executeQuery();
                        }
                        rs.first();
                        result.setOrderId(rs.getString(1));
                        result.setClientsId(rs.getString(2));
                        result.setRoomBeds(rs.getString(3));
                        result.setRoomStar(rs.getString(4));
                        result.setDateFrom(rs.getString(5));
                        result.setDateTo(rs.getString(6));
                        result.setApartmentId(rs.getString(8));
                        result.setSummary(rs.getString(9));
                        st1 = cn.prepareStatement(sqlSELECTCLIENT);

                        st1.setString(1, result.getClientsId());
                        synchronized (st1) {
                            rs1 = st1.executeQuery();
                        }
                        rs1.first();
                        result.setName(rs1.getString(4));
                        result.setSurname(rs1.getString(5));

                        st2 = cn.prepareStatement(sqlSELECTAPARTMENT);

                        st2.setString(1, result.getApartmentId());
                        synchronized (st2) {
                            rs2 = st2.executeQuery();
                        }
                        rs2.first();
                        result.setHotelNumber(rs2.getString(1));
                        return result;
                    } finally {
                        if (rs != null) {
                            rs.close();
                        }
                        if (rs1 != null) {
                            rs1.close();
                        }
                        if (rs2 != null) {
                            rs2.close();
                        }
                    }
                } finally {
                    if (st != null) {
                        st.close();
                    }
                    if (st1 != null) {
                        st1.close();
                    }
                    if (st2 != null) {
                        st2.close();
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
        return result;
    }
}
