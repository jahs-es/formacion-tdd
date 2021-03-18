package com.formaciontdd.acceptance.steps;

import com.formaciontdd.acceptance.worlds.World;
import com.formaciontdd.infrastructure.rest.vo.IssueRequest;
import com.formaciontdd.infrastructure.rest.vo.IssueResponse;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;

public class IssueSteps extends StepRoot {
    private static final String ISSUES_API_PATH = "/issues";
    private final World commonWorld;

    public IssueSteps(final World commonWorld) {
        this.commonWorld = commonWorld;
    }

    @When("he create a issue")
    public void userCreateAnIssue() {

        final IssueRequest request = IssueRequest.builder()
                .user(commonWorld.getSecurityUser())
                .description("A ticket")
                .createdAt(new Date())
                .isOpen(true)
                .build();

        final TestRestTemplate restTemplate = new TestRestTemplate(commonWorld.getSecurityUser(),
                commonWorld.getSecurityPassword());

        final String url = testRestTemplateUri + ISSUES_API_PATH;

        final ResponseEntity<IssueResponse> response = restTemplate
                .postForEntity(url, request, IssueResponse.class);

        commonWorld.setResponse(response);
    }

    @Then("the issue is successfully created and linked to him")
    public void theIssueIsCreatedAndLinkedToHim() {

        final ResponseEntity<IssueResponse> response = commonWorld.getResponse();

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.CREATED);

        assertThat(response.getBody()).isNotNull();

        final IssueResponse issueResponse = response.getBody();

        assertThat(issueResponse.getId()).isNotNull();
        assertThat(issueResponse.getUser()).isEqualTo(commonWorld.getSecurityUser());
    }

}
