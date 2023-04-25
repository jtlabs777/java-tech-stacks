package com.in28minutes.springboot.myfirstwebapp.login;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;


@Controller
@SessionAttributes("name")
public class LoginController {

    private Logger logger;

    private AuthenticationService authenticationService;

    public LoginController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
        this.logger =  LoggerFactory.getLogger(getClass());
    }

    @RequestMapping(value="login",method = RequestMethod.GET)
    public String goToLoginPage()
    {

        return "login";
    }

    @RequestMapping(value="login",method = RequestMethod.POST)
    public String goToWelcomePage(@RequestParam String name, @RequestParam String password, ModelMap model)
    {
        model.put("name", name);



        logger.debug("userName: {}", name);
        logger.debug("password: {}", password);

        if(authenticationService.authenticate(name, password)) {
        return "welcome";
        }
        //Authentication
        //name - in28minutes
        //password - dummy
        model.put("errorMessage",  "Invalid Credentials, Please try again.");
        return "login";
    }
}
