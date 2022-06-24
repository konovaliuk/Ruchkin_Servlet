package com.pis.commands;

import com.pis.manager.ConfigPath;
import com.pis.services.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class CommandUsersList implements ICommand{
    @Override
    public String execute(HttpServletRequest request) throws ServletException, IOException {
        UserService userService = new UserService();
        HttpSession session = request.getSession();
        Boolean admin = (Boolean) session.getAttribute("admin");
        if(admin == null){
            return ConfigPath.home.getCommandPath();
        }
        if(admin){
            request.setAttribute("users", userService.getAllUsers());
            return ConfigPath.users.getCommandPath();
        }
        return ConfigPath.home.getCommandPath();
    }
}
