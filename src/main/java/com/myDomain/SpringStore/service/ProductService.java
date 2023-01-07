package com.myDomain.SpringStore.service;

import com.myDomain.SpringStore.dto.ProductDto;
import com.myDomain.SpringStore.model.Category;
import com.myDomain.SpringStore.model.Product;
import com.myDomain.SpringStore.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Locale;

@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;

    public void createProduct(ProductDto productDto, Category category){
        Product product = new Product();
        product.setName(productDto.getName());
        product.setPrice(productDto.getPrice());
        product.setImageUrl(productDto.getImageUrl());
        product.setDescription(productDto.getDescription());
        product.setCategory(category);
        productRepository.save(product);
    }
}
