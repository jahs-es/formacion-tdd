package com.formaciontdd.domain.services;

import com.formaciontdd.domain.model.User;
import com.formaciontdd.domain.providers.UserProvider;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserProvider userProvider;

    public UserService(final UserProvider userProvider) {
        this.userProvider = userProvider;
    }

    public User register(final User user) {
        return userProvider.save(user);
    }

    public void delete(final Long userId) {
        userProvider.delete(userId);
    }
}
