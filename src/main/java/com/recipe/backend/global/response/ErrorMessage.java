package com.recipe.backend.global.response;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ErrorMessage {
    DUPLICATE_USERNAME("이미 존재하는 아이디입니다."),
    DUPLICATE_EMAIL("이미 존재하는 이메일입니다.");

    private final String message;
}
