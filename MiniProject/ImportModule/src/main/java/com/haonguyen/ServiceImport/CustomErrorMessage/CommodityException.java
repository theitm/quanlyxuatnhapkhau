package com.haonguyen.ServiceImport.CustomErrorMessage;

public class CommodityException extends Exception{
    public CommodityException() {
        super();
    }

    public CommodityException(String message) {
        super(message);
    }

    public CommodityException(String message, Throwable cause) {
        super(message, cause);
    }
}
