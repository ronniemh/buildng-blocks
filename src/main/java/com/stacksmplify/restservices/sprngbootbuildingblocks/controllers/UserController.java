package com.stacksmplify.restservices.sprngbootbuildingblocks.controllers;

import java.util.List;

import com.stacksmplify.restservices.sprngbootbuildingblocks.entities.User;
import com.stacksmplify.restservices.sprngbootbuildingblocks.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * UserController
 * @param <UserService>
 */
@RestController
public class UserController {

    // Autowire the userService
    @Autowired
    private UserService userService;

    // GetAllUsers

    @GetMapping("/users")
    public List<User> GetAllUsers() {
        return userService.getAllUsers();
    }
}