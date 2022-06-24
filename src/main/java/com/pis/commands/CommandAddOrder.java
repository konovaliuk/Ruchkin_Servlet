package com.pis.commands;

import com.pis.manager.ConfigPath;
import com.pis.services.OrderService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class CommandAddOrder implements ICommand{
    @Override
    public String execute(HttpServletRequest request) throws ServletException, IOException {
        OrderService orderService = new OrderService();
        HttpSession session = request.getSession();
        if (session.getAttribute("admin") == null)
            return ECommands.orderList.getCommand().execute(request);
        Boolean admin = (Boolean) session.getAttribute("admin");
        if(admin) {
            orderService.createOrder(request.getParameter("name"), request.getParameter("description"));
            return ECommands.orderList.getCommand().execute(request);
        }
        return ECommands.orderList.getCommand().execute(request);
    }
}
