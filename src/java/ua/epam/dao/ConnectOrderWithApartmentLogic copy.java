/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.epam.dao;

import Utility.Summary;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Logger;
import javax.naming.NamingException;
import ua.epam.manager.SQLmanager;

/**
 *
 * @author Roman
 */
public class ConnectOrderWithApartmentLogic {

    private static final Logger log = Logger.getLogger(ConnectOrderWithApartmentLogic.class.getName());

    public static void connect(String order_id, String apartment_id) {
        String sqlSUMMARY = SQLmanager.getInstance().getProperty(SQLmanager.SELECT_price_FROM_apartment_WHERE_ID);
        String SQLSELECT_DATEFROM_DATETO = SQLmanager.getInstance().getProperty(SQLmanager.SELECT_date_from_date_to_FROM_order_WHERE_ID);
        String sqlUPDATEORDER = SQLmanager.getInstance().getProperty(SQLmanager.UPDATE_order_SET_status_apartment_id_summary_WHERE_id);;
        try {
            Connection cn = null;
            try {
                cn = ConnectToDB.getConnection();
                PreparedStatement st = null;
                PreparedStatement st1 = null;
                PreparedStatement st2 = null;
                try {
                    st = cn.prepareStatement(sqlSUMMARY);
                    st.setInt(1, Integer.parseInt(apartment_id));
                    st1 = cn.prepareStatement(SQLSELECT_DATEFROM_DATETO);
                    st1.setInt(1, Integer.parseInt(order_id));
                    st2 = cn.prepareStatement(sqlUPDATEORDER);

                    ResultSet rs = null;
                    ResultSet rs1 = null;
                    try {

                        String price;
                        String dateto;
                        String datefrom;
                        synchronized (st) {
                            rs = st.executeQuery();
                        }
                        rs.first();
                        price = rs.getString(1);


                        st.close();
                        rs.close();
                        synchronized (st1) {
                            rs1 = st1.executeQuery();
                        }
                        rs1.first();

                        datefrom = rs1.getString(1);
                        dateto = rs1.getString(2);

                        st1.close();
                        rs1.close();
                        String summary = Summary.getSummary(price, datefrom, dateto);

                        st2.setString(1, apartment_id);
                        st2.setString(2, summary);
                        st2.setString(3, order_id);
                        synchronized (st2) {
                            st2.executeUpdate();
                        }
                        st2.close();


                    } finally {

                        if (rs != null) {
                            rs.close();
                        }
                        if (rs1 != null) {
                            rs1.close();
                        }

                    }
                } finally {
                    if (st != null) {
                        st.close();
                    }
                    if (st1 != null) {
                        st.close();
                    }
                    if (st2 != null) {
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
