package com.example.Task_Management.mappers.modelToDto;

import com.example.Task_Management.dto.request.AuthenticateUserReq;
import com.example.Task_Management.dto.response.AllUsersRes;
import com.example.Task_Management.entities.*;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;
@Mapper(componentModel = "spring")
public interface ModelMappers {
    AuthenticateUserReq userToAuthenticateUserReq(User user);
    List<AllUsersRes> userListToAllUsersRes(List<User> userList);
}
