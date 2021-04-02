package com.formaciontdd.infrastructure.providers;

import com.formaciontdd.domain.model.User;
import com.formaciontdd.domain.providers.UserProvider;
import com.formaciontdd.infrastructure.persistence.JpaUserRepository;
import com.formaciontdd.infrastructure.persistence.entities.UserEntity;
import com.formaciontdd.infrastructure.providers.converters.UserConverter;
import org.springframework.stereotype.Component;

@Component
public class DatabaseUserEntityProvider implements UserProvider {

    private final JpaUserRepository jpaUserRepository;

    private final UserConverter userConverter;

    public DatabaseUserEntityProvider(final JpaUserRepository jpaUserRepository, final UserConverter userConverter) {
        this.jpaUserRepository = jpaUserRepository;
        this.userConverter = userConverter;
    }

    @Override
    public User save(final User user) {

        UserEntity userEntity = userConverter.map(user);

        userEntity = jpaUserRepository.save(userEntity);

        return userConverter.map(userEntity);
    }

    @Override
    public void delete(final Long userId) {
        jpaUserRepository.deleteById(userId);
    }
}
