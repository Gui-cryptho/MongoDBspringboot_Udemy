package com.guilherme.workshopspring_mongodb.resources;

import com.guilherme.workshopspring_mongodb.domain.Post;
import com.guilherme.workshopspring_mongodb.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "posts")
public class PostResource {

    @Autowired
    private PostService postService;

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public ResponseEntity<Post> finByid(@PathVariable String id){
        Post obj = postService.findById(id);

        return ResponseEntity.ok().body(obj);
    }
}
