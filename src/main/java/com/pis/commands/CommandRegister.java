package com.pis.commands;

import com.pis.Entity.User;
import com.pis.manager.ConfigPath;
import com.pis.services.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class CommandRegister implements ICommand{
    @Override
    public String execute(HttpServletRequest request) throws ServletException, IOException {
        UserService userService = new UserService();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        HttpSession session = request.getSession();
        if(userService.isUserUnique(username))
            userService.createUser(null, username, null, null, password);
        else {
            request.setAttribute("unique", false);
            return ConfigPath.register.getCommandPath();
        }
        request.setAttribute("unique", true);
        session.setAttribute("registered", true);
        session.setAttribute("user", userService.isExist(username, password));
        session.setAttribute("admin", false);
        return ConfigPath.home.getCommandPath();
    }
}
