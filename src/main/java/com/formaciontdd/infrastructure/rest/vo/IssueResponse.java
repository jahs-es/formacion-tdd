package com.formaciontdd.infrastructure.rest.vo;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import lombok.Builder;
import lombok.Value;

import java.util.Date;

@Value
@Builder
@JsonDeserialize(builder = IssueResponse.IssueResponseBuilder.class)
public class IssueResponse {

    Long id;

    String user;

    String description;

    Boolean isOpen;

    Date createdAt;

    @JsonPOJOBuilder(withPrefix = "")
    public static class IssueResponseBuilder {

    }
}
