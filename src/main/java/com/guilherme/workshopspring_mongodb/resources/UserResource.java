package com.guilherme.workshopspring_mongodb.resources;

import com.guilherme.workshopspring_mongodb.domain.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @RequestMapping(method = RequestMethod.GET)
    public List<User> findAll(){
        User maria = new User("1", "maria brown", "maria@gmai.com");
        User guilherme = new User("2", "guilherme brito", "guilherme@gmail.com");

        List<User> obj = new ArrayList<>();
        obj.addAll(Arrays.asList(maria, guilherme));
        return obj;
    }

}
