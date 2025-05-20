package com.damiano.catalog.Models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {
    private String code;
    private String name;
    private String description;
    private int stock;
    private double price;
    private String category;
}
