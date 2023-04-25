package com.in28minutes.springboot.myfirstwebapp.login;


import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;


@Controller
@SessionAttributes("name")
public class WelcomeController {







    @RequestMapping(value="/",method = RequestMethod.GET)
    public String goToWelcomePage(ModelMap model)
    {
        model.put("name", getLoggedinUsername());
        return "welcome";
    }

    private String getLoggedinUsername() {
        final Authentication authentication =
                SecurityContextHolder.getContext().getAuthentication(); //pulls logged in user from SecurityContext collection
        return authentication.getName(); //returns a string of user
    }
}
