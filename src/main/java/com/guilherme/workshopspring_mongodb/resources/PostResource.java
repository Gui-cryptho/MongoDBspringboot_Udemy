package com.guilherme.workshopspring_mongodb.resources;

import com.guilherme.workshopspring_mongodb.domain.Post;
import com.guilherme.workshopspring_mongodb.resources.utils.URLUtils;
import com.guilherme.workshopspring_mongodb.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @RequestMapping(value = "findbytitle", method = RequestMethod.GET)
    public ResponseEntity<List<Post>> findByTitle(@RequestParam(value = "title", defaultValue = "") String title){
        String msg = URLUtils.decodeUrl(title);
        List<Post> obj = postService.findByTitle(msg);

        return ResponseEntity.ok().body(obj);
    }
}
