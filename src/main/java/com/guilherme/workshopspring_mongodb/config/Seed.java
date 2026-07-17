package com.guilherme.workshopspring_mongodb.config;

import com.guilherme.workshopspring_mongodb.domain.User;
import com.guilherme.workshopspring_mongodb.repositories.UserRepositorie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.List;

@Configuration
public class Seed implements CommandLineRunner {

    @Autowired
    private UserRepositorie userRepositorie;

    @Override
    public void run(String... args) throws Exception {

        User u1 = new User(null, "maria brown", "maria@gmail.com");
        User u2 = new User(null, "james bond", "james@gmail.com");

        List<User> users = Arrays.asList(u1, u2);

        userRepositorie.saveAll(users);

    }
}
