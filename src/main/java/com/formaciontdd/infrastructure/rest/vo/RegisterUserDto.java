package com.formaciontdd.infrastructure.rest.vo;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

import javax.validation.constraints.NotBlank;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
@JsonDeserialize(builder = RegisterUserDto.RegisterUserDtoBuilder.class)
public class RegisterUserDto {

    @NotBlank
    String name;

    @JsonPOJOBuilder(withPrefix = "")
    public static class RegisterUserDtoBuilder {

    }
}
