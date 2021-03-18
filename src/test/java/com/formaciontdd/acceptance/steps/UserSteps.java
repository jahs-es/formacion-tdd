package com.formaciontdd.acceptance.steps;

import static org.assertj.core.api.Assertions.assertThat;

import com.formaciontdd.acceptance.worlds.UserWorld;
import com.formaciontdd.acceptance.worlds.World;
import com.formaciontdd.infrastructure.rest.vo.RegisterUserDto;
import com.formaciontdd.infrastructure.rest.vo.RegisterUserResponseDto;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class UserSteps extends StepRoot {

  private static final String USERS_API_PATH = "/users";

  private final UserWorld userWorld;
  private final World commonWorld;

  public UserSteps(final UserWorld userWorld, final World commonWorld) {
    this.userWorld = userWorld;
    this.commonWorld = commonWorld;
  }

  @And("an username {string}")
  public void anUsername(final String username) {
    userWorld.setUserName(username);
  }

  @When("the user is registered")
  public void theAdminRegisterTheUser() {

    final RegisterUserDto request = RegisterUserDto.builder()
        .name(userWorld.getUserName())
        .build();

    final TestRestTemplate restTemplate = new TestRestTemplate(commonWorld.getSecurityUser(),
        commonWorld.getSecurityPassword());

    final String url = testRestTemplateUri + USERS_API_PATH;

    final ResponseEntity<RegisterUserResponseDto> response = restTemplate
        .postForEntity(url, request, RegisterUserResponseDto.class);

    commonWorld.setResponse(response);
  }

  @Then("the user is successfully registered")
  public void theUserIsSuccessfullyRegistered() {

    final ResponseEntity<RegisterUserResponseDto> response = commonWorld.getResponse();

    assertThat(response.getStatusCode()).isEqualTo(HttpStatus.CREATED);

    assertThat(response.getBody()).isNotNull();

    final RegisterUserResponseDto registerUserResponseDto = response.getBody();

    assertThat(registerUserResponseDto.getId()).isNotNull();
  }

}
