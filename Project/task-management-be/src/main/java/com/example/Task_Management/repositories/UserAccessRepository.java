package com.example.Task_Management.repositories;

import com.example.Task_Management.entities.User;
import com.example.Task_Management.entities.UserAccess;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public interface UserAccessRepository extends MongoRepository<UserAccess,String> {
    //void updateByUserName(UserAccess obj);
    Optional<UserAccess> findUserAccessByUserName(String userName);
    Optional<UserAccess> findUserAccessByUserNameAndTempPass(String userName,String pass);
}
