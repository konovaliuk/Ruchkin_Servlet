package com.pis.commands;

import com.pis.Entity.User;
import com.pis.manager.ConfigPath;
import com.pis.services.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class CommandUpdateUser implements ICommand{
    @Override
    public String execute(HttpServletRequest request) throws ServletException, IOException {
        UserService userService = new UserService();
        HttpSession session = request.getSession();
        if (session.getAttribute("registered") == null)
            return ConfigPath.home.getCommandPath();
        Boolean registered = (Boolean) session.getAttribute("registered");
        if(registered) {
            User user = (User) session.getAttribute("user");
            if(user == null) return ECommands.commandProfile.getCommand().execute(request);
            User updatedUser = new User(
                    user.id(),
                    (String) request.getParameter("name"),
                    (String) request.getParameter("surname"),
                    (String) request.getParameter("email"),
                    user.password());
            userService.updateUser(updatedUser);
            session.setAttribute("user", updatedUser);
            return ECommands.commandProfile.getCommand().execute(request);
        }
        return ConfigPath.home.getCommandPath();
    }
}
