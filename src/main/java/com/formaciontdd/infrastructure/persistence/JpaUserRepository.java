package com.formaciontdd.infrastructure.persistence;

import com.formaciontdd.infrastructure.persistence.entities.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaUserRepository extends CrudRepository<UserEntity, Long> {

}
