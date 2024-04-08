package com.recipe.backend.domain.user.controller;

import com.recipe.backend.domain.user.domain.User;
import com.recipe.backend.domain.user.dto.LoginRequest;
import com.recipe.backend.domain.user.dto.LoginResponse;
import com.recipe.backend.domain.user.dto.SignupRequest;

import com.recipe.backend.domain.user.service.UserService;
import com.recipe.backend.global.config.auth.JwtUtil;
import com.recipe.backend.global.response.ApiResponse;
import com.recipe.backend.global.response.ErrorMessage;
import com.recipe.backend.global.response.SuccessMessages;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    private final AuthenticationManager am;
    private final JwtUtil jwtUtil;


    @PostMapping("/signup")
    public ResponseEntity<ApiResponse<String>> join(@RequestBody @Valid SignupRequest dto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            // 여기서 오류 메시지를 처리합니다. 예를 들어:
            String errorMessage = bindingResult.getAllErrors().stream()
                    .map(DefaultMessageSourceResolvable::getDefaultMessage)
                    .collect(Collectors.joining(", "));
            throw new IllegalArgumentException(errorMessage);
        }
        userService.signup(dto);
        return ApiResponse.success(SuccessMessages.SIGNUP_SUCCESS, dto.getUsername());
    }

    @PostMapping("/login")
    public ResponseEntity<ApiResponse<LoginResponse>> authenticateUser(@RequestBody LoginRequest loginRequest) {
            Authentication authentication = am.authenticate(
                    new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

            SecurityContextHolder.getContext().setAuthentication(authentication);
            String jwt = jwtUtil.generateJwtToken(authentication.getName());

            LoginResponse loginResponse = new LoginResponse(loginRequest.getUsername(), jwt);
            return ApiResponse.success(SuccessMessages.LOGIN_SUCCESS, loginResponse);
    }
}