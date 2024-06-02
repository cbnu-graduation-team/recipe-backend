package com.recipe.backend.global.response;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ErrorMessage {
    DUPLICATE_USERNAME("이미 존재하는 아이디입니다."),
    DUPLICATE_EMAIL("이미 존재하는 이메일입니다."),
    ACCOUNT_NOT_VALID("아이디 혹은 비밀번호가 일치하지 않습니다"),
    USER_NOT_FOUND("존재하지 않는 유저입니다"),
    TOKEN_EXPIRED("토큰이 만료되었습니다. 다시 로그인해주세요"),
    ADD_INGRE_FAIL("재료 추가에 실패하였습니다."),
    DUPLICATE_INGRE("이미 있는 재료입니다."),
    INVENTORY_NOT_FOUND("냉장고를 찾지 못하였습니다."),
    INGRE_NOT_FOUND("재료가 없습니다.");
    private final String message;
}
