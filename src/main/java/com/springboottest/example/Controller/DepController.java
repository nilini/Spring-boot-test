package com.springboottest.example.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DepController {
    @RequestMapping("add")
    public String add(String deptname){
        System.out.println("DepController.add");
        if(deptname == null){
            throw new NullPointerException("部门不能为空！");
        }
        return "success";
    }
}
