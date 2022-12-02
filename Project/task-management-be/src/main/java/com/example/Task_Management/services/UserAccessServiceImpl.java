package com.example.Task_Management.services;

import com.example.Task_Management.Utilities.RandomPasswordUtil;
import com.example.Task_Management.entities.UserAccess;
import com.example.Task_Management.repositories.UserAccessRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Optional;

@Component
public class UserAccessServiceImpl implements UserAccessService{
    @Autowired
    public UserAccessRepository userAccessRepo;

    @Override
    public UserAccess createUserAccess(String userName,String pass) {
        Optional<UserAccess> userAccess = findUserAccessByUserName(userName);
        if(!userAccess.isPresent()){ // Case for new User Access //
            userAccess = Optional.of(new UserAccess(new ObjectId().toString(),userName, pass, LocalDateTime.now()));
            userAccessRepo.save(userAccess.get());
        }else { // Case for already present User Access
            userAccess.get().setTempPass(pass);
            userAccess.get().setTimeStamp(LocalDateTime.now());
            userAccessRepo.save(userAccess.get());
        }

        return null;
    }

    @Override
    public Optional<UserAccess> findUserAccessByUserName(String userName) {
        return userAccessRepo.findUserAccessByUserName(userName);
    }
}
