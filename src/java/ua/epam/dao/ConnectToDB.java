/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.epam.dao;

import javax.naming.Context;
import java.sql.SQLException;
import java.sql.Connection;
import java.util.logging.Logger;
import javax.sql.DataSource;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class ConnectToDB {

      private static final Logger log = Logger.getLogger(ConnectOrderWithApartmentLogic.class.getName());
    
    public static Connection getConnection() throws NamingException, SQLException {
        //Initial connection pool
        InitialContext initialContext = new InitialContext();
        Context context = (Context) initialContext.lookup("java:comp/env");
        //The JDBC Data source that we just created
        DataSource ds = (DataSource) context.lookup("hoteldb");
        Connection connection = ds.getConnection();

        if (connection == null) {
            throw new SQLException("Error establishing connection!");
            
        }
        return connection;
    }
}
