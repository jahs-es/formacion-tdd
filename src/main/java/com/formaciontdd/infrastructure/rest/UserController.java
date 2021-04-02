package com.formaciontdd.infrastructure.rest;

import com.formaciontdd.application.DeleteUserUseCase;
import com.formaciontdd.application.RegisterUserUseCase;
import com.formaciontdd.infrastructure.rest.vo.RegisterUserDto;
import com.formaciontdd.infrastructure.rest.vo.RegisterUserResponseDto;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    private final RegisterUserUseCase registerUserUseCase;

    private final DeleteUserUseCase deleteUserUseCase;

    public UserController(final RegisterUserUseCase registerUserUseCase,
                          final DeleteUserUseCase deleteUserUseCase) {
        this.registerUserUseCase = registerUserUseCase;
        this.deleteUserUseCase = deleteUserUseCase;
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public RegisterUserResponseDto registerUser(@Valid @RequestBody final RegisterUserDto registerUserDto) {

        final Long id = registerUserUseCase.register(registerUserDto.getName());

        return RegisterUserResponseDto.builder()
                .id(id)
                .build();
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @DeleteMapping(path = "/{userId}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUser(@PathVariable final Long userId) {
        deleteUserUseCase.delete(userId);
    }

}
