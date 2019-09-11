package com.stacksmplify.restservices.sprngbootbuildingblocks.dtos;

import java.util.List;

import com.stacksmplify.restservices.sprngbootbuildingblocks.entities.Order;

/**
 * UserMmDto
 */
public class UserMmDto {

    private Long userId;
    private String userName;
    private String firstname;
    private List<Order> orders;

    //Getters and Setters
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }
    
    
}