package com.guilherme.workshopspring_mongodb.services;

import com.guilherme.workshopspring_mongodb.domain.Post;
import com.guilherme.workshopspring_mongodb.repositories.PostRepositorie;
import com.guilherme.workshopspring_mongodb.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private PostRepositorie postRepositorie;

    public Post findById(String id){
        Optional<Post> obj = postRepositorie.findById(id);
        return obj.orElseThrow(() -> new ResourceNotFoundException("Obejto nao encontrado"));

    }
}
