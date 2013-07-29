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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.NamingException;
import ua.epam.manager.SQLmanager;

/**
 *
 * @author Roman
 */
public class GetOrderLogic {

    private static final Logger log = Logger.getLogger(ConnectOrderWithApartmentLogic.class.getName());

    public static ArrayList<Order> get(String string) {
        try {
            Connection cn = null;
            try {
                cn = ConnectToDB.getConnection();
                if (string.equals("adminall")) {
                    return getArchivedForAdmin(cn);
                }

                if (string.equals("allclients")) {
                    return getAllClientsAdmin(cn);
                } else {
                    return getHistoryUser(cn, string);
                }

            } finally {
                if (cn != null) {
                    cn.close();
                }
            }
        } catch (NamingException ex) {
            log.warning("NamingExeption in GetOrderLogic");
        } catch (SQLException ex) {
            log.warning("SQLExeption in GetOrderLogic");
        }
        return null;
    }

    private static ArrayList<Order> getHistoryUser(Connection cn, String user) throws SQLException {
        ArrayList<Order> temp = new ArrayList();

        String sqlSELECT = SQLmanager.getInstance().getProperty(SQLmanager.SELECT_id_FROM_clients_WHERE_login);
        String sqlSELECTorder = SQLmanager.getInstance().getProperty(SQLmanager.SELECT_ALL_FROM_order_WHERE_clients_id);

        PreparedStatement st = null;
        PreparedStatement st1 = null;
        try {
            st = cn.prepareStatement(sqlSELECT);
            ResultSet rs = null;
            try {
                String clients_id;
                st.setString(1, user);
                synchronized (st) {
                    rs = st.executeQuery();
                }
                rs.first();
                clients_id = rs.getString(1);
                rs.close();
                st.close();
                st1 = cn.prepareStatement(sqlSELECTorder);
                st1.setString(1, clients_id);
                synchronized (st1) {
                    rs = st1.executeQuery();
                }
                while (rs.next()) {
                    Order or = new Order();
                    or.setOrderId(rs.getString(1));
                    or.setRoomBeds(rs.getString(3));
                    or.setRoomStar(rs.getString(4));
                    or.setDateFrom(rs.getString(5));
                    or.setDateTo(rs.getString(6));
                    or.setStatus(rs.getString(7));
                    or.setSummary(rs.getString(9));
                    or.setPaid(rs.getString(10));
                    or.setShowUser(rs.getString(11));
                    if (or.getShowUser().equals("true")) {
                        temp.add(or);
                    }

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
        return temp;
    }

    private static ArrayList<Order> getArchivedForAdmin(Connection cn) throws SQLException {
        ArrayList<Order> temp = new ArrayList();
        String sqlSELECT = SQLmanager.getInstance().getProperty(SQLmanager.SELECT_ALL_FROM_order);
        PreparedStatement st = null;
        try {
            st = cn.prepareStatement(sqlSELECT);
            ResultSet rs = null;
            try {
                synchronized (st) {
                    rs = st.executeQuery();
                }
                while (rs.next()) {
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
                    temp.add(or);
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
        }
        return temp;
    }

    private static ArrayList<Order> getAllClientsAdmin(Connection cn) throws SQLException {

        ArrayList<Order> temp = new ArrayList();
        String sqlSELECT = SQLmanager.getInstance().getProperty(SQLmanager.SELECT_ALL_FROM_clients);
        PreparedStatement st = null;
        try {
            st = cn.prepareStatement(sqlSELECT);
            ResultSet rs = null;
            try {
                synchronized (st) {
                    rs = st.executeQuery();
                }
                while (rs.next()) {
                    Order or = new Order();
                    or.setClientsId(rs.getString(1));
                    or.setName(rs.getString(4));
                    or.setSurname(rs.getString(5));
                    or.setEmail(rs.getString(6));
                    or.setTel(rs.getString(7));
                    or.setDateFrom(rs.getString(8));
                    temp.add(or);
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
        }
        return temp;

    }

    public static ArrayList<Apartment> getAllRooms() {

        ArrayList<Apartment> temp = new ArrayList();
        String sqlSELECT = SQLmanager.getInstance().getProperty(SQLmanager.SELECT_ALL_FROM_apartments);
        Connection cn = null;
        PreparedStatement st = null;
        try {
            try {
                try {
                    cn = ConnectToDB.getConnection();
                    st = cn.prepareStatement(sqlSELECT);
                    ResultSet rs = null;
                    try {
                        synchronized (st) {
                            rs = st.executeQuery();
                        }
                        while (rs.next()) {
                            Apartment ap = new Apartment();
                            ap.setId(rs.getString(1));
                            ap.setName(rs.getString(2));
                            ap.setRoomBeds(rs.getString(3));
                            ap.setRoomStar(rs.getString(4));
                            ap.setPrice(rs.getString(6));
                            temp.add(ap);
                        }
                        return temp;
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
        return temp;

    }
}