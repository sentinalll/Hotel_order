/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.epam.dao;

import Utility.Apartment;
import Utility.Order;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Logger;
import javax.naming.NamingException;
import ua.epam.manager.SQLmanager;

/**
 *
 * @author Roman
 */
public class NewOrderAdminLogic {

    private static final Logger log = Logger.getLogger(ConnectOrderWithApartmentLogic.class.getName());

    public static HashMap<String, Object> get() {
        ArrayList<Order> orders = new ArrayList();

        HashMap<String, Object> result = new HashMap();
        HashMap<String, ArrayList<Apartment>> compatibleAp = new HashMap();
        String sqlSELECT = SQLmanager.getInstance().getProperty(SQLmanager.SELECT_ALL_FROM_order_WHERE_status_opened);
        String sqlSELECT_APARTMENT = SQLmanager.getInstance().getProperty(SQLmanager.SELECT_ALL_FROM_apartments_WHERE_id_NOT_IN);


        try {
            Connection cn = null;
            try {
                cn = ConnectToDB.getConnection();
                PreparedStatement st = null;
                try {
                    st = cn.prepareStatement(sqlSELECT);
                    ResultSet rs = null;
                    try {
                        synchronized (st) {
                            rs = st.executeQuery();
                        }
                        while (rs.next()) {
                            PreparedStatement st1 = null;
                            ResultSet rs_ap = null;
                            Order or = new Order();
                            or.setOrderId(rs.getString(1));
                            or.setClientsId(rs.getString(2));
                            or.setRoomBeds(rs.getString(3));
                            or.setRoomStar(rs.getString(4));
                            or.setDateFrom(rs.getString(5));
                            or.setDateTo(rs.getString(6));
                            or.setStatus(rs.getString(7));
                            or.setApartmentId(rs.getString(8));
                            or.setSummary(rs.getString(9));
                            or.setPaid(rs.getString(10));
                            or.setShowUser(rs.getString(11));


                            st1 = cn.prepareStatement(sqlSELECT_APARTMENT);
                            st1.setString(1, or.getDateFrom());
                            st1.setString(2, or.getDateTo());
                            st1.setString(3, or.getDateFrom());
                            st1.setString(4, or.getDateTo());
                            st1.setString(5, or.getDateFrom());
                            st1.setString(6, or.getDateTo());
                            st1.setString(7, or.getDateFrom());
                            st1.setString(8, or.getDateTo());
                            st1.setString(9, or.getRoomBeds());
                            st1.setString(10, or.getRoomStar());
                            synchronized (st1) {
                                rs_ap = st1.executeQuery();
                            }
                            ArrayList<Apartment> apartment = null;
                            if (rs_ap != null) {
                                apartment = new ArrayList();
                                while (rs_ap.next()) {
                                    Apartment ap = new Apartment();
                                    ap.setId(rs_ap.getString(1));
                                    ap.setName(rs_ap.getString(2));
                                    ap.setRoomBeds(rs_ap.getString(3));
                                    ap.setRoomStar(rs_ap.getString(4));
                                    ap.setBookedUntill(rs_ap.getString(5));
                                    ap.setPrice(rs_ap.getString(6));
                                    apartment.add(ap);
                                }
                                rs_ap.close();
                            }
                            st1.close();
                            orders.add(or);
                            compatibleAp.put(or.getOrderId(), apartment);
                        }
                        result.put("orders", orders);
                        result.put("compatible", compatibleAp);
                        return result;
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
        return null;
    }
}
