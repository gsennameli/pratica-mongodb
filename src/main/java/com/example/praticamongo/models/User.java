package com.example.praticamongo.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@Document(collection = "users")
public class User {
    @Id
    private String id;

    private String login;

    private String password;

    @DBRef
    private List<Address> addresses;
}
