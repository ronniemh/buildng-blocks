package com.stacksmplify.restservices.sprngbootbuildingblocks.exceptions;

import java.util.Date;

/**
 * CustomErrorDetails
 * Simple custom error details bean
 */
public class CustomErrorDetails {

    private Date timestamp;
    private String message;
    private String errorDetails;
    
    //Fields constructor
    public CustomErrorDetails(Date timestamp, String message, String errorDetails) {
        this.timestamp = timestamp;
        this.message = message;
        this.errorDetails = errorDetails;
    }

    //Getters and Setters
    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getErrorDetails() {
        return errorDetails;
    }

    public void setErrorDetails(String errorDetails) {
        this.errorDetails = errorDetails;
    }    
}