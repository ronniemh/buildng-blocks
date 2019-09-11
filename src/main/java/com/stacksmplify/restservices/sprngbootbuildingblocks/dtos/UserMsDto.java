package com.stacksmplify.restservices.sprngbootbuildingblocks.dtos;

/**
 * UserMsDto
 */
public class UserMsDto {

    private Long userId;
    private String username;
    private String emailaddress; //En el objeto User es email, aqui lo ponemos como lo vamos a exponer
    private String rolename;

    //Constructors

   

    public UserMsDto() {
    }

    

    //Getters and Setters

   

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmailaddress() {
        return emailaddress;
    }

    public void setEmailaddress(String emailaddress) {
        this.emailaddress = emailaddress;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename;
    }
    
}