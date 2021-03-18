package com.formaciontdd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;

@SpringBootApplication
@ComponentScan(basePackages = {"com.formaciontdd"},
        excludeFilters = @ComponentScan.Filter(type = FilterType.REGEX, pattern = {
                "com\\.formaciontdd\\.acceptance\\..*"}))
public class Application {

    public static void main(final String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
