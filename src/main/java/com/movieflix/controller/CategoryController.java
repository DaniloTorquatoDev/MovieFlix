package com.movieflix.controller;

import com.movieflix.controller.request.CategoryResponse;
import com.movieflix.controller.response.CategoryRequest;
import com.movieflix.entity.Category;
import com.movieflix.mapper.CategoryMapper;
import org.aspectj.apache.bcel.classfile.Module;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.movieflix.service.CategoryService;

import java.util.List;
import java.util.Locale;
import java.util.Optional;

@RestController
@RequestMapping("/movieflix/category")
public class CategoryController {
    @Autowired
    CategoryService categoryService;

    @PostMapping
    public ResponseEntity<CategoryResponse> addCategory(@RequestBody CategoryRequest categoryRequest) {
        Category newCategory = CategoryMapper.toCategory(categoryRequest);
        Category savedCategory = categoryService.addCategory(newCategory);
        return ResponseEntity.status(HttpStatus.CREATED).body(CategoryMapper.toCategoryResponse(savedCategory));
    }

    @GetMapping
    public ResponseEntity<List<CategoryResponse>> listCategory() {
        List<CategoryResponse> categories = categoryService.listCategory()
                .stream()
                .map(CategoryMapper::toCategoryResponse)
                .toList();
        return ResponseEntity.ok(categories);

    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoryResponse> listCategoryById(@PathVariable Long id) {
        return categoryService.ListCategoryById(id)
                .map(category ->ResponseEntity.ok(CategoryMapper.toCategoryResponse(category)))
                .orElse(ResponseEntity.notFound().build());
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable Long id) {
        categoryService.deleteCategory(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}