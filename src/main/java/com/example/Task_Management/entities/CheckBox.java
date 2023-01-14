package com.example.Task_Management.entities;


import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.FieldType;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Document("CheckBox")
public class CheckBox {
    @Id
    @Field(name = "_id",targetType = FieldType.OBJECT_ID)
    String id;

    boolean isChecked;
    String description;
}
