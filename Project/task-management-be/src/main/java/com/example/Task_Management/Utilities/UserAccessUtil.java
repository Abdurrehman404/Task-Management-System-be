package com.example.Task_Management.Utilities;

import com.example.Task_Management.entities.UserAccess;
import com.example.Task_Management.services.UserAccessServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Component
public class UserAccessUtil {

    @Autowired
    UserAccessServiceImpl userAccessService;

    @Scheduled(fixedDelay = 600000)
    public void UserAccessTime(){
        List<UserAccess> userAccess = userAccessService.userAccessRepo.findAll();
        for (UserAccess access : userAccess) {
            if (ChronoUnit.MINUTES.between(access.getTimeStamp(), LocalDateTime.now()) > 60) {
                userAccessService.userAccessRepo.delete(access);
            }
        }
    }
}
