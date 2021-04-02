package com.formaciontdd.infrastructure.providers.converters;

import com.formaciontdd.domain.model.User;
import com.formaciontdd.infrastructure.persistence.entities.UserEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserConverter {

    UserEntity map(User user);

    User map(UserEntity userEntity);
}
