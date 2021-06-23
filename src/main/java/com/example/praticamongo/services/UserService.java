package com.example.praticamongo.services;

import com.example.praticamongo.models.User;
import com.example.praticamongo.repositories.AddressRepository;
import com.example.praticamongo.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class UserService {
    private UserRepository userRepository;
    private AddressRepository addressRepository;

    public List<User> findAllUsers(){
        return userRepository.findAll();
    }

    public User findUserById(String id){
        return userRepository.findById(id).orElse(null);
    }

    public User createUser(User user){
        addressRepository.saveAll(user.getAddresses());
        return userRepository.save(user);
    }

    public String removeUserById(String id){
        userRepository.deleteById(id);

        return "Usuário removido com sucesso";
    }

    public ResponseEntity updateUser(User userToUpdate){
        User user = userRepository.findById(userToUpdate.getId()).orElse(null);
        if(user == null)
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        user.setAddresses(userToUpdate.getAddresses());
        user.setLogin(userToUpdate.getLogin());
        user.setPassword(userToUpdate.getPassword());
        return new ResponseEntity(userRepository.save(user),HttpStatus.OK);
    }
}
