package com.stacksmplify.restservices.sprngbootbuildingblocks.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.stacksmplify.restservices.sprngbootbuildingblocks.entities.Order;
import com.stacksmplify.restservices.sprngbootbuildingblocks.entities.User;
import com.stacksmplify.restservices.sprngbootbuildingblocks.exceptions.UserNotFoundException;
import com.stacksmplify.restservices.sprngbootbuildingblocks.repositories.IOrderRepository;
import com.stacksmplify.restservices.sprngbootbuildingblocks.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resources;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * OrderHateoasController
 */
@RestController
@RequestMapping(value="/hateoas/users")
public class OrderHateoasController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private IOrderRepository OrderRepository;

    //get all orders for a user;

    @GetMapping("/{userid}/orders")
    public Resources<Order> getAllOrders(@PathVariable Long  userid) throws UserNotFoundException {
        Optional<User> user = userRepository.findById(userid);
        if(!user.isPresent()){
            throw new UserNotFoundException("User not found");
        }
        List<Order> allOrders = new ArrayList<>(user.get().getOrders());
        Resources<Order> finalResources = new Resources<Order>(allOrders);
        return finalResources;
    }
}