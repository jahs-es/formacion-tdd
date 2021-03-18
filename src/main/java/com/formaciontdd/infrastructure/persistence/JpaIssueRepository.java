package com.formaciontdd.infrastructure.persistence;

import com.formaciontdd.infrastructure.persistence.entities.IssueEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaIssueRepository extends CrudRepository<IssueEntity, Long> {

}
