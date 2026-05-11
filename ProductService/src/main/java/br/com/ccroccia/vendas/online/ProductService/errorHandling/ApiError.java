package br.com.ccroccia.vendas.online.ProductService.errorHandling;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.Instant;
import java.util.List;

/*
* In this file I will implement DTO to handling errors that are return to API by Exceptions
* The goal is define an unique JSON format to show errors
* However we can use ProblemDetail class
*
*
*
* */
public record ApiError(
        int status,
        String error,
        String message,
        String path,
        Instant timestamp,
        List<FieldError> errors
) {
  public record FieldError(String field, String rejectedValue, String reason) {}
}