package com.formaciontdd.domain.services;

import com.formaciontdd.domain.model.Issue;
import com.formaciontdd.domain.providers.IssueProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

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

    public void close(Long id) {
        Optional<Issue> issue = issueProvider.get(id);

        if (issue.isPresent()) {
            issue.get().setIsOpen(false);
            issueProvider.save(issue.get());
        }
    }

    public void open(Long id) {
        Optional<Issue> issue = issueProvider.get(id);

        if (issue.isPresent()) {
            assertIsClosed(issue.get());

            issue.get().setIsOpen(true);
            issueProvider.save(issue.get());
        }
    }

    private void assertIsClosed(Issue issue) {
        if (issue.getIsOpen()) {
            throw new RuntimeException("issue.is.opened.already");
        }
    }
}
