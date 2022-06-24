package com.pis.commands;

import com.pis.manager.ConfigPath;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class Home implements ICommand{
    @Override
    public String execute(HttpServletRequest request) throws ServletException, IOException {
        return ConfigPath.home.getCommandPath();
    }
}
