package com.haonguyen.ServiceImport.CustomErrorMessage;

public class SaveException extends Exception {
    public SaveException() {
        super();
    }

    public SaveException(String message) {
        super(message);
    }

    public SaveException(String message, Throwable cause) {
        super(message, cause);
    }
}
