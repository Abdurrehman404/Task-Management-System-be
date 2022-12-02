package com.example.Task_Management.repositories;

import com.example.Task_Management.entities.*;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;
@Component
public interface UserRepository extends MongoRepository<User,String> {
    Optional<User> findByUserNameAndPassword(String usr, String pass);
    Optional<User> findUserByUserName(String userName);
}
