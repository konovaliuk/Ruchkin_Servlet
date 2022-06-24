package com.pis.commands;

import com.pis.manager.ConfigPath;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class LogOutCommand implements ICommand{
    @Override
    public String execute(HttpServletRequest request) throws ServletException, IOException {
        request.getSession().invalidate();
        return ConfigPath.login.getCommandPath();
    }
}
