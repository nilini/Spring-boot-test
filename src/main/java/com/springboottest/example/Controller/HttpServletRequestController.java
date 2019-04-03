package com.springboottest.example.Controller;

import org.springframework.boot.web.servlet.server.Session;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.net.URLEncoder;

@Controller
public class HttpServletRequestController {

    /**
     * request对象是JSP中重要的对象，每个request对象封装着一次用户请求。
     * */
    @RequestMapping("/request")
    public String index(HttpServletRequest request, HttpServletResponse response) throws IOException {

        HttpSession session = request.getSession();
        System.out.println(session.getId());
        return "index";
    }
}
