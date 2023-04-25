package com.in28minutes.springboot.myfirstwebapp.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration  //declare class as a bean to be used of Spring Security Context for configuraiton
public class SpringSecurityConfiguration {
    //LDAP or Database to store user names or passwords
    //We will use in memory

    //InMemoryUserDetailsManager
    //InMemoryUserDetailsManager(UserDetails... users)

    @Bean
    public InMemoryUserDetailsManager createUserDetailsManager() {
        //userDetail builder
        UserDetails userDetails = User.withDefaultPasswordEncoder()   //deprecated, ideally all passwords should be encoded
                .username("jtlabs")
                .password("dummy")
                .roles("USER", "ADMIN")
                .build();

        return new InMemoryUserDetailsManager(userDetails);
    }
}
