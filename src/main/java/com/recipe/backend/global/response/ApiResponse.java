package com.recipe.backend.global.response;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Getter
@AllArgsConstructor()
@NoArgsConstructor
public class ApiResponse<T> {
    private String status;
    private String message;
    private T data;
}
