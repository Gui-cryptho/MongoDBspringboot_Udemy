package com.guilherme.workshopspring_mongodb.resources;

import com.guilherme.workshopspring_mongodb.domain.User;
import com.guilherme.workshopspring_mongodb.dto.UserDTO;
import com.guilherme.workshopspring_mongodb.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<UserDTO>> findAll(){
        List<User> obj = userService.findAll();

        List<UserDTO> objDTO = obj.stream().map(x -> new UserDTO(x)).collect(Collectors.toList());

        return ResponseEntity.ok().body(objDTO);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public ResponseEntity<UserDTO> findById(@PathVariable String id){
        User obj = userService.findById(id);

        return ResponseEntity.ok().body(new UserDTO(obj));
    }

}
