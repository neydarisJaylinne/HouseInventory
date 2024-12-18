package com.dev.houseinventory.services;

import com.dev.houseinventory.entities.Category;
import com.dev.houseinventory.entities.Product;

import java.util.List;

public interface ICategoryService {
    public Category addCategory(Category category);
    public List<Category> getAllCategories();

}
