package com.example.praticamongo.repositories;

import com.example.praticamongo.models.Address;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AddressRepository extends MongoRepository<Address,String> {
}
