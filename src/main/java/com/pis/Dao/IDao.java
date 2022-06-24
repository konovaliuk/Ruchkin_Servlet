package com.pis.Dao;

import com.pis.ConnectionPool.ConnectionPool;
import com.pis.Entity.User;

import javax.sql.DataSource;
import java.util.ArrayList;

public interface IDao<T> {
    Integer insert(T adr);
    T getById(int id);

    T getByName(String name);
    Integer update(T adr);
    Integer delete(int id);
    ArrayList<T> getAll();

    /*void getUserRole(User user);*/

    DataSource dataSourse = ConnectionPool.getDatasource();
}
