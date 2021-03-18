package com.formaciontdd.infrastructure.providers.converters;

import com.formaciontdd.domain.model.Issue;
import com.formaciontdd.infrastructure.persistence.entities.IssueEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface IssueConverter {

    IssueEntity map(Issue issue);

    Issue map(IssueEntity issueEntity);
}
