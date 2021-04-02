package com.formaciontdd.acceptance;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@CucumberOptions(
    features = {"classpath:features/**"},
    plugin = "pretty",
    glue = {"com.formaciontdd.acceptance.steps"},
    tags = "not @ignore"
)
@RunWith(Cucumber.class)
public class AppAcceptanceCriteriaIT {

}
