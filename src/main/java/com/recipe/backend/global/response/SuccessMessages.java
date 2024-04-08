package com.recipe.backend.global.response;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum SuccessMessages {
    SIGNUP_SUCCESS(HttpStatus.CREATED,"회원가입 성공"),
    LOGIN_SUCCESS(HttpStatus.OK, "로그인 성공");

    private final HttpStatus httpStatus;
    private final String message;

    public int getStatusCode(){
        return this.httpStatus.value();
    }
}
