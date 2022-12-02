package com.example.Task_Management.mappers.dtoToModel;

import com.example.Task_Management.dto.request.AuthenticateUserReq;
import com.example.Task_Management.entities.*;
import org.mapstruct.Mapper;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
public interface DTOMappers {
    User authenicateUserDtoToUser(AuthenticateUserReq authenicateUserDto);
}
