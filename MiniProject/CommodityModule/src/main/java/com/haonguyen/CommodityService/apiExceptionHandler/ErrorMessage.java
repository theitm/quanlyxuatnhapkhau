package com.haonguyen.CommodityService.apiExceptionHandler;


import java.time.LocalDateTime;

public class ErrorMessage {
    private int errorCode;
    private String message;
    private LocalDateTime atTime;

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalDateTime getAtTime() {
        return atTime;
    }

    public void setAtTime(LocalDateTime atTime) {
        this.atTime = atTime;
    }

    public ErrorMessage(int errorCode, String message, LocalDateTime atTime) {
        this.errorCode = errorCode;
        this.message = message;
        this.atTime = atTime;
    }
}
