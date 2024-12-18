package com.dev.houseinventory.services;

import com.dev.houseinventory.entities.Category;
import com.dev.houseinventory.repository.ICategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService  implements ICategoryService {

    @Autowired
    ICategoryRepository categoryRepository;

    @Override
    public Category addCategory(Category category) {
        categoryRepository.save(category);
        return null;
    }

    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }
}
