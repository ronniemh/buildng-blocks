package com.stacksmplify.restservices.sprngbootbuildingblocks.controllers;

import java.util.Optional;

import javax.validation.constraints.Min;
import org.springframework.beans.factory.annotation.Autowired;

import com.stacksmplify.restservices.sprngbootbuildingblocks.dtos.UserMmDto;
import com.stacksmplify.restservices.sprngbootbuildingblocks.entities.User;
import com.stacksmplify.restservices.sprngbootbuildingblocks.exceptions.UserNotFoundException;
import com.stacksmplify.restservices.sprngbootbuildingblocks.services.UserService;

import org.modelmapper.ModelMapper;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * UserModelMapperController
 */
@RestController
@RequestMapping("/modelmapper/users")
public class UserModelMapperController {

    @Autowired
    private UserService userService;

    @Autowired
    private ModelMapper mododelMapper;


    // Get User by ID
    @GetMapping("/{id}")
    public UserMmDto getUserById(@PathVariable("id") @Min(1) Long id) throws UserNotFoundException {
        Optional<User> userOp = userService.getUserById(id);
        if(!userOp.isPresent()){
            throw new UserNotFoundException("user not found");
        }

        User user = userOp.get();
        UserMmDto userDto = mododelMapper.map(user, UserMmDto.class);
        return userDto;

    }
    
}