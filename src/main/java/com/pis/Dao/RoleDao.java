package com.pis.Dao;

import com.pis.Entity.Role;
import com.pis.Entity.User;

import java.sql.*;
import java.util.ArrayList;

public class RoleDao implements IDao<Role> {

    String INSERT = "INSERT INTO roles (role_name) value (?)";
    String SELECTALL = "SELECT *  FROM roles";
    String SELECT = "SELECT * FROM roles WHERE roles.id = ?" ;
    String SELECTBYNAME = "SELECT * FROM roles WHERE role_name = ?";
    String UPDATE =  "UPDATE roles SET role_name = ? WHERE roles.id = ? ";
    String DELETE = "DELETE FROM roles WHERE id = ?";

    @Override
    public Integer insert(Role role) {
        try(Connection connection = dataSourse.getConnection();
            PreparedStatement ps = connection.prepareStatement(INSERT)){
            ps.setString(1, role.rolename());
            return ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public Role getById(int id) {
        try(Connection connection = dataSourse.getConnection();
            PreparedStatement ps = connection.prepareStatement(SELECT)){
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next())
                return new Role(rs.getInt(1),
                                rs.getString(2));
            else return null;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    @Override
    public Role getByName(String name) {
        try(Connection connection = dataSourse.getConnection();
            PreparedStatement ps = connection.prepareStatement(SELECTBYNAME)){
            ResultSet rs = ps.executeQuery();
            if(rs.next())
                return new Role(rs.getInt(1),
                        rs.getString(2));
            else return null;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Integer update(Role role) {
        try(Connection connection = dataSourse.getConnection();
            PreparedStatement ps = connection.prepareStatement(UPDATE)){
            ps.setString(1, role.rolename());
            ps.setInt(2, role.id());
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
    public ArrayList<Role> getAll() {
        ArrayList<Role> roles = new ArrayList<>();
        try(Connection connection = dataSourse.getConnection();
            Statement st = connection.createStatement()){
            ResultSet rs = st.executeQuery(SELECTALL);
            while (rs.next()){
                roles.add(new Role(
                        rs.getInt(1),
                        rs.getString(2)
                ));
            }
            return roles;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return roles;
    }

}
