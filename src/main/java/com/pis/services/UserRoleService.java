package com.pis.services;

import com.pis.Dao.UserRoleDao;
import com.pis.Entity.UserRole;

import java.util.ArrayList;

public class UserRoleService {
    UserRoleDao userRoleDao = new UserRoleDao();

    public ArrayList<UserRole> getAll() {
        ArrayList<UserRole> RolesForUsers = userRoleDao.getAll();
        return RolesForUsers;
    }


    public Boolean AdminCheck(Integer user_id){
        ArrayList<UserRole> userRoles = userRoleDao.getAll();

        for(UserRole userRole: userRoles){
            if (userRole.role_id().equals(2) && userRole.user_id().equals(user_id))
                return true;
        }
        return false;
    }


    public void delete(int id) {
        userRoleDao.delete(id);
    }



}
