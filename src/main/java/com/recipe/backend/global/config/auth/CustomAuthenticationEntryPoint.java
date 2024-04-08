package com.recipe.backend.global.config.auth;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.recipe.backend.global.response.ApiResponse;
import com.recipe.backend.global.response.ErrorMessage;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class CustomAuthenticationEntryPoint implements AuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response,
                         AuthenticationException authException) throws IOException, ServletException {
        ApiResponse apiResponse;
        int httpStatus;

        if (authException instanceof BadCredentialsException) {
            httpStatus = HttpServletResponse.SC_UNAUTHORIZED; // 401
            apiResponse = ApiResponse.fail(httpStatus, ErrorMessage.ACCOUNT_NOT_VALID.getMessage());
        } else {
            httpStatus = HttpServletResponse.SC_UNAUTHORIZED; // 401
            apiResponse = ApiResponse.fail(httpStatus, "인증실패");
        }

        response.setStatus(httpStatus);
        response.setCharacterEncoding("UTF-8");
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        ObjectMapper mapper = new ObjectMapper();
        response.getWriter().write(mapper.writeValueAsString(apiResponse));
    }
}
