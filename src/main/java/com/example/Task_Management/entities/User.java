package com.example.Task_Management.entities;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.FieldType;

//@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Document("User")
public class User{
    @Id
    @Field(name = "_id",targetType = FieldType.OBJECT_ID)
    private String id;

    private String name;
    @Indexed(unique = true)
    private String userName;
    private String password;
    private String type;
    private String email;
}
