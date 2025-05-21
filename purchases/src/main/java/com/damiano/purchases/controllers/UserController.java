package com.damiano.purchases.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.damiano.purchases.models.User;
import com.damiano.purchases.models.DTOs.UserDTO;
import com.damiano.purchases.services.UserService;

@RestController
@RequestMapping("api/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService uService){
        userService = uService;
    }

    @GetMapping("")
    public List<UserDTO> getAllUsers(){
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public UserDTO getUserById(@PathVariable String id){
        return userService.getUserById(id);
    }

    @PostMapping("")
    public User createUser(@RequestBody User user){
        return userService.createUser(user);
    }
}
