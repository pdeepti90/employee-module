package com.altimetrik.bugtracker.employeemodule.exceptions;

import java.time.LocalDateTime;

public class ExceptionResponse {
    private String message;
    private String details;
    private LocalDateTime dateTime;

    @Override
    public String toString() {
        return "ExceptionResponse{" +
                "message='" + message + '\'' +
                ", details='" + details + '\'' +
                ", dateTime=" + dateTime +
                '}';
    }

    public ExceptionResponse(String message, String details, LocalDateTime dateTime) {
        this.message = message;
        this.details = details;
        this.dateTime = dateTime;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }
}
