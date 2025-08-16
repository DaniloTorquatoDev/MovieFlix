package com.movieflix.service;

import com.movieflix.entity.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.movieflix.repository.CategoryRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
    @Autowired
    CategoryRepository categoryRepository;

    public Category addCategory(Category category) {
        return categoryRepository.save(category);
    }

    public List<Category> listCategory(Category category) {
        return categoryRepository.findAll();
    }

    public  Optional<Category> ListCategoryById(Long id) {
        return categoryRepository.findById(id);
    }

    public void deleteCategory(Long id){
        categoryRepository.deleteById(id);
    }

    public List<Category> updateCategory(Category category, Long id){
        Optional<Category> existentCategory = categoryRepository.findById(id);
        if(existentCategory.isPresent()) {
            categoryRepository.save(category);
            category.setId(id);
        }
        return null;
    }

}
