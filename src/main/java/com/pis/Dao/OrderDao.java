package com.pis.Dao;

import com.pis.Entity.Order;
import com.pis.Entity.User;

import java.sql.*;
import java.util.ArrayList;

public class OrderDao implements IDao<Order> {
    String INSERT = "INSERT INTO orders (name, description) value (?,?)";
    String SELECTALL = "SELECT *  FROM orders";
    String SELECT = "SELECT * FROM orders WHERE orders.id = ?" ;
    String SELECTBYNAME = "SELECT * FROM orders WHERE name = ?";
    String UPDATE =  "UPDATE orders SET name = ?, description = ? WHERE orders.id = ? ";
    String DELETE = "DELETE FROM orders WHERE id = ?";

    @Override
    public Integer insert(Order order) {
        try(Connection connection = dataSourse.getConnection();
            PreparedStatement ps = connection.prepareStatement(INSERT)){
            ps.setString(1, order.name());
            ps.setString(2, order.description());
            return ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public Order getById(int id) {
        try(Connection connection = dataSourse.getConnection();
            PreparedStatement ps = connection.prepareStatement(SELECT)){
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next())
                return new Order(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3));
            else return null;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Order getByName(String name) {
        try(Connection connection = dataSourse.getConnection();
            PreparedStatement ps = connection.prepareStatement(SELECTBYNAME)){
            ResultSet rs = ps.executeQuery();
            if(rs.next())
                return new Order(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3));
            else return null;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Integer update(Order order) {
        try(Connection connection = dataSourse.getConnection();
            PreparedStatement ps = connection.prepareStatement(UPDATE)){
            ps.setString(1, order.name());
            ps.setString(2, order.description());
            ps.setInt(3, order.id());
            return ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public Integer delete(int id) {
        try(Connection connection = dataSourse.getConnection();
            PreparedStatement ps = connection.prepareStatement(DELETE)){
            ps.setInt(1, id);
            return ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public ArrayList<Order> getAll() {
        ArrayList<Order> orders = new ArrayList<>();
        try(Connection connection = dataSourse.getConnection();
            Statement st = connection.createStatement()){
            ResultSet rs = st.executeQuery(SELECTALL);
            while (rs.next()){
                orders.add(new Order(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3)
                ));
            }
            return orders;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orders;
    }





















}
