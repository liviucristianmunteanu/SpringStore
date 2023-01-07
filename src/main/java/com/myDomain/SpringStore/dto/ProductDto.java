package com.myDomain.SpringStore.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDto {
    private Long id;

    private String name;

    private String imageUrl;

    private double price;

    private String description;

    private Long categoryId;
}
