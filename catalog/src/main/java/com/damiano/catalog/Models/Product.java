package com.damiano.catalog.Models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.mongodb.lang.NonNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection =  "products")
public class Product {
    @Id
    private String id;
    @NonNull
    private String code;
    private String name;
    private String description;
    private int stock;
    private double price;
    private String category;
}
