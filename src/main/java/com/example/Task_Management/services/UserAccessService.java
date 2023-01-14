package com.example.Task_Management.services;

import ch.qos.logback.core.pattern.parser.OptionTokenizer;
import com.example.Task_Management.entities.UserAccess;

import java.util.Optional;

public interface UserAccessService {
    UserAccess createUserAccess(String userName,String pass);

    Optional<UserAccess> findUserAccessByUserName(String userName);
}
