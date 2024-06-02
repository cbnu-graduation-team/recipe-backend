package com.recipe.backend.domain.user.service;

import com.recipe.backend.domain.inventory.domain.Inventory;
import com.recipe.backend.domain.inventory.repository.InventoryRepository;
import com.recipe.backend.domain.user.domain.User;
import com.recipe.backend.domain.user.dto.SignupRequest;
import com.recipe.backend.domain.user.repository.UserRepository;
import com.recipe.backend.global.response.ErrorMessage;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final InventoryRepository inventoryRepository;
    @Override
    public void signup(SignupRequest signupRequest) {
        checkValid(signupRequest);
        User user = User.builder().
                username(signupRequest.getUsername()).
                password(passwordEncoder.encode(signupRequest.getPassword())).
                email(signupRequest.getEmail()).
                build();
        userRepository.save(user);

        Inventory inventory = new Inventory(user);
        inventoryRepository.save(inventory);
    }

    private void checkValid(SignupRequest signupRequest) {
        if(userRepository.existsByEmail(signupRequest.getEmail())){
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE_EMAIL.getMessage());
        }
        if(userRepository.existsByUsername(signupRequest.getUsername())){
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE_USERNAME.getMessage());
        }
    }
}
