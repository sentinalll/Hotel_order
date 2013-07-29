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
public class PageManager {
     private static PageManager instance; 
  private ResourceBundle resourceBundle; 
 
//
  private static final String BUNDLE_NAME = "ua.epam.properties.page"; 
   
  public static final String ADMIN = "ADMIN"; 
  public static final String ADMIN_NEW_ORDER = "ADMIN_NEW_ORDER"; 
  public static final String ADMIN_LOGIN = "ADMIN_LOGIN"; 
  public static final String ADMIN_ARCHIVE_ORDERS = "ADMIN_ARCHIVE_ORDERS"; 
  public static final String USER_HISTORY_ORDERS = "USER_HISTORY_ORDERS"; 
  public static final String USER_INVOICE = "USER_INVOICE"; 
  public static final String USER_LEAVE_ORDER = "USER_LEAVE_ORDER"; 
  public static final String USER_LOGIN = "USER_LOGIN"; 
  public static final String USER_ORDER_ACCEPTED = "USER_ORDER_ACCEPTED"; 
  public static final String ADMIN_PAID_ORDERS_PAGE = "ADMIN_PAID_ORDERS_PAGE"; 
  public static final String ADMIN_ALL_CLIENTS = "ADMIN_ALL_CLIENTS"; 
  public static final String ADMIN_ALL_ROOMS = "ADMIN_ALL_ROOMS"; 
  public static final String INDEX = "INDEX"; 
 
   
  public static PageManager getInstance() { 
    if (instance == null) { 
      instance = new PageManager(); 
      instance.resourceBundle =  
ResourceBundle.getBundle(BUNDLE_NAME); 
    } 
    return instance; 
  } 
  public String getProperty(String key) { 
      
    return (String)resourceBundle.getObject(key); 
  } 
}
