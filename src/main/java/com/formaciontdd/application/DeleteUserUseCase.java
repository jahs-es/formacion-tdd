package com.formaciontdd.application;

import com.formaciontdd.domain.services.UserService;
import org.springframework.stereotype.Component;

@Component
public class DeleteUserUseCase {

    private final UserService userService;

    public DeleteUserUseCase(final UserService userService) {
        this.userService = userService;
    }

    public void delete(final Long userId) {
        userService.delete(userId);
    }
}
