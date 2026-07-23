package com.guilherme.workshopspring_mongodb.repositories;

import com.guilherme.workshopspring_mongodb.domain.Post;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PostRepositorie extends MongoRepository<Post, String> {
}
