package com.damiano.purchases.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.damiano.purchases.models.ShoppingCart;

public interface ShoppingCartRepository extends MongoRepository<ShoppingCart,String>{

}
