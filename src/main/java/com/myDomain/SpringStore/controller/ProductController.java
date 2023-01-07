package com.myDomain.SpringStore.controller;

import com.myDomain.SpringStore.dto.ProductDto;
import com.myDomain.SpringStore.model.Category;
import com.myDomain.SpringStore.repository.CategoryRepository;
import com.myDomain.SpringStore.repository.ProductRepository;
import com.myDomain.SpringStore.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    ProductService productService;

    @Autowired
    CategoryRepository categoryRepository;

    @PostMapping("/add")
    public String  createProduct(@RequestBody ProductDto productDto) {
        final Optional<Category> optionalCategory = categoryRepository.findById(productDto.getCategoryId());
        if(!optionalCategory.isPresent()){
            return "Category does not exist";
        }
        productService.createProduct(productDto , optionalCategory.get());
        return "product has been added";
    }
}
