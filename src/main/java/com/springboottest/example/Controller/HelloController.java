package com.springboottest.example.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// RestController相当于SpringMVC的@Controller + @ResponseBody
@RestController
public class HelloController {

    @RequestMapping("/hello")
    public String hello(){
        return "Hello Spring Boot!";
    }
}
