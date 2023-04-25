package com.in28minutes.springboot.myfirstwebapp.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import static org.springframework.security.config.Customizer.withDefaults;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.server.SecurityWebFilterChain;

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

        UserDetails userDetails1 = createNewUser(passwordEncoder, "jtlabs", "dummy");
        UserDetails userDetails2 = createNewUser(passwordEncoder, "Jay", "dummydummy");

        return new InMemoryUserDetailsManager(userDetails1, userDetails2);
    }

    private static UserDetails createNewUser(Function<String, String> passwordEncoder, String username, String password) {
        UserDetails userDetails = User.builder()
                .passwordEncoder(passwordEncoder) //use our custom encoder via a lambda expression
                .username(username)
                .password(password)
                .roles("USER", "ADMIN")
                .build();
        return userDetails;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


    //All URLS are protected
    //A login form is shown for unauthorized request
    //CSRF (Cross-site Request Forgery) needs to be disabled for h2-console to work
    //Frames are used by h2, spring security does not allow frames

    @Bean
    //SecurityWebFilterChain r DefaultSecuirtyFilterChain routes individuals to login when not authenticated
    //this method will reconfigure
    public DefaultSecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(
                auth -> auth.anyRequest().authenticated());

        http.formLogin(withDefaults());//configure form login so we can have a page where username and password can be collected

        http.csrf().disable();//disable CSRF
        http.headers().frameOptions().disable(); //enables use of frames on application
        return http.build();
    }
}
