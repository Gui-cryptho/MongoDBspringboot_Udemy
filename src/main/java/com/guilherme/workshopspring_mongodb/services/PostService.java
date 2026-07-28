package com.guilherme.workshopspring_mongodb.services;

import com.guilherme.workshopspring_mongodb.domain.Post;
import com.guilherme.workshopspring_mongodb.repositories.PostRepositorie;
import com.guilherme.workshopspring_mongodb.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private PostRepositorie postRepositorie;

    public Post findById(String id){
        Optional<Post> obj = postRepositorie.findById(id);
        return obj.orElseThrow(() -> new ResourceNotFoundException("Obejto nao encontrado"));

    }

    public List<Post> findByTitle(String title){
        return postRepositorie.buscasTitulo(title);

    }

    public List<Post> buscaCompleta(String msg, LocalDate minDate, LocalDate maxDate){
        List<Post> obj = postRepositorie.buscaCompleta(msg, minDate, maxDate.plusDays(1));
        return obj;
    }
}
