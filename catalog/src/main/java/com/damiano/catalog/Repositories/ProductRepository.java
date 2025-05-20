package com.damiano.catalog.Repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.damiano.catalog.Models.Product;

public interface ProductRepository extends MongoRepository<Product,String>{

    List<Product> findByCategory(String category);
}
