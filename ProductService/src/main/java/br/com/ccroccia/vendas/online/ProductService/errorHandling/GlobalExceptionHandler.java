package br.com.ccroccia.vendas.online.ProductService.errorHandling;


import br.com.ccroccia.vendas.online.ProductService.Exceptions.EntityCreationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/*In this file I will catch the exception and translate to API error*/
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(EntityCreationException.class)
    public ResponseEntity<ApiError> handleEntityCreationException(EntityCreationException ex){
        ApiError ap = new ApiError(422,
                ex.getMessage(),
                ex.getMessage(),
                "/product",
                LocalDateTime.now(),
                new ArrayList<ApiError.FieldError>());

        return ResponseEntity.ok(ap);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ApiError> handleIllegalArgumentException(EntityCreationException ex){
        ApiError ap = new ApiError(422,
                ex.getMessage(),
                ex.getMessage(),
                "/{id}",
                LocalDateTime.now(),
                new ArrayList<ApiError.FieldError>());

        return ResponseEntity.ok(ap);
    }


}
