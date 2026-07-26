package com.guilherme.workshopspring_mongodb.repositories;

import com.guilherme.workshopspring_mongodb.domain.Post;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface PostRepositorie extends MongoRepository<Post, String> {

    List<Post> findByTitleContainingIgnoreCase(String title);
}
