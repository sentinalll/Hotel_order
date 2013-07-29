/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Utility;

import ua.epam.commands.ArchivedOrderAdminCommand;


import ua.epam.commands.UserHistoryCommand;
import ua.epam.commands.LeaveOrderCommand;

import java.util.HashMap;
import ua.epam.commands.AdminLoginCommand;
import ua.epam.commands.AllClientsAdminCommand;
import ua.epam.commands.AllRoomsAdminCommand;
import ua.epam.commands.ApartmentToOrderCommand;
import ua.epam.commands.ChangeLocale;
import ua.epam.commands.Command;
import ua.epam.commands.DeleteOrderAdminCommand;

import ua.epam.commands.LeaveOrderPageCommand;
import ua.epam.commands.LoginCommand;
import ua.epam.commands.NewOrderAdminCommand;
import ua.epam.commands.PaidCommand;
import ua.epam.commands.PaidOrderAdminCommand;
import ua.epam.commands.RegisterCommand;
import ua.epam.commands.RemoveThisCommand;
import ua.epam.commands.SignOutAdminCommand;
import ua.epam.commands.SignOutUserCommand;
import ua.epam.commands.TakeUserInvoiceCommand;

/**
 *
 * @author Roman
 */
public class CommandMapCreator {

    public static HashMap<String, Command> create() {
        HashMap<String, Command> temp = new HashMap();
        temp.put("login", new LoginCommand());
        temp.put("register", new RegisterCommand());
        temp.put("leaveOrderAccept", new LeaveOrderCommand());
        temp.put("leaveOrderDecline", new LeaveOrderCommand());
        temp.put("leaveOrderpage", new LeaveOrderPageCommand());
        temp.put("archivedOrderAdmin", new ArchivedOrderAdminCommand());
        temp.put("userHistory", new UserHistoryCommand());
        temp.put("signOutAdmin", new SignOutAdminCommand());
        temp.put("signOutUser", new SignOutUserCommand());
        temp.put("adminLogin", new AdminLoginCommand());
        temp.put("newOrderAdmin", new NewOrderAdminCommand());
        temp.put("paidOrderAdmin", new PaidOrderAdminCommand());
        temp.put("removeThis", new RemoveThisCommand());
        temp.put("apartmentToOrderAccept", new ApartmentToOrderCommand());
        temp.put("apartmentToOrderDecline", new ApartmentToOrderCommand());
        temp.put("takeInvoice", new TakeUserInvoiceCommand());
        temp.put("paid", new PaidCommand());
        temp.put("localeEN", new ChangeLocale());
        temp.put("localeRU", new ChangeLocale());
        temp.put("allclients", new AllClientsAdminCommand());
        temp.put("allroom", new AllRoomsAdminCommand());
        temp.put("deleteThisOrderAdmin", new DeleteOrderAdminCommand());
        return temp;
    }
}
