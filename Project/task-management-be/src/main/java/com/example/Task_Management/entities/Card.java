package com.example.Task_Management.entities;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.FieldType;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Document("Card")
public class Card {
    @Id
    @Field(name = "_id",targetType = FieldType.OBJECT_ID)
    String id;

    String title;
    String task;
    //LocalDateTime estimatedTime;
    LocalDateTime createdOn;
    LocalDateTime updatedOn;
    String type;
    @Builder.Default
    String hex ="ffffff";
    //List<CheckBox> checkBoxList;
}
