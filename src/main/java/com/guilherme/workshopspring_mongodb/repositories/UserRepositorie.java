package com.guilherme.workshopspring_mongodb.repositories;

import com.guilherme.workshopspring_mongodb.domain.User;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepositorie extends MongoRepository<User, String> {

}
