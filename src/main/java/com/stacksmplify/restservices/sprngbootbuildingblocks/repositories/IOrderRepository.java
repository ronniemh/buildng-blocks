package com.stacksmplify.restservices.sprngbootbuildingblocks.repositories;

import com.stacksmplify.restservices.sprngbootbuildingblocks.entities.Order;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * IOrderRepository
 */
@Repository
public interface IOrderRepository extends JpaRepository<Order, Long> {

    
    
}