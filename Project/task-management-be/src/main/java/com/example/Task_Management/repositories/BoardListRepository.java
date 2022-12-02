package com.example.Task_Management.repositories;

import com.example.Task_Management.entities.BoardList;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;

@Component
public interface BoardListRepository extends MongoRepository<BoardList,String> { }
