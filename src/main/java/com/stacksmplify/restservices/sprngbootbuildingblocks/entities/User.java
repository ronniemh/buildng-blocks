package com.stacksmplify.restservices.sprngbootbuildingblocks.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * User Entity
 */
// @Entity(name = "nombre-real-db")
@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "USER_NAME", length = 50, nullable = false, unique = true)
    private String username;

    @Column(name = "FIRST_NAME", length = 50, nullable = false)
    private String firsname;

    @Column(name = "LAST_NAME", length = 50, nullable = false)
    private String lastname;

    @Column(name = "EMAIL_ADDRESS", length = 50, nullable = false)
    private String email;

    @Column(name = "ROLE", length = 50, nullable = false)
    private String role;

    @Column(name = "SSN", length = 50, nullable = false, unique = true)
    private String ssn;

    // No argument constructor

    public User() {
    }

    // Fields constructor
    public User(Long id, String username, String firsname, String lastname, String email, String role, String ssn) {
        this.id = id;
        this.username = username;
        this.firsname = firsname;
        this.lastname = lastname;
        this.email = email;
        this.role = role;
        this.ssn = ssn;
    }
    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirsname() {
        return firsname;
    }

    public void setFirsname(String firsname) {
        this.firsname = firsname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    // To String - Optional required for  bean logging

    @Override
    public String toString() {
        return "User [email=" + email + ", firsname=" + firsname + ", id=" + id + ", lastname=" + lastname + ", role="
                + role + ", ssn=" + ssn + ", username=" + username + "]";
    }

}