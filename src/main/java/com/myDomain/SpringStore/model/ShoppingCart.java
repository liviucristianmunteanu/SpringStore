package com.myDomain.SpringStore.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class ShoppingCart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToMany
    private List<Product> products = new ArrayList<>();

    @OneToOne(mappedBy = "cart")
    private MyUser user;

    public void addProductToShoppingCart(Product p) {
        this.products.add(p);
    }

    public void removeProductFromShoppingCart(Product product) {
        this.products.remove(product);
    }
}
