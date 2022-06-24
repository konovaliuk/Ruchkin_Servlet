package com.pis.services;

import com.pis.Dao.UserDao;
import com.pis.Entity.User;

import java.util.List;

public class UserService {
    UserDao userDao = new UserDao();

    public boolean createUser(Integer id, String name, String surname, String email, String password){

        Integer rec = userDao.insert(new User(id, name,surname,email,password));

        return rec != null;
    }

    public void updateUser(User user){
        userDao.update(user);
    }

    public User findByID(int id){
        User user;
        user = userDao.getById(id);
        return user;
    }

    public List<User> getAllUsers(){
        UserDao userDao = new UserDao();
        return userDao.getAll();
    }

    public User isExist(String username, String password){
        List<User> users = userDao.getAll();
        for(User user: users){
            if(user.name().equals(username) && user.password().equals(password)){
                return user;
            }
        }
        return null;
    }

    public Boolean isUserUnique(String username){
        List<User> users = userDao.getAll();
        for(User user: users){
            if(user.name().equals(username)){
                return false;
            }
        }
        return true;
    }

    public void deleteUser(Integer id){
        userDao.delete(id);
    }

}
