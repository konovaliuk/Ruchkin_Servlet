package com.pis.services;

import com.pis.Dao.CategoryDao;
import com.pis.Entity.Category;

import java.util.ArrayList;

public class CategoryService {

    public Category findByType(String type){
        Category category;
        CategoryDao categoryDao = new CategoryDao();
        category = categoryDao.getByName(type);
        return category;
    }


    public Category findByID(int id){
        Category category;
        CategoryDao categoryDao = new CategoryDao();
        category = categoryDao.getById(id);
        return category;
    }

    public ArrayList<Category> getAllCategories(){
        CategoryDao categoryDao = new CategoryDao();
        return categoryDao.getAll();
    }


}
