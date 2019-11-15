package com.stacksmplify.restservices.sprngbootbuildingblocks.controllers;

import java.util.Optional;

import javax.validation.constraints.Min;
import org.springframework.beans.factory.annotation.Autowired;

import com.stacksmplify.restservices.sprngbootbuildingblocks.dtos.UserDtoV1;
import com.stacksmplify.restservices.sprngbootbuildingblocks.dtos.UserDtoV2;
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
@RequestMapping("/versioning/params/users")
public class UserRequestParameterVersioningController {

    @Autowired
    private UserService userService;

    @Autowired
    private ModelMapper mododelMapper;

    // Request parameter based versioning - V1
    @GetMapping(value = "/{id}", params = "version=1")
    public UserDtoV1 getUserById(@PathVariable("id") @Min(1) Long id) throws UserNotFoundException {
        Optional<User> userOp = userService.getUserById(id);
        if (!userOp.isPresent()) {
            throw new UserNotFoundException("user not found");
        }

        User user = userOp.get();
        UserDtoV1 userDtoV1 = mododelMapper.map(user, UserDtoV1.class);
        return userDtoV1;

    }

    // Request parameter based versioning - V2
    @GetMapping(value = "/{id}", params = "version=2")
    public UserDtoV2 getUserById2(@PathVariable("id") @Min(1) Long id) throws UserNotFoundException {
        Optional<User> userOp = userService.getUserById(id);
        if (!userOp.isPresent()) {
            throw new UserNotFoundException("user not found");
        }

        User user = userOp.get();
        UserDtoV2 userDtoV2 = mododelMapper.map(user, UserDtoV2.class);
        return userDtoV2;

    }

}