package com.pis.services;



import com.pis.Dao.RoleDao;
import com.pis.Entity.Role;

import java.util.ArrayList;

public class RoleService {
    RoleDao roleDao = new RoleDao();

    public Role getByID(int id){

        Role role = roleDao.getById(id);
        return role;
    }

    public Role getByName(int id){

        Role role = roleDao.getById(id);
        return role;
    }

    public ArrayList<Role> getAllRoles(){

        ArrayList<Role> roles = roleDao.getAll();
        return roles;
    }













}
