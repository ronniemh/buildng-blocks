package com.stacksmplify.restservices.sprngbootbuildingblocks.repositories;

import com.stacksmplify.restservices.sprngbootbuildingblocks.entities.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * UserRepository
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long>{
        
}