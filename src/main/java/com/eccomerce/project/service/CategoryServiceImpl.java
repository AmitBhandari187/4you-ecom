package com.eccomerce.project.service;

import com.eccomerce.project.model.Category;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService{
    private List<Category> categories=new ArrayList<>();

    @Override
    public List<Category> getAllCategories() {
        return categories;
    }

    @Override
    public void createCategory(Category category) {
        categories.add(category);
    }

    @Override
    public void deleteCategory(Long categoryId) {
        Category category=categories.stream()
                .filter(c->c.getCategoryId().equals(categoryId))
                .findFirst()
                .orElseThrow(()->
                        new RuntimeException("Category not found"));
        categories.remove(category);
    }

    @Override
    public Category updateCategory(Category category, Long categoryId) {
        Category savedCategory = categories.stream()
                .filter(c -> c.getCategoryId().equals(categoryId))
                .findFirst()
                .orElseThrow(() ->
                        new RuntimeException("Category not found"));

        savedCategory.setCategoryName(category.getCategoryName());

        return savedCategory;

    }
}
