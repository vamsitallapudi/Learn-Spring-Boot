package com.coderefer.learnspringsecurity.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import static com.coderefer.learnspringsecurity.security.ApplicationUserRole.*;

@Configuration
@EnableWebSecurity
public class ApplicationSecurityConfig extends WebSecurityConfigurerAdapter {

    private final PasswordEncoder passwordEncoder;

    @Autowired
    public ApplicationSecurityConfig(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/", "index", "/css/*", "/js/*").permitAll()
                .antMatchers("/api/**").hasRole(STUDENT.name())
                .anyRequest()
                .authenticated()
                .and()
                .httpBasic();
    }

    @Override
    @Bean
    protected UserDetailsService userDetailsService() {
        UserDetails vamsi =
                User.builder()
                        .username("vamsi")
                        .password(passwordEncoder.encode("password"))
                        .roles(STUDENT.toString())
                        .build();

        UserDetails krishna =
                User.builder()
                        .username("krishna")
                        .password(passwordEncoder.encode("password123"))
                        .roles(ADMIN.toString())
                        .build();

        UserDetails tallapudi =
                User.builder()
                        .username("tallapudi")
                        .password(passwordEncoder.encode("password123"))
                        .roles(ADMINTRAINEE.name())
                        .build();
        return new InMemoryUserDetailsManager(vamsi, krishna, tallapudi);
    }
}

