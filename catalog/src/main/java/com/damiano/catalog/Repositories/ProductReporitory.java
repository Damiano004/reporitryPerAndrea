package com.damiano.catalog.Repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.damiano.catalog.Models.Product;

public interface ProductReporitory extends MongoRepository<String,Product>{

}
