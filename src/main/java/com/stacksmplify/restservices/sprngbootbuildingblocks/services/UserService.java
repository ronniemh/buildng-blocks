package com.stacksmplify.restservices.sprngbootbuildingblocks.services;

import java.util.List;
import java.util.Optional;

import com.stacksmplify.restservices.sprngbootbuildingblocks.entities.User;
import com.stacksmplify.restservices.sprngbootbuildingblocks.exceptions.UserExistsException;
import com.stacksmplify.restservices.sprngbootbuildingblocks.exceptions.UserNotFoundException;
import com.stacksmplify.restservices.sprngbootbuildingblocks.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.server.ResponseStatusException;

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
    public User createUser(User user) throws UserExistsException {
        User userExists = userRepository.findByUsername(user.getUsername());
        if (userExists != null) {
            throw new UserExistsException("User already exists in repository");
        }
        return userRepository.save(user);
    }

    // Get user by id
    public Optional<User> getUserById(Long id) throws UserNotFoundException {
        Optional<User> user = userRepository.findById(id);
        if (!user.isPresent()) {
            throw new UserNotFoundException("User not found in user repository");
        }
        return user;
    }

    // Update user by id

    public User updateUserById(Long id, User user) throws UserNotFoundException {
        Optional<User> optionalUser = userRepository.findById(id);
        if (!optionalUser.isPresent()) {
            throw new UserNotFoundException("User not found in user repository, provide the correct user");
        }
        user.setId(id);
        return userRepository.save(user);
    }

    // Delete user by id

    public void deleteUserById(Long id) {
        Optional<User> user = userRepository.findById(id);
        if (!user.isPresent()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "User not found in user repository for deleting");
        }
        userRepository.deleteById(id);

    }

    // Find by username
    public User getUserByUsername(@PathVariable("username") String username) {
        return userRepository.findByUsername(username);
    }

}