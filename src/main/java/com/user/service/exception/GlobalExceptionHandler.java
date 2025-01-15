package com.user.service.exception;

import com.user.service.payload.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiResponse> handlerResourceNotFoundException(ResourceNotFoundException ex) {
        String message = ex.getMessage();
        ApiResponse.Builder builder = new ApiResponse.Builder();
        builder.message(message);
        builder.status(HttpStatus.NOT_FOUND);
        builder.success(false);
        ApiResponse response = new ApiResponse(builder);
        return new ResponseEntity<ApiResponse>(response, HttpStatus.NOT_FOUND);
    }
}