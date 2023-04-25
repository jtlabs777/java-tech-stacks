package com.in28minutes.springboot.myfirstwebapp.login;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    private Logger logger = LoggerFactory.getLogger(getClass());
    public boolean authenticate(String userName, String password) {



        boolean isValidUserName = userName.equalsIgnoreCase("in28minutes");
        boolean isValidPassword = password.equalsIgnoreCase("Easy2guess!");

        logger.debug("Username: {}", userName);
        logger.debug("Password: {}", password);
        logger.debug("isValidUserName: {}", isValidUserName);
        logger.debug("isValidPassword: {}", isValidPassword);


        return isValidUserName && isValidPassword;
    }
}
