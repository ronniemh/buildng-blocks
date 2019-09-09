package com.stacksmplify.restservices.sprngbootbuildingblocks.controllers;

import java.util.List;
import java.util.Optional;

import javax.validation.constraints.Min;

import com.stacksmplify.restservices.sprngbootbuildingblocks.entities.Order;
import com.stacksmplify.restservices.sprngbootbuildingblocks.entities.User;
import com.stacksmplify.restservices.sprngbootbuildingblocks.exceptions.UserNotFoundException;
import com.stacksmplify.restservices.sprngbootbuildingblocks.repositories.UserRepository;
import com.stacksmplify.restservices.sprngbootbuildingblocks.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

/**
 * UserHateoasController
 */
@RestController
@RequestMapping(value = "/hateoas/users")
@Validated
public class UserHateoasController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

   

    // Get User by ID
    @GetMapping("/{id}")
    public Resource<User> getUserById(@PathVariable("id") @Min(1) Long id) {
        try {
            Optional<User> uOptional =  userService.getUserById(id);
            User user  =  uOptional.get();
            Long userId = user.getUserId();
            Link selfLink = ControllerLinkBuilder.linkTo(this.getClass()).slash(userId).withSelfRel();
            user.add(selfLink);
            Resource<User> finalResource = new Resource<User>(user);
            return finalResource;

        } catch (UserNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }

    }

    @GetMapping
    public Resources<User> GetAllUsers() throws UserNotFoundException {
        List<User> allusers = userService.getAllUsers();
        for (User user : allusers) {
            //Self Link
            Long userId = user.getUserId();
            Link selflink = ControllerLinkBuilder.linkTo(this.getClass()).slash(userId).withSelfRel();
            user.add(selflink);

            //Relationship link with getAllOrders
            Resources<Order> orders = ControllerLinkBuilder.methodOn(OrderHateoasController.class)
            .getAllOrders(userId);

            Link ordersLink = ControllerLinkBuilder.linkTo(orders).withRel("all-orders");
            user.add(ordersLink);
             
        }

        //Self link for getAllUsers
        Link selflinkgetAllUsers =  ControllerLinkBuilder.linkTo(this.getClass()).withSelfRel();

        Resources<User> finalResources =  new Resources<User>(allusers, selflinkgetAllUsers);
        return finalResources;
    }


    
}