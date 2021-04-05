package com.formaciontdd.domain.services;

import com.formaciontdd.domain.model.Issue;
import com.formaciontdd.domain.providers.IssueProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class IssueService {

    private final IssueProvider issueProvider;

    public IssueService(final IssueProvider issueProvider) {
        this.issueProvider = issueProvider;
    }

    public Issue create(final Issue issue) {
        issue.setUser(getUserName());
        issue.setCreatedAt(new Date());
        issue.setIsOpen(true);

        return issueProvider.save(issue);
    }

    private String getUserName() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication.getName();
    }
}
