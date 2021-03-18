package com.formaciontdd.acceptance.steps;

import com.formaciontdd.acceptance.AcceptanceTestConfiguration;
import com.formaciontdd.acceptance.worlds.World;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;

import static org.assertj.core.api.Assertions.assertThat;

@CucumberContextConfiguration
@ContextConfiguration(classes = AcceptanceTestConfiguration.class)
public class CommonSteps extends StepRoot {

  protected final World commonWorld;

  public CommonSteps(final World commonWorld) {
    this.commonWorld = commonWorld;
  }

  @And("error code is {string}")
  public void errorCode(final String errorCode) {
    assertThat(commonWorld.getErrorResponse().getErrorCode()).isEqualTo(errorCode);
  }

  @And("error message is {string}")
  public void errorMessage(final String message) {
    assertThat(commonWorld.getErrorResponse().getErrorMessage()).isEqualTo(message);
  }

  @Given("an admin")
  public void anAdmin() {
    commonWorld.setSecurityUser(World.ADMIN_USER);
    commonWorld.setSecurityPassword(World.ADMIN_PASSWORD);
  }

  @Given("an user")
  public void anUser() {
    commonWorld.setSecurityUser(World.USER);
    commonWorld.setSecurityPassword(World.USER_PASSWORD);
  }

  @Then("a forbidden error is returned")
  public void oneForbiddenErrorIsReturned() {
    final ResponseEntity<?> response = commonWorld.getResponse();

    assertThat(response.getStatusCode()).isEqualTo(HttpStatus.FORBIDDEN);
  }
}
