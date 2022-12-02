package com.example.Task_Management.dto.request;

import lombok.*;

import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

@Getter
@Setter
public class AuthenticateUserReq {
    @NonNull
    private String userName;
    @NonNull
    @Size(min = 8,max = 50)
    private String password;
}
