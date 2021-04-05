package com.formaciontdd.infrastructure.providers;

import com.formaciontdd.domain.model.Issue;
import com.formaciontdd.domain.providers.IssueProvider;
import com.formaciontdd.infrastructure.persistence.JpaIssueRepository;
import com.formaciontdd.infrastructure.persistence.entities.IssueEntity;
import com.formaciontdd.infrastructure.providers.converters.IssueConverter;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class DatabaseIssueEntityProvider implements IssueProvider {

    private final JpaIssueRepository jpaIssueRepository;

    private final IssueConverter issueConverter;

    public DatabaseIssueEntityProvider(final JpaIssueRepository jpaIssueRepository,
                                       final IssueConverter issueConverter) {
        this.jpaIssueRepository = jpaIssueRepository;
        this.issueConverter = issueConverter;
    }

    @Override
    public Issue save(final Issue issue) {
        IssueEntity issueEntity = issueConverter.map(issue);

        issueEntity = jpaIssueRepository.save(issueEntity);

        return issueConverter.map(issueEntity);
    }

    @Override
    public Optional<Issue> get(final Long id) {
        Optional<IssueEntity> issueEntity = jpaIssueRepository.findById(id);

        if (issueEntity.isEmpty()) {
            return Optional.empty();
        }

        return Optional.of(issueConverter.map(issueEntity.get()));
    }
}
