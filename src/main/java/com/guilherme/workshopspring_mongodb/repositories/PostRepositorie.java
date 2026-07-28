package com.guilherme.workshopspring_mongodb.repositories;

import com.guilherme.workshopspring_mongodb.domain.Post;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface PostRepositorie extends MongoRepository<Post, String> {

    List<Post> findByTitleContainingIgnoreCase(String title);

    @Query("{ 'title': { $regex: ?0, $options: 'i' } }")
    List<Post> buscasTitulo(String title);

    @Query("{ $and: [ { 'date': { $gte: ?1 } }, { 'date': { $lte: ?2 } } , { $or: [ { 'title': { $regex: ?0, $options: 'i' } }, { 'body': { $regex: ?0, $options: 'i' } },{ 'commentDTOS.text': { $regex: ?0, $options: 'i' } } ] } ] }")
    List<Post> buscaCompleta(String msg, LocalDate minDate, LocalDate maxDate);
}
