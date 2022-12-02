package com.example.Task_Management.services;

import com.example.Task_Management.entities.User;
import com.example.Task_Management.entities.UserAccess;
import com.example.Task_Management.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;
@Service
public class UserServiceImpl implements UserService{

    int passLength = 10;
    @Autowired
    UserRepository userRepo;
    @Autowired
    UserAccessServiceImpl userAccessServiceImpl;
    @Override
    public List<User> getUsers() {
        return userRepo.findAll();
    }
    @Override
    public Optional<User> getUser(String userName) {
        return userRepo.findUserByUserName(userName);
    }
    @Override
    public boolean addUser(User user) {
        System.out.print(userRepo.insert(user));
        return true;
    }
    @Override
    public  Optional<User> AuthenticateUser(String userName,String password){
        return userRepo.findByUserNameAndPassword(userName,password);
    }

    @Override
    public Optional<UserAccess> AuthenticateTempUser(String userName, String password) {
        Optional<UserAccess> userAccess = userAccessServiceImpl.userAccessRepo.findUserAccessByUserNameAndTempPass(userName,password);
        if(userAccess.isPresent()) {
            if (ChronoUnit.MINUTES.between(userAccess.get().getTimeStamp(), LocalDateTime.now()) > 60) { // Check for temporary password expiry
                //userAccessServiceImpl.userAccessRepo.delete(userAccess.get()); // Deleting the UserAccess object
                return Optional.empty();
            } else {
                return userAccess;
            }
        }
        return Optional.empty();
    }

    @Override
    public void deleteUser(String id){
        userRepo.deleteById(id);
    }

    @Override
    public boolean resetPassword(String userName,String pass) {
        userAccessServiceImpl.createUserAccess(userName,pass);
        return true;
    }
    @Override
    public User updateUser(User user) {
        return userRepo.save(user);
    }


}
