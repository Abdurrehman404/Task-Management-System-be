package com.example.Task_Management.services;


import java.util.List;
import java.util.Optional;

import com.example.Task_Management.entities.*;
public interface UserService {
    List<User> getUsers();
    Optional<User> getUser(String userName);
    boolean addUser(User user);
    User updateUser(User user);
    Optional<User> AuthenticateUser(String userName,String password);
    Optional<UserAccess> AuthenticateTempUser(String userName, String password);

    void deleteUser(String id);
    boolean resetPassword(String userName,String pass);
}
