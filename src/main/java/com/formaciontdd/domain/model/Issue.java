package com.formaciontdd.domain.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.formaciontdd.infrastructure.rest.vo.IssueResponse;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
@JsonDeserialize(builder = Issue.IssueBuilder.class)
public class Issue {

    private Long id;

    private String user;

    private String description;

    private Boolean isOpen;

    private Date createdAt;

    @JsonPOJOBuilder(withPrefix = "")
    public static class IssueBuilder {

    }

    public IssueResponse toIssueResponse() {
        return IssueResponse.builder()
                .id(getId())
                .description(getDescription())
                .user(getUser())
                .createdAt(getCreatedAt())
                .isOpen(getIsOpen())
                .build();
    }
}
