package com.pis.commands;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface ICommand {
    String execute(HttpServletRequest request) throws ServletException, IOException;
}
