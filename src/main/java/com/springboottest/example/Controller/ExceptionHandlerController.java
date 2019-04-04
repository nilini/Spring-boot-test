package com.springboottest.example.Controller;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExceptionHandlerController {

    @RequestMapping("/error2")
    public String test() throws  Exception{
        System.out.println("ExceptionHandlerController.test");
        int i= 5/0;
        return "success";
    }
    /*
    * 在异常抛出的时候，Controller会使用@ExceptionHandler注解处理异常，而不会抛给Servlet
    * */
    @ExceptionHandler(Exception.class)
    public String testErrorHandler(Exception e){
        System.out.println("ExceptionHandlerController.testErrorHandler");
        return "服务器故障，请联系管理员";
    }
}
