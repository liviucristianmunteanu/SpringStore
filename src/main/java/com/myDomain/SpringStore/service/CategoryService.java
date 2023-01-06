package com.myDomain.SpringStore.service;

import com.myDomain.SpringStore.model.Category;
import com.myDomain.SpringStore.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    @Autowired
    CategoryRepository categoryRepository;

    public void createCategory (Category category) {
        categoryRepository.save(category);
    }

    public List<Category> listCategories(){
        return categoryRepository.findAll();
    }

    public void editCategory(Long categoryId, Category updateCategory) {
        Category category = categoryRepository.getReferenceById(categoryId);
        category.setCategoryName(updateCategory.getCategoryName());
        category.setDescription(updateCategory.getDescription());
        category.setImageUrl(updateCategory.getImageUrl());
        categoryRepository.save(category);
    }

    public void deleteCategory(Long categoryId) {
        Category category = categoryRepository.getReferenceById(categoryId);
        categoryRepository.deleteById(categoryId);
    }
}
