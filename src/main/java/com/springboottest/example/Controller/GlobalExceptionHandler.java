package com.springboottest.example.Controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Object globalErrorHandler(HttpServletRequest request, Exception e){
        System.out.println("GlobalExceptionHandler.globalErrorHandler");
        Map<String, Object> map = new HashMap<>();
        map.put("code", 100);
        map.put("message", e.getMessage());
        map.put("url", request.getRequestURL().toString());
        map.put("data", "请求失败");

        return map;
    }
}
