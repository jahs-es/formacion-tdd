package com.formaciontdd.infrastructure.rest.vo;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.formaciontdd.domain.model.Issue;
import lombok.Builder;
import lombok.Value;

import javax.validation.constraints.NotBlank;

@Value
@Builder
@JsonDeserialize(builder = IssueRequest.IssueRequestBuilder.class)
public class IssueRequest {

    @NotBlank
    String description;

    @JsonPOJOBuilder(withPrefix = "")
    public static class IssueRequestBuilder {

    }

    public Issue toIssue() {
        return Issue.builder()
                .description(getDescription())
                .build();
    }
}
