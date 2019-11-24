package com.altimetrik.bugtracker.employeemodule.exceptions;

public class BadRequestAlertException  extends Exception{
    private String message;
    public BadRequestAlertException(String message){
        this.message = message;
    }
}
