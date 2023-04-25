package com.in28minutes.springboot.myfirstwebapp.hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SayHelloController {

    @RequestMapping("say-hello")
    @ResponseBody
    public String sayHello() {
        return "Hello again and again and even again with a component instead of Controller! What are your learning today?";
    }

    @RequestMapping("say-hello-html")
    @ResponseBody
    public String sayHelloHtml() {
        StringBuffer sb = new StringBuffer();
        sb.append("<!DOCTYPE html>");
        sb.append("<html lang=\"en\">");
        sb.append("<head>");
        sb.append("<meta charset=\"UTF-8\">");
        sb.append("<meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\"");
        sb.append("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">");
        sb.append("<title>My First Html Page</title>");
        sb.append("</head>");
        sb.append("<body>");
        sb.append("My first html page with body");
        sb.append("</body>");
        sb.append("</html>");

        return sb.toString();
    }

    //"say-hello-jsp" => sayHello.jsp
    @RequestMapping("say-hello-jsp")
    //our jsp is in src/main/resources/META-INF/resources/WEB-INF/jsp/sayHello.jsp  which is a standard location for JSP files
    //our jsp is in src/main/resources/META-INF/resources/WEB-INF/jsp/welcome.jsp
    //our jsp is in src/main/resources/META-INF/resources/WEB-INF/jsp/login.jsp
    //our jsp is in src/main/resources/META-INF/resources/WEB-INF/jsp/todos.jsp
    public String sayHelloJsp() {
        return "sayHello";
    }
}
