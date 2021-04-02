package com.formaciontdd.domain.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
@JsonDeserialize(builder = User.UserBuilder.class)
public class User {

    private Long id;

    private String name;

    @JsonPOJOBuilder(withPrefix = "")
    public static class UserBuilder {

    }
}
