package com.haonguyen.ServiceImport.CustomErrorMessage;


import org.springframework.http.HttpStatus;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.text.ParseException;
import java.time.LocalDateTime;
import java.time.ZoneOffset;



@RestControllerAdvice
public class GlobalRestExceptionHandler extends ResponseEntityExceptionHandler {


    @ExceptionHandler(ReceiptImportNotFoundException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public ErrorMessage ReceiptException(Exception ex, WebRequest request) {
        ErrorMessage errorMessage
                = new ErrorMessage(999, ex.getMessage(), LocalDateTime.now(ZoneOffset.UTC));
        return errorMessage;
    }

    @ExceptionHandler(ParseException.class)
    @ResponseStatus(value = HttpStatus.FORBIDDEN)
    public ErrorMessage pareException(Exception ex, WebRequest request) {
        return new ErrorMessage(10112, ex.getMessage(), LocalDateTime.now(ZoneOffset.UTC));
    }

    @ExceptionHandler(SaveException.class)
    @ResponseStatus(value = HttpStatus.FORBIDDEN)
    public ErrorMessage saveException(Exception ex, WebRequest request) {
        return new ErrorMessage(500, ex.getMessage(), LocalDateTime.now(ZoneOffset.UTC));
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus()
    public ErrorMessage generalException(Exception ex, WebRequest request) {
        return new ErrorMessage(1000, ex.getMessage(), LocalDateTime.now(ZoneOffset.UTC));
    }

    @ExceptionHandler(CommodityException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorMessage commodityException(Exception ex, WebRequest request) {
        return new ErrorMessage(888, ex.getMessage(), LocalDateTime.now(ZoneOffset.UTC));
    }
}
