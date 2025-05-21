package com.damiano.purchases.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.damiano.purchases.models.User;
import com.damiano.purchases.models.DTOs.UserDTO;
import com.damiano.purchases.repositories.UserRepository;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository uRepo){
        userRepository = uRepo;
    }

    public List<UserDTO> getAllUsers(){
        return userRepository.findAll()
            .stream().map(u ->
                new UserDTO(
                    u.getName(),
                    u.getEmail(),
                    u.getAddress()
                )).toList();
    }

    public UserDTO getUserById(String id){
        User user = userRepository.findById(id).orElse(null);
        if(user == null){
            return null;
        }
        return new UserDTO(
            user.getName(),
            user.getEmail(),
            user.getAddress()
        );
    }

    public User createUser(User user){
        return userRepository.save(user);
    }
}
