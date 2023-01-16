package com.example.consumer.entity;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
public class User {

    @Id
    private String id;

    private String username;

    public User(String username) {
        this.username = username;
    }
}
