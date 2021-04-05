package com.formaciontdd.domain.providers;

import com.formaciontdd.domain.model.Issue;

import java.util.Optional;

public interface IssueProvider {

    Issue save(Issue issue);

    Optional<Issue> get(Long id);
}
