package com.stacksmplify.restservices.sprngbootbuildingblocks.controllers;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;
import javax.validation.constraints.Min;

import com.stacksmplify.restservices.sprngbootbuildingblocks.entities.User;
import com.stacksmplify.restservices.sprngbootbuildingblocks.exceptions.UserExistsException;
import com.stacksmplify.restservices.sprngbootbuildingblocks.exceptions.UserNameNotFoundException;
import com.stacksmplify.restservices.sprngbootbuildingblocks.exceptions.UserNotFoundException;
import com.stacksmplify.restservices.sprngbootbuildingblocks.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.util.UriComponentsBuilder;

/**
 * UserController
 * 
 * @param <UserService>
 */
@RestController
@Validated
@RequestMapping(value = "/users")
public class UserController {

    // Autowire the userService
    @Autowired
    private UserService userService;

    // private final UserService uservice;
    // public UserController(UserService uservice)
    // {
    // this.uservice = uservice;
    // }

    // GetAllUsers

    @GetMapping
    public List<User> GetAllUsers() {
        // return uservice.getAllUsers();
        return userService.getAllUsers();
    }

    // Create user
    // @RequestBody annotation
    // PostMapping annotationi

    @PostMapping
    public ResponseEntity<Void> createUser(@Valid @RequestBody User user, UriComponentsBuilder builder) {
        try {
            userService.createUser(user);
            HttpHeaders headers = new HttpHeaders();
            headers.setLocation(builder.path("/users/{id}").buildAndExpand(user.getId()).toUri());
            return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
		} catch (UserExistsException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
		}
    }

    // Get User by ID
    @GetMapping("/{id}")
    public Optional<User> getUserById(@PathVariable("id") @Min(1) Long id) {
        try {
            return userService.getUserById(id);
        } catch (UserNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }

    }

    // Update user by id
    @PutMapping("/{id}")
    public User updateUserById(@PathVariable("id") Long id, @RequestBody User user) {
        try {
			return userService.updateUserById(id, user);
		} catch (UserNotFoundException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
		}
    }

    // Delete user by id
    @DeleteMapping("/{id}")
    public void deleteUserById(@PathVariable("id") Long id) {
        userService.deleteUserById(id);
    }

    // GetUser by username
    @GetMapping("/byusername/{username}")
    public User getUserByUsername(@PathVariable("username") String username) throws UserNameNotFoundException {
        User user = userService.getUserByUsername(username);
        if(user == null) {
        	throw new UserNameNotFoundException("Username: "+username+" not found in User respository");
        }
        return user;
    }
    
    

}