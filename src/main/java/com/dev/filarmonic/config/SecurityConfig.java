package com.dev.filarmonic.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    private final UserDetailsService userDetailsService;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public SecurityConfig(UserDetailsService userDetailsService, PasswordEncoder passwordEncoder) {
        this.userDetailsService = userDetailsService;
        this.passwordEncoder = passwordEncoder;
    }

    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService)
                .passwordEncoder(passwordEncoder);
    }

    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
            .antMatchers(HttpMethod.POST, "/register").permitAll()
            .antMatchers(HttpMethod.GET, "/stages").hasAnyRole("ADMIN","USER")
            .antMatchers(HttpMethod.POST, "/stages").hasRole("ADMIN")
            .antMatchers(HttpMethod.GET, "/concerts").hasAnyRole("ADMIN","USER")
            .antMatchers(HttpMethod.POST, "/concerts").hasRole("ADMIN")
            .antMatchers(HttpMethod.GET, "/concert-sessions/available").hasAnyRole("ADMIN","USER")
            .antMatchers(HttpMethod.GET, "/concert-sessions/{id}").hasAnyRole("ADMIN","USER")
            .antMatchers(HttpMethod.POST, "/concert-sessions").hasRole("ADMIN")
            .antMatchers(HttpMethod.PUT, "/concert-sessions/{id}").hasRole("ADMIN")
            .antMatchers(HttpMethod.DELETE, "/concert-sessions/{id}").hasRole("ADMIN")
            .antMatchers(HttpMethod.GET, "/orders").hasRole("USER")
            .antMatchers(HttpMethod.POST, "/orders/complete").hasRole("USER")
            .antMatchers(HttpMethod.POST, "/shopping-carts/concert-sessions").hasRole("USER")
            .antMatchers(HttpMethod.GET, "/shopping-carts/by-user").hasRole("USER")
            .antMatchers(HttpMethod.GET, "/users/by-email").hasRole("ADMIN")
            .anyRequest().authenticated()
            .and()
            .formLogin().permitAll()
            .and()
            .httpBasic()
            .and()
            .csrf().disable();
        ;
    }

}
