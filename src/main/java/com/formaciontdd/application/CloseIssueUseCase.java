package com.formaciontdd.application;

import com.formaciontdd.domain.services.IssueService;
import org.springframework.stereotype.Component;

@Component
public class CloseIssueUseCase {

    private final IssueService issueService;

    public CloseIssueUseCase(final IssueService issueService) {
        this.issueService = issueService;
    }

    public void close(final Long id) {
        issueService.close(id);
    }
}
