package com.mnp.springbootrestapi.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class ComputerSecurity extends WebSecurityConfigurerAdapter {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("Steve").password(passwordEncoder().encode("pass1")).roles("ADMIN")
                .and()
                .withUser("Rebecca").password(passwordEncoder().encode("pass2")).roles("MODERATOR")
                .and()
                .withUser("John").password(passwordEncoder().encode("pass3")).roles("USER");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/springboot-restapi/delete-computer").hasRole("ADMIN")
                .antMatchers("/springboot-restapi/add-computer").hasAnyRole("ADMIN","MODERATOR")
                .antMatchers("/springboot-restapi/get-computers", "/springboot-restapi/get-computer").hasAnyRole("ADMIN","MODERATOR","USER")
                .anyRequest().authenticated()
                .and()
                .csrf().disable()
                .formLogin()
                .and()
                .httpBasic()
                .and()
                .logout();
    }
}
