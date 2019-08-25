package com.stacksmplify.restservices.sprngbootbuildingblocks.services;

import java.util.List;
import java.util.Optional;

import com.stacksmplify.restservices.sprngbootbuildingblocks.entities.User;
import com.stacksmplify.restservices.sprngbootbuildingblocks.exceptions.UserNotFoundException;
import com.stacksmplify.restservices.sprngbootbuildingblocks.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * UserService
 */
@Service
public class UserService {

    // Autowire the UserRepository

    @Autowired
    private UserRepository userRepository;

    // get all users method
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // Create user method
    public User createUser(User user) {
        return userRepository.save(user);
    }

    // Get user by id
    public Optional<User> getUserById(Long id) throws UserNotFoundException{
        Optional<User> user = userRepository.findById(id);
        if(!user.isPresent()){
            throw new UserNotFoundException("User not found in user repository");
        }
        return user;
    }

    // Update user by id

    public User updateUserById(Long id, User user) {
        user.setId(id);
        return userRepository.save(user);
    }

    // Delete user by id

    public void deleteUserById(Long id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            userRepository.deleteById(id);
        }

    }

    // Find by username
    public User getUserByUsername(@PathVariable("username") String username){
        return userRepository.findByUsername(username);
    }

}