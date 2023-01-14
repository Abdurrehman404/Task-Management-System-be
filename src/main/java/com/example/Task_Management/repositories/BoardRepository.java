package com.example.Task_Management.repositories;

import com.example.Task_Management.entities.Board;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;

@Component
public interface BoardRepository extends MongoRepository<Board,String> {
    public Board findBoardByAssignedTo(String userName);
}
