package com.eccomerce.project.controller;

import com.eccomerce.project.model.Category;
import com.eccomerce.project.service.CategoryService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class CategoryController {
    private CategoryService categoryService;

    public CategoryController(CategoryService categoryService){
        this.categoryService=categoryService;
    }


    @GetMapping("/public/categories")
    public ResponseEntity<List<Category>> getAllCategories(){

        List<Category> categories = categoryService.getAllCategories();

        return ResponseEntity.ok(categories);
    }


    @PostMapping("/public/categories")
    public ResponseEntity<Category> createCategory(@Valid @RequestBody Category category){

        categoryService.createCategory(category);

        return ResponseEntity.status(201)
                .body(category);
    }

    @DeleteMapping("/admin/categories/{categoryId}")
    public ResponseEntity<String> deleteCategory(@PathVariable Long categoryId){
        try {
            categoryService.deleteCategory(categoryId);
            return ResponseEntity.ok("Category Deleted Successfully");

        } catch (RuntimeException e) {

            return ResponseEntity.status(404)
                    .body("Category not found");
        }
    }

    @PutMapping("/admin/categories/{categoryId}")
    public ResponseEntity<Category> updateCategory(
            @RequestBody Category category,
            @PathVariable Long categoryId){

        Category savedCategory =
                categoryService.updateCategory(category, categoryId);

        return ResponseEntity.ok(savedCategory);
    }
}
