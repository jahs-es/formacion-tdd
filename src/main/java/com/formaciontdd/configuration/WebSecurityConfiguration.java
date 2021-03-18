package com.formaciontdd.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

    private static final String USER = "course";
    private static final String PASSWORD = "course";
    private static final String ROLE_USER = "ROLE_USER";
    private static final String ADMIN = "admin";
    private static final String PASSWORD_ADMIN = "admin";
    private static final String ROLE_ADMIN = "ROLE_ADMIN";


    @Autowired
    public void configureGlobal(final AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().withUser(USER).password(passwordEncoder().encode(PASSWORD))
                .authorities(ROLE_USER);
        auth.inMemoryAuthentication().withUser(ADMIN).password(passwordEncoder().encode(PASSWORD_ADMIN))
                .authorities(ROLE_USER, ROLE_ADMIN);
    }

    @Override
    protected void configure(final HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests().anyRequest().authenticated()
                .and().authorizeRequests()
                .and().httpBasic();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
