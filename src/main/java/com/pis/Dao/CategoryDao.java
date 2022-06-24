package com.pis.Dao;

import com.pis.Entity.Category;
import com.pis.Entity.User;

import java.sql.*;
import java.util.ArrayList;

public class CategoryDao implements IDao<Category> {
    String INSERT = "INSERT INTO category (type) value (?)";
    String SELECTALL = "SELECT *  FROM category";
    String SELECT = "SELECT * FROM category WHERE category.id = ?" ;
    String SELECTBYNAME = "SELECT * FROM category WHERE type = ?";
    String UPDATE =  "UPDATE category SET type = ? WHERE category.id = ? ";
    String DELETE = "DELETE FROM category WHERE id = ?";

    @Override
    public Integer insert(Category category) {
        try(Connection connection = dataSourse.getConnection();
            PreparedStatement ps = connection.prepareStatement(INSERT)){
            ps.setString(1, category.type());
            return ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public Category getById(int id) {
        try(Connection connection = dataSourse.getConnection();
            PreparedStatement ps = connection.prepareStatement(SELECT)){
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next())
                return new Category(rs.getInt(1),
                        rs.getString(2));
            else return null;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Category getByName(String name) {
        try(Connection connection = dataSourse.getConnection();
            PreparedStatement ps = connection.prepareStatement(SELECTBYNAME)){
            ResultSet rs = ps.executeQuery();
            if(rs.next())
                return new Category(rs.getInt(1),
                        rs.getString(2));
            else return null;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Integer update(Category category) {
        try(Connection connection = dataSourse.getConnection();
            PreparedStatement ps = connection.prepareStatement(UPDATE)){
            ps.setString(1, category.type());
            ps.setInt(2, category.id());
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
    public ArrayList<Category> getAll() {
        ArrayList<Category> categories = new ArrayList<>();
        try(Connection connection = dataSourse.getConnection();
            Statement st = connection.createStatement()){
            ResultSet rs = st.executeQuery(SELECTALL);
            while (rs.next()){
                categories.add(new Category(
                        rs.getInt(1),
                        rs.getString(2)));
            }
            return categories;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return categories;
    }
}
