package com.recipe.backend.global.exception;

import com.recipe.backend.global.exception.custom.JwtAuthenticationException;
import com.recipe.backend.global.response.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
@RequiredArgsConstructor
public class ExceptionControllerAdvice {

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ApiResponse> IllegalArgumentEx(IllegalArgumentException e){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ApiResponse.fail(HttpStatus.BAD_REQUEST.value(), e.getMessage()));
    }

    @ExceptionHandler(JwtAuthenticationException.class)
    public ResponseEntity<ApiResponse> JwtAuthEx(JwtAuthenticationException e){
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(ApiResponse.fail(HttpStatus.UNAUTHORIZED.value(), e.getMessage()));
    }
    @ExceptionHandler(UsernameNotFoundException.class)
    public ResponseEntity<ApiResponse> UserNotFoundEx(UsernameNotFoundException e){
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(ApiResponse.fail(HttpStatus.UNAUTHORIZED.value(), e.getMessage()));
    }
}
