package com.formaciontdd.application;

import com.formaciontdd.domain.model.User;
import com.formaciontdd.domain.services.UserService;
import org.springframework.stereotype.Component;

@Component
public class RegisterUserUseCase {

    private final UserService userService;

    public RegisterUserUseCase(final UserService userService) {
        this.userService = userService;
    }

    public Long register(final String name) {

        final User user = User.builder()
                .name(name)
                .build();

        return userService.register(user).getId();
    }
}
