package com.example.Task_Management.repositories;

import com.example.Task_Management.entities.Card;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface CardRepository extends MongoRepository<Card,String> { }
