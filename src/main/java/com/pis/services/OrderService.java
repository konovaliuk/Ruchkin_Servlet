package com.pis.services;

import com.pis.Dao.OrderDao;
import com.pis.Entity.Order;


import java.util.List;

public class OrderService {
    OrderDao orderDao = new OrderDao();

    public boolean createOrder(String name, String description){

        OrderDao orderDao = new OrderDao();
        Integer order = orderDao.insert(new Order(null, name,description));

        return order != null;
    }

    public List<Order> getAllOrders(){
        OrderDao orderDao = new OrderDao();

        return orderDao.getAll();
    }

    public Order getOrder(int id){
        Order order;
        OrderDao orderDao = new OrderDao();
        order = orderDao.getById(id);
        return order;
    }

    public void deleteOrder(Integer id){
        orderDao.delete(id);
    }

}
