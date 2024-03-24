package com.recipe.backend.global.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import org.springframework.http.ResponseEntity;

@Builder
@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class ApiResponse<T> {

    private final int status;
    private final boolean success;
    private final String message;
    private T data;

    public static <T> ResponseEntity<ApiResponse<T>> success(SuccessMessages successMessages) {
        return ResponseEntity.status(successMessages.getHttpStatus())
                .body(ApiResponse.<T>builder()
                        .status(successMessages.getStatusCode())
                        .success(true)
                        .message(successMessages.getMessage()).build());
    }

    public static <T> ResponseEntity<ApiResponse<T>> success(SuccessMessages successStatus, T data) {
        return ResponseEntity.status(successStatus.getHttpStatus())
                .body(ApiResponse.<T>builder()
                        .status(successStatus.getStatusCode())
                        .success(true)
                        .message(successStatus.getMessage())
                        .data(data).build());
    }

    public static ApiResponse fail(int status, String message) {
        return ApiResponse.builder()
                .status(status)
                .success(false)
                .message(message)
                .build();
    }


}