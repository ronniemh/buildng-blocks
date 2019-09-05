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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * OrderController
 */
@RestController
@RequestMapping(value = "/users")
public class OrderController {

    @Autowired
    private UserRepository UserRepository;

    @Autowired
    private IOrderRepository orderRepository;

    //get all orders for a user;

    @GetMapping("/{userid}/orders")
    public List<Order> getAllOrders(@PathVariable Long  userid) throws UserNotFoundException {
        Optional<User> user = UserRepository.findById(userid);
        if(!user.isPresent()){
            throw new UserNotFoundException("User not found");
        }
        return new ArrayList<>(user.get().getOrders());
    }

    @GetMapping("/{userid}/orders/{orderid}")
    public Order getOrderByOrderId(@PathVariable Long  userid, @PathVariable Long orderid) throws Exception {
        Optional<User> user = UserRepository.findById(userid);
        if(!user.isPresent()){
            throw new UserNotFoundException("User not found");
        }
        Optional<Order> orderOp  = orderRepository.findById(orderid);
        if(!orderOp.isPresent()){
            throw new Exception("No se encuentra la orden con el id ingresado");
        }
        if(userid.compareTo(orderOp.get().getUser().getId()) != 0){
            throw new Exception("La orden no pertenece al usuario ingresado");
        }
        return orderOp.get();
    }

    @PostMapping("{userid}/orders")
    public Order createOrder(@PathVariable Long userid, @RequestBody Order order) throws UserNotFoundException
    {
        Optional<User> user = UserRepository.findById(userid);
        if(!user.isPresent()){
            throw new UserNotFoundException("User not found");
        }

        User userf = user.get();
        order.setUser(userf);
        return orderRepository.save(order);
    }
    
}