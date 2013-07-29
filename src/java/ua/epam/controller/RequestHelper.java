/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.epam.controller;

import Utility.CommandMapCreator;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.servlet.http.HttpServletRequest;
import ua.epam.commands.Command;
import ua.epam.commands.NoCommand;

public class RequestHelper {

    private static RequestHelper instance = null;
    private HashMap<String, Command> commands = null;

    private RequestHelper() {
        commands = CommandMapCreator.create();
    }

    public Command getCommand(HttpServletRequest request)
    {
        //Parse command from request
        Pattern p = Pattern.compile("[{]([A-Za-z]+)[}]");
        String match = request.getParameter("command");
        if (match == null) {
            Command command = new NoCommand();
            return command;
        }
        Matcher m = p.matcher(match);
        String temp;
        m.find();
        temp = m.group(1);
        //get command
        Command command = commands.get(temp);
        //If such command do not exist then take command NoCommand
        if (command == null) {
            command = new NoCommand();
        }
        return command;
    }

    public static RequestHelper getInstance() {
        if (instance == null) {
            instance = new RequestHelper();
        }
        return instance;
    }
}
