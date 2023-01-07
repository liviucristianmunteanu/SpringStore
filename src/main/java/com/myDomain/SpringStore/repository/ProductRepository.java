package com.myDomain.SpringStore.repository;

import com.myDomain.SpringStore.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long> {
}
