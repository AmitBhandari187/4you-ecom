package com.eccomerce.project.service;

import com.eccomerce.project.model.Category;

import java.util.List;

public interface CategoryService {
    List<Category> getAllCategories();
    void createCategory(Category category);
    void deleteCategory(Long categoryId);
    Category updateCategory( Category category,Long categoryId);
}
