package com.formaciontdd.acceptance;

import com.formaciontdd.Application;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = {
    "com.formaciontdd.acceptance.**.steps",
    "com.formaciontdd.acceptance.**.stubs",
    "com.formaciontdd.acceptance.**.worlds",
})
public class AcceptanceTestConfiguration {

  private ConfigurableApplicationContext context;

  @PostConstruct
  public void runScaStatusManagerBatchApplication() {

    context = new SpringApplicationBuilder(Application.class)
        .profiles("test")
        .run("--server.port=0");
  }

  @PreDestroy
  public void stopApplication() {
    if (context != null) {
      context.close();
    }
  }

  @Bean
  public String testRestTemplateUri() {
    final String localPort = context.getEnvironment().getProperty("local.server.port");
    final String baseUrl = "http://localhost:" + localPort;
    final String apiPrefix = context.getEnvironment().getProperty("server.servlet.context-path");

    return apiPrefix != null ? baseUrl + apiPrefix : baseUrl;
  }
}
