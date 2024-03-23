package com.recipe.backend.domain.user.service;

import com.recipe.backend.domain.user.dto.SignupRequest;

public interface UserService {
    // 회원가입
    void signup(SignupRequest signupRequest);

    //
}
