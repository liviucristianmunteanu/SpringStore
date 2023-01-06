package com.myDomain.SpringStore.controller;

import com.myDomain.SpringStore.model.Category;
import com.myDomain.SpringStore.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    CategoryService categoryService;
    @PostMapping("/create")
    public String createCategory(@RequestBody Category category){
        categoryService.createCategory(category);
        return "Category created successfully!";
    }

    @GetMapping("/list")
    public List<Category> categoryList(){
        return categoryService.listCategories();
    }

    @PostMapping("/update/{categoryId}")
    public String updateCategory(@PathVariable("categoryId") Long categoryId,
                                 @RequestBody Category category){

        categoryService.editCategory(categoryId,category);
        return "Category updated successfully!";
    }

    @DeleteMapping(value = "delete/{categoryId}")
    public String deleteCategory(@PathVariable Long categoryId){
        categoryService.deleteCategory(categoryId);
        return "category deleted";
    }
}
