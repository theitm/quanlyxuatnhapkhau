package com.haonguyen.CommodityService.apiExceptionHandler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

@RestControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {


    @ExceptionHandler(Exception.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorMessage handleAllException(Exception ex, WebRequest request) {
        return new ErrorMessage(10000, "Id khong ton tai", LocalDateTime.now(ZoneOffset.UTC));
    }

    @ExceptionHandler(SaveException.class)
    @ResponseStatus(value = HttpStatus.FORBIDDEN)
    public ErrorMessage saveException(Exception ex, WebRequest request) {
        return new ErrorMessage(500, ex.getMessage(), LocalDateTime.now(ZoneOffset.UTC));
    }

}