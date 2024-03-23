package com.recipe.backend.domain.user.service;

import com.recipe.backend.domain.user.domain.User;
import com.recipe.backend.domain.user.dto.SignupRequest;
import com.recipe.backend.domain.user.repository.UserRepository;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    public void signup(SignupRequest signupRequest) {
        User user = User.builder().
                username(signupRequest.getUsername()).
                password(signupRequest.getPassword()).
                email(signupRequest.getEmail()).
                build();
        userRepository.save(user);
    }
}
