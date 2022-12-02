package com.example.Task_Management.entities;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.FieldType;
import java.time.LocalDateTime;

//@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Document("UserAccess")
public class UserAccess {

    @Id
    @Field(name = "_id",targetType = FieldType.OBJECT_ID)
    private String id;
    private String userName;
    private String tempPass;
    private LocalDateTime timeStamp;
}
