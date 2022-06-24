package com.pis.controller;



import com.pis.commands.ECommands;
import com.pis.commands.ICommand;

import javax.servlet.http.HttpServletRequest;

public class ControllerHelper {
    public static ICommand getCommand(HttpServletRequest request) {
        String commandName = request.getParameter("command");
        try {
            return ECommands.valueOf(commandName).getCommand();
        }
        catch (Exception e) {
            return ECommands.valueOf("home").getCommand();
        }
    }
}