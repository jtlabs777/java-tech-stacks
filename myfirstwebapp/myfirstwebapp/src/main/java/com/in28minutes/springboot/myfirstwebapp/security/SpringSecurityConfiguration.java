package com.in28minutes.springboot.myfirstwebapp.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
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

    @Bean   //as it is right now, this will not let you login using deprecated feature
    // because it is encrypting data user enters before the hash is checked
    //the deprecated withDefaultPasswordEncoder feature in the createUserDetailsManager bean needs to be replaced
    //with this encoder.
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
