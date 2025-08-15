package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import service.CategoryService;

@RestController
@RequestMapping("/movieflix/category")
public class CategoryController {
    @Autowired
    CategoryService categoryService;
}
