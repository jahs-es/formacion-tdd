package com.formaciontdd.infrastructure.rest.vo;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
@JsonDeserialize(builder = RegisterUserResponseDto.RegisterUserResponseDtoBuilder.class)
public class RegisterUserResponseDto {

    Long id;

    @JsonPOJOBuilder(withPrefix = "")
    public static class RegisterUserResponseDtoBuilder {

    }
}
