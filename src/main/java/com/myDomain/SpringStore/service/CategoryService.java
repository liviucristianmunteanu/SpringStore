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
}
