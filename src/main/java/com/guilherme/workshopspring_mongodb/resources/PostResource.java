package com.guilherme.workshopspring_mongodb.resources;

import com.guilherme.workshopspring_mongodb.domain.Post;
import com.guilherme.workshopspring_mongodb.resources.utils.URLUtils;
import com.guilherme.workshopspring_mongodb.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
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

    @RequestMapping(value = "buscaCompleta", method = RequestMethod.GET)
    public ResponseEntity<List<Post>> buscaCompleta(@RequestParam(value = "msg", defaultValue = "") String msg,
                                                    @RequestParam(value = "minDate", defaultValue = "") String minDate,
                                                    @RequestParam(value = "maxDate", defaultValue = "") String maxDate){
        String url = URLUtils.decodeUrl(msg);
        LocalDate mDate = URLUtils.stringFormatter(minDate, LocalDate.of(1970, 1, 1));
        LocalDate mxDate = URLUtils.stringFormatter(maxDate, LocalDate.now());
        List<Post> obj = postService.buscaCompleta(url, mDate, mxDate);

        return ResponseEntity.ok().body(obj);
    }

}
