package com.pis.commands;

import com.pis.Entity.User;
import com.pis.manager.ConfigPath;
import com.pis.services.UserRoleService;
import com.pis.services.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginCommand implements ICommand{
    UserRoleService userRoleService = new UserRoleService();
    UserService userService = new UserService();
    @Override
    public String execute(HttpServletRequest request) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User user = userService.isExist(username, password);
        if(user != null){
            session.setAttribute("registered", true);
            session.setAttribute("user", user);
            if(userRoleService.AdminCheck(user.id()))
                session.setAttribute("admin", true);
            else session.setAttribute("admin", false);
            return ConfigPath.home.getCommandPath();
        }
        else {
            request.setAttribute("incorrect", true);
            session.setAttribute("registered", false);
        }
        return ConfigPath.login.getCommandPath();
    }
}
