/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.epam.manager;
import java.util.ResourceBundle;
/**
 *
 * @author Roman
 */
public class SQLmanager {
 
  private static SQLmanager instance; 
  private ResourceBundle resourceBundle; 
 
//класс извлекает информацию из файла sql.properties 
  private static final String BUNDLE_NAME = "ua.epam.properties.sql"; 
   
  public static final String SELECT_price_FROM_apartment_WHERE_ID = "SELECT_price_FROM_apartment_WHERE_ID"; 
  public static final String SELECT_date_from_date_to_FROM_order_WHERE_ID = "SELECT_date_from_date_to_FROM_order_WHERE_ID"; 
  public static final String UPDATE_order_SET_status_apartment_id_summary_WHERE_id = "UPDATE_order_SET_status_apartment_id_summary_WHERE_id";  
  public static final String SELECT_id_FROM_clients_WHERE_login = "SELECT_id_FROM_clients_WHERE_login"; 
  public static final String SELECT_ALL_FROM_order_WHERE_clients_id = "SELECT_ALL_FROM_order_WHERE_clients_id"; 
  public static final String INSERT_INTO_ORDER_clients_id_beds_star_datefrom_dateto_status_apartment_id_summary_paid_show_user_VALUES =  
"INSERT_INTO_ORDER_clients_id_beds_star_datefrom_dateto_status_apartment_id_summary_paid_show_user_VALUES"; 
  public static final String SELECT_ALL_FROM_clients_WHERE_login_AND_pass = "SELECT_ALL_FROM_clients_WHERE_login_AND_pass"; 
  public static final String SELECT_ALL_FROM_admin_WHERE_login_AND_pass = "SELECT_ALL_FROM_admin_WHERE_login_AND_pass";  
  public static final String SELECT_ALL_FROM_order_WHERE_status_opened = "SELECT_ALL_FROM_order_WHERE_status_opened"; 
  public static final String SELECT_ALL_FROM_apartments_WHERE_id_NOT_IN = "SELECT_ALL_FROM_apartments_WHERE_id_NOT_IN"; 
  public static final String UPDATE_order_SET_paid_yes_WHERE_id = "UPDATE_order_SET_paid_yes_WHERE_id"; 
  public static final String INSERT_INTO_clients_VALUES = "INSERT_INTO_clients_VALUES"; 
  public static final String UPDATE_order_SET_status_closed_WHERE_id = "UPDATE_order_SET_status_closed_WHERE_id"; 
  public static final String SELECT_ALL_FROM_clients_WHERE_login = "SELECT_ALL_FROM_clients_WHERE_login"; 
  public static final String UPDATE_order_SET_show_user_false_WHERE_id= "UPDATE_order_SET_show_user_false_WHERE_id"; 
  public static final String SELECT_ALL_FROM_order_WHERE_id = "SELECT_ALL_FROM_order_WHERE_id"; 
  public static final String SELECT_ALL_FROM_clients_WHERE_id= "SELECT_ALL_FROM_clients_WHERE_id"; 
  public static final String SELECT_name_room_FROM_apartments_WHERE_id= "SELECT_name_room_FROM_apartments_WHERE_id"; 
  public static final String SELECT_ALL_FROM_order= "SELECT_ALL_FROM_order"; 
  public static final String SELECT_ALL_FROM_clients= "SELECT_ALL_FROM_clients"; 
  public static final String SELECT_ALL_FROM_apartments= "SELECT_ALL_FROM_apartments"; 
  public static final String DELETE_FROM_order_WHERE_id= "DELETE_FROM_order_WHERE_id"; 
   
  public static SQLmanager getInstance() { 
    if (instance == null) { 
      instance = new SQLmanager(); 
      instance.resourceBundle =  
ResourceBundle.getBundle(BUNDLE_NAME); 
    } 
    return instance; 
  } 
  public String getProperty(String key) { 
      
    return (String)resourceBundle.getObject(key); 
  } 
}     

