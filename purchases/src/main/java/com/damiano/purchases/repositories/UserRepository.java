package com.damiano.purchases.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.damiano.purchases.models.User;

public interface UserRepository extends MongoRepository<User,String>{

}
