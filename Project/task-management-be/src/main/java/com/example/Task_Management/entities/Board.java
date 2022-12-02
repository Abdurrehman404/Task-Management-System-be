package com.example.Task_Management.entities;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.FieldType;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Document("Board")
public class Board {
    @Id
    @Field(name = "_id",targetType = FieldType.OBJECT_ID)
    String id;
    String boardName = "My board";
    LocalDateTime createdOn = LocalDateTime.now();
    LocalDateTime updatedOn;
    List<String> listIds = new ArrayList<>();
    String assignedTo; // userName , id
}
