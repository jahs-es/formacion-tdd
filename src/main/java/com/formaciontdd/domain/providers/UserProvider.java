package com.formaciontdd.domain.providers;

import com.formaciontdd.domain.model.User;

public interface UserProvider {

    User save(User user);

    void delete(Long userId);
}
