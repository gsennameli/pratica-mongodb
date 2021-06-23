package com.example.praticamongo.models;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document(collection = "addresses")
public class Address {
    @Id
    private String name;

    private String street;

    private String zipcode;
}
