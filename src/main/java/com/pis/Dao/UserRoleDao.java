package com.pis.Dao;

import com.pis.Entity.Role;
import com.pis.Entity.User;
import com.pis.Entity.UserRole;

import java.sql.*;
import java.util.ArrayList;

public class UserRoleDao implements IDao<UserRole>{
    String INSERT = "INSERT INTO user_role (user_id, role_id) values (?,?)";
    String SELECTALL = "SELECT *  FROM user_role";
    String SELECT = "SELECT * FROM user_role WHERE users_roles.id = ?" ;
    String UPDATE =  "UPDATE user_role SET user_id = ?, role_id =? WHERE user_role.id = ? ";
    String DELETE = "DELETE FROM user_role WHERE id = ?";





    @Override
    public Integer insert(UserRole userRole) {
        try(Connection connection = dataSourse.getConnection();
            PreparedStatement ps = connection.prepareStatement(INSERT)){
            ps.setInt(1, userRole.user_id());
            ps.setInt(2, userRole.role_id());
            return ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public UserRole getById(int id) {
        try(Connection connection = dataSourse.getConnection();
            PreparedStatement ps = connection.prepareStatement(SELECT)){
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next())
                return new UserRole(rs.getInt(1),
                        rs.getInt(2),
                        rs.getInt(3));
            else return null;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public UserRole getByName(String name) {
        try(Connection connection = dataSourse.getConnection();
            PreparedStatement ps = connection.prepareStatement(SELECT)){
            ResultSet rs = ps.executeQuery();
            if(rs.next())
                return new UserRole(rs.getInt(1),
                        rs.getInt(2),
                        rs.getInt(3));
            else return null;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    @Override
    public Integer update(UserRole userRole) {
        try(Connection connection = dataSourse.getConnection();
            PreparedStatement ps = connection.prepareStatement(UPDATE)){
            ps.setInt(1, userRole.user_id());
            ps.setInt(2, userRole.role_id());
            ps.setInt(5, userRole.id());
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
    public ArrayList<UserRole> getAll() {
        ArrayList<UserRole> userRoles = new ArrayList<>();
        try(Connection connection = dataSourse.getConnection();
            Statement st = connection.createStatement()){
            ResultSet rs = st.executeQuery(SELECTALL);
            while (rs.next()){
                userRoles.add(new UserRole(
                        rs.getInt(1),
                        rs.getInt(2),
                        rs.getInt(3)
                ));
            }
            return userRoles;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userRoles;
    }

}
