package com.pis.Dao;

import com.pis.Entity.User;
import com.pis.Entity.UserRole;

import java.sql.*;
import java.util.ArrayList;

public class UserDao implements IDao<User> {
    String INSERT = "INSERT INTO users (name, surname, email, password) values (?,?,?,?)";
    String SELECTALL = "SELECT *  FROM users";
    String SELECT = "SELECT * FROM users WHERE users.id = ?" ;
    String SELECTBYNAME = "SELECT * FROM users WHERE name = ?";
    String UPDATE =  "UPDATE users SET name = ?, surname =?, email =?, password=? WHERE users.id = ? ";
    String DELETE = "DELETE FROM users WHERE id = ?";


    @Override
    public Integer insert(User user) {
        try(Connection connection = dataSourse.getConnection();
        PreparedStatement ps = connection.prepareStatement(INSERT)){
            ps.setString(1, user.name());
            ps.setString(2, user.surname());
            ps.setString(3, user.email());
            ps.setString(4, user.password());
            return ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public User getById(int id) {
        try(Connection connection = dataSourse.getConnection();
            PreparedStatement ps = connection.prepareStatement(SELECT)){
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next())
            return new User(rs.getInt(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getString(4),
                    rs.getString(5));
            else return null;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public User getByName(String name) {
        try(Connection connection = dataSourse.getConnection();
            PreparedStatement ps = connection.prepareStatement(SELECTBYNAME)){
            ResultSet rs = ps.executeQuery();
            if(rs.next())
                return new User(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5));
            else return null;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    @Override
    public Integer update(User user) {
        try(Connection connection = dataSourse.getConnection();
            PreparedStatement ps = connection.prepareStatement(UPDATE)){
            ps.setString(1, user.name());
            ps.setString(2, user.surname());
            ps.setString(3, user.email());
            ps.setString(4, user.password());
            ps.setInt(5, user.id());
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
    public ArrayList<User> getAll() {
        ArrayList<User> users = new ArrayList<>();
        try(Connection connection = dataSourse.getConnection();
            Statement st = connection.createStatement()){
            ResultSet rs = st.executeQuery(SELECTALL);
            while (rs.next()){
                users.add(new User(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5)
                        ));
            }
            return users;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }
}
