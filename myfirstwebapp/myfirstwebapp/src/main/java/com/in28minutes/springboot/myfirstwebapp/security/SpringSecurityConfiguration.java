package com.in28minutes.springboot.myfirstwebapp.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import java.util.function.Function;

@Configuration  //declare class as a bean to be used of Spring Security Context for configuraiton
public class SpringSecurityConfiguration {
    //LDAP or Database to store user names or passwords
    //We will use in memory

    //InMemoryUserDetailsManager
    //InMemoryUserDetailsManager(UserDetails... users)

    @Bean
    public InMemoryUserDetailsManager createUserDetailsManager() {
        //userDetail builder
        final Function<String, String> passwordEncoder = input -> passwordEncoder().encode(input); //utilize our function and then encode

          UserDetails userDetails = User.builder()
                .passwordEncoder(passwordEncoder) //use our custom encoder via a lambda expression
                .username("jtlabs")
                .password("dummy")
                .roles("USER", "ADMIN")
                .build();

        return new InMemoryUserDetailsManager(userDetails);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
