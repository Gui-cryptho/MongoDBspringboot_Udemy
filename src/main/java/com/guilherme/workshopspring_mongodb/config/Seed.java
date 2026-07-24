package com.guilherme.workshopspring_mongodb.config;

import com.guilherme.workshopspring_mongodb.domain.Post;
import com.guilherme.workshopspring_mongodb.domain.User;
import com.guilherme.workshopspring_mongodb.dto.AuthorDTO;
import com.guilherme.workshopspring_mongodb.repositories.PostRepositorie;
import com.guilherme.workshopspring_mongodb.repositories.UserRepositorie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.time.Instant;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;

@Configuration
public class Seed implements CommandLineRunner {

    @Autowired
    private UserRepositorie userRepositorie;

    @Autowired
    private PostRepositorie postRepositorie;

    @Override
    public void run(String... args) throws Exception {

        userRepositorie.deleteAll();
        postRepositorie.deleteAll();

        DateTimeFormatter ftm1 = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        User u1 = new User(null, "maria brown", "maria@gmail.com");
        User u2 = new User(null, "james bond", "james@gmail.com");

        userRepositorie.saveAll(Arrays.asList(u1, u2));

        Post p1 = new Post(null, LocalDate.parse("2018-03-21", ftm1),"Partiu viagem", "Vou viajar para São Paulo. Abraços!", new AuthorDTO(u1));
        Post p2 = new Post(null, LocalDate.parse("2018-03-23", ftm1), "Bom dia", "Acordei feliz hoje!", new AuthorDTO(u1));

        postRepositorie.saveAll(Arrays.asList(p1, p2));

        u1.getPosts().addAll(Arrays.asList(p1, p2));
        userRepositorie.save(u1);

    }
}
