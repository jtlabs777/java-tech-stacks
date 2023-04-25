package com.in28minutes.springboot.myfirstwebapp.login;

import org.slf4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;


@Controller
@SessionAttributes("name")
public class WelcomeController {

    private Logger logger;





    @RequestMapping(value="/",method = RequestMethod.GET)
    public String goToWelcomePage(ModelMap model)
    {
        model.put("name", "Jay");
        return "welcome";
    }


}
