package com.haonguyen.ServiceImport.CustomErrorMessage;

public class ReceiptImportNotFoundException extends Exception{
    public ReceiptImportNotFoundException() {
        super();
    }

    public ReceiptImportNotFoundException(String message) {
        super(message);
    }

    public ReceiptImportNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
