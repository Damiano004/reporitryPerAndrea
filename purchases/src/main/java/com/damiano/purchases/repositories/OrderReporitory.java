package com.damiano.purchases.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.damiano.purchases.models.Order;

public interface OrderReporitory extends MongoRepository<Order,String>{

}
