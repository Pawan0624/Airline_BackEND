package com.wipro.velocity.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.wipro.velocity.model.User;

public interface UserRepository extends MongoRepository<User, Integer> {

	User findByemail(String email);
}
