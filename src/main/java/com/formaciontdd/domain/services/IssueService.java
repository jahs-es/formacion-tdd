package com.formaciontdd.domain.services;

import com.formaciontdd.domain.model.Issue;
import com.formaciontdd.domain.providers.IssueProvider;
import org.springframework.stereotype.Service;

@Service
public class IssueService {

    private final IssueProvider issueProvider;

    public IssueService(final IssueProvider issueProvider) {
        this.issueProvider = issueProvider;
    }

    public Issue create(final Issue issue) {
        return issueProvider.save(issue);
    }
}
