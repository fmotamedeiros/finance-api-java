package br.com.cpsoftware.finance.controller;

import br.com.cpsoftware.finance.model.ApiError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class ControllerAdvisor {

    @ExceptionHandler(ResponseStatusException.class)
    public ResponseEntity<Object> handleResponseStatusException(ResponseStatusException ex, WebRequest request) {
        ApiError apiError = new ApiError(ex.getStatusCode(), ex.getReason());
        return new ResponseEntity<>(apiError, ex.getStatusCode());
    }
    
}
