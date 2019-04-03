package com.springboottest.example.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {

    @RequestMapping("/")
    public String index(Model model){
        System.out.println("IndexController index方法被调用......");
        System.out.println(model);
        model.addAttribute("title", "this is title");
        // 返回resources/templates/index.html
        return "index";
    }

    @RequestMapping("/modelView")
    public ModelAndView index2(ModelAndView modelAndView){
        System.out.println("IndexController.index2");
        System.out.println(modelAndView);
        modelAndView.setViewName("redirect:/");
        return modelAndView;
    }
}
