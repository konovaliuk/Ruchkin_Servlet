package com.pis.commands;

import com.pis.Entity.Order;
import com.pis.manager.ConfigPath;
import com.pis.services.OrderService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

public class CommandOrderList implements ICommand{
    OrderService orderService = new OrderService();
    @Override
    public String execute(HttpServletRequest request) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Boolean registered = (Boolean) session.getAttribute("registered");
        if(registered == null){
            return ConfigPath.home.getCommandPath();
        }
        if(registered){
            request.setAttribute("orders", orderService.getAllOrders());
            return ConfigPath.orders.getCommandPath();
        }
        return ConfigPath.home.getCommandPath();
    }
}
