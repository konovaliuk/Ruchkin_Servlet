package com.pis.commands;

import com.pis.manager.ConfigPath;
import com.pis.services.OrderService;
import com.pis.services.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class CommandProfile implements ICommand{
    @Override
    public String execute(HttpServletRequest request) throws ServletException, IOException {
        UserService userService = new UserService();
        OrderService orderService = new OrderService();
        HttpSession session = request.getSession();
        if (session.getAttribute("registered") == null)
            return ConfigPath.home.getCommandPath();
        Boolean registered = (Boolean) session.getAttribute("registered");
        if(registered){
            return ConfigPath.profile.getCommandPath();
        }
        return ConfigPath.home.getCommandPath();
    }
}
