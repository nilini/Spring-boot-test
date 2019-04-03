package com.springboottest.example.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    @RequestMapping("/")
    public String index(Model model){
        System.out.println("IndexController index方法被调用......");
        // 返回resources/templates/index.html
        return "index";
    }
}
