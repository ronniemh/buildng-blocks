package com.stacksmplify.restservices.sprngbootbuildingblocks.entities;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import org.springframework.hateoas.ResourceSupport;

/**
 * User Entity
 */
// @Entity(name = "nombre-real-db")
@Entity
@Table(name = "user")
@JsonIgnoreProperties({"firstname", "lastname"})
public class User extends ResourceSupport {

    @Id
    @GeneratedValue
    private Long userId;

    @NotEmpty(message = "Username is mandatory field. Plese provide username")
    @Column(name = "USER_NAME", length = 50, nullable = false, unique = true)
    private String username;

    @Size(min = 2, message = "FirstName should have atleast 2 characters")
    @Column(name = "FIRST_NAME", length = 50, nullable = false)
    private String firstname;

    @Column(name = "LAST_NAME", length = 50, nullable = false)
    private String lastname;

    @Column(name = "EMAIL_ADDRESS", length = 50, nullable = false)
    private String email;

    @Column(name = "ROLE", length = 50, nullable = false)
    private String role;

    @Column(name = "SSN", length = 50, nullable = false, unique = true)
    @JsonIgnore
    private String ssn;

    /**
     * La propiedad mappedBy es lo que usamos para decirle a Hibernate qué variable
     * estamos usando para representar la clase principal en nuestra clase
     * secundaria.
     */
    @OneToMany(mappedBy = "user")
    private Set<Order> orders;

    // No argument constructor

    public User() {
    }

    // Fields constructor

    public User(Long userId, @NotEmpty(message = "Username is mandatory field. Plese provide username") String username,
            @Size(min = 2, message = "FirstName should have atleast 2 characters") String firstname, String lastname,
            String email, String role, String ssn, Set<Order> orders) {
        this.userId = userId;
        this.username = username;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.role = role;
        this.ssn = ssn;
        this.orders = orders;
    }

    // Getters and Setters

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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


    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public Set<Order> getOrders() {
        return orders;
    }

    public void setOrders(Set<Order> orders) {
        this.orders = orders;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
    // To String - Optional required for bean logging

    @Override
    public String toString() {
        return "User [email=" + email + ", firstname=" + firstname + ", lastname=" + lastname + ", role=" + role
                + ", ssn=" + ssn + ", userId=" + userId + ", username=" + username + "]";
    }
}