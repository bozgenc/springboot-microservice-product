package com.sha.springbootmicroservise1product.security;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class SecurityConfig extends WebSecurityConfigurerAdapter {

   @Value("${service.security.secure-key-username}")
    private String SECURE_KEY_USERNAME;

    @Value("${service.security.secure-key-password}")
    private String SECURE_KEY_PASSWORD;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        PasswordEncoder encoder = new BCryptPasswordEncoder();
        System.out.println(SECURE_KEY_PASSWORD);
        System.out.println(SECURE_KEY_USERNAME);
        auth.inMemoryAuthentication().
                passwordEncoder(encoder)
                .withUser("admin")
                .password(encoder.encode("password"))
                .roles("USER");
    }

    protected void configure(HttpSecurity http) throws Exception {
        super.configure(http);
        http.csrf().disable();
    }

    /*public void configure(WebSecurity web) {
        web.ignoring().antMatchers(
                "/**"
        );
    }*/
}


