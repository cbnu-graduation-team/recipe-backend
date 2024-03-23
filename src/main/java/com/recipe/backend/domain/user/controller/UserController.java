package com.recipe.backend.domain.user.controller;

import com.recipe.backend.domain.user.domain.User;
import com.recipe.backend.domain.user.dto.SignupRequest;

import com.recipe.backend.domain.user.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<String> join(@RequestBody @Valid SignupRequest dto){
        userService.signup(dto);
        return ResponseEntity.ok(dto.getUsername());
    }

}
