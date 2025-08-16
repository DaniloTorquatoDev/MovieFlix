package com.movieflix.controller;

import com.movieflix.entity.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.movieflix.service.CategoryService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/movieflix/category")
public class CategoryController {
    @Autowired
    CategoryService categoryService;

    @PostMapping
    public Category addCategory(@RequestBody Category category) {
        return categoryService.addCategory(category);
    }

    @GetMapping
    public List<Category> listCategory(Category category) {
        return categoryService.listCategory(category);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> listCategoryById(@PathVariable Long id) {
        return categoryService.ListCategoryById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());

    }

    @DeleteMapping("/{id}")
    public void deleteCategory(@PathVariable Long id) {
        categoryService.deleteCategory(id);
    }

    @PutMapping("/{id}")
    public List<Category> updateCategory(@RequestBody Category category, @PathVariable Long id){
        return categoryService.updateCategory(category,id);
    }
}
