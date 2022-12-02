package com.example.Task_Management.Utilities;

import org.springframework.stereotype.Component;

@Component
public class RandomPasswordUtil {

    public String generateRandomPassword(int passLength){

        String pass = "";
        for(int i =0;i < passLength;i++){
            pass += (int)((Math.random() * (10)) + 0);
        }
        return pass.toString();
    }
}
