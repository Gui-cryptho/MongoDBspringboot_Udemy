package com.guilherme.workshopspring_mongodb.services;

import com.guilherme.workshopspring_mongodb.domain.User;
import com.guilherme.workshopspring_mongodb.repositories.UserRepositorie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepositorie userRepositorie;

    public List<User> findAll(){
        List<User> obj = userRepositorie.findAll();

        return obj;
    }
}
