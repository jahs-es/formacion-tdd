package com.formaciontdd.application;

import com.formaciontdd.domain.model.Issue;
import com.formaciontdd.domain.services.IssueService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
public class CreateIssueUseCase {

    private final IssueService issueService;

    public CreateIssueUseCase(final IssueService issueService) {
        this.issueService = issueService;
    }

    public Issue create(final Issue issue) {
        return issueService.create(issue);
    }
}
