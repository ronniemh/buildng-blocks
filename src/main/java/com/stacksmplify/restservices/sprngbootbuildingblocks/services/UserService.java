package com.stacksmplify.restservices.sprngbootbuildingblocks.services;

import java.util.List;

import com.stacksmplify.restservices.sprngbootbuildingblocks.entities.User;
import com.stacksmplify.restservices.sprngbootbuildingblocks.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * UserService
 */
public class UserService {

    // Autowire the UserRepository

    @Autowired
    private UserRepository userRepository;

    // get all users method
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

}