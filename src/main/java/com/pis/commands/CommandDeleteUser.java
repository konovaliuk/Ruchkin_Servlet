package com.pis.commands;

import com.pis.manager.ConfigPath;
import com.pis.services.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class CommandDeleteUser implements ICommand{
    @Override
    public String execute(HttpServletRequest request) throws ServletException, IOException {
        UserService userService = new UserService();
        HttpSession session = request.getSession();
        if (session.getAttribute("admin") == null)
            return ConfigPath.home.getCommandPath();
        Boolean admin = (Boolean) session.getAttribute("admin");
        if(admin) {
            userService.deleteUser(Integer.parseInt(request.getParameter("user_id")));
            return ECommands.usersList.getCommand().execute(request);
        }
        return ConfigPath.home.getCommandPath();
    }
}
