package com.formaciontdd.infrastructure.rest;

import com.formaciontdd.application.CreateIssueUseCase;
import com.formaciontdd.domain.model.Issue;
import com.formaciontdd.infrastructure.rest.vo.IssueRequest;
import com.formaciontdd.infrastructure.rest.vo.IssueResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/issues")
public class IssueController {
    private final CreateIssueUseCase createIssueUseCase;

    public IssueController(final CreateIssueUseCase createIssueUseCase) {
        this.createIssueUseCase = createIssueUseCase;
    }

    @PreAuthorize("hasRole('ROLE_USER')")
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public IssueResponse createIssue(@Valid @RequestBody final IssueRequest issueRequest) {
        final Issue createdIssue = createIssueUseCase.create(issueRequest.toIssue());

        return createdIssue.toIssueResponse();
    }
}
