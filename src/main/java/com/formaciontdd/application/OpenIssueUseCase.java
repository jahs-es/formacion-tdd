package com.formaciontdd.application;

import com.formaciontdd.domain.services.IssueService;
import org.springframework.stereotype.Component;

@Component
public class OpenIssueUseCase {

    private final IssueService issueService;

    public OpenIssueUseCase(final IssueService issueService) {
        this.issueService = issueService;
    }

    public void open(final Long id) {
        issueService.open(id);
    }
}
