package com.formaciontdd.infrastructure.rest;

import com.formaciontdd.application.CloseIssueUseCase;
import com.formaciontdd.application.CreateIssueUseCase;
import com.formaciontdd.application.OpenIssueUseCase;
import com.formaciontdd.domain.model.Issue;
import com.formaciontdd.infrastructure.rest.vo.IssueRequest;
import com.formaciontdd.infrastructure.rest.vo.IssueResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class IssueController {
    private final CreateIssueUseCase createIssueUseCase;
    private final CloseIssueUseCase closeIssueUseCase;
    private final OpenIssueUseCase openIssueUseCase;

    public IssueController(final CreateIssueUseCase createIssueUseCase,
                           final CloseIssueUseCase closeIssueUseCase,
                           final OpenIssueUseCase openIssueUseCase) {
        this.createIssueUseCase = createIssueUseCase;
        this.closeIssueUseCase = closeIssueUseCase;
        this.openIssueUseCase = openIssueUseCase;
    }

    @PreAuthorize("hasRole('ROLE_USER')")
    @PostMapping(value = "/issues", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public IssueResponse createIssue(@Valid @RequestBody final IssueRequest issueRequest) {
        final Issue createdIssue = createIssueUseCase.create(issueRequest.toIssue());

        return createdIssue.toIssueResponse();
    }

    @PreAuthorize("hasRole('ROLE_USER')")
    @PutMapping(value = "/issues/{id}/close", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void closeIssue(@PathVariable("id") Long id) {
        closeIssueUseCase.close(id);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PutMapping(value = "/issues/{id}/open", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void openIssue(@PathVariable("id") Long id) {
        openIssueUseCase.open(id);
    }
}
