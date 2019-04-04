package com.springboottest.example.Controller;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

public class BaseController {

    @ExceptionHandler(Exception.class)
    public ModelAndView defaultErrorHandler(HttpServletRequest request,
                                            Exception e){
        System.out.println("BaseController.defaultErrorHandler");
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("exception", e);
        modelAndView.addObject("url", request.getRequestURL());
        modelAndView.setViewName("error");
        return modelAndView;
    }
}
