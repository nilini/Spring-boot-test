package com.springboottest.example.Controller;

import com.springboottest.example.bean.Student;
import com.springboottest.example.service.SchoolService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Resource
    private SchoolService schoolService;


    @PostMapping(value="/save")
    public Map<String, Object> save(@RequestBody Student student){
        Student save = schoolService.save(student);
        Optional<Student> student2 = schoolService.selectByKey(student.getId());
        Map<String, Object> params = new HashMap<>();
        params.put("code", "success");
        params.put("student", student2);
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>" + student2.toString());
        return params;
    }

    @GetMapping(value="/get/{id}")
    @ResponseBody
    public Optional<Student> qryStu(@PathVariable(value="id") Integer id){
        Optional<Student> student = schoolService.selectByKey(id);
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>StudentController.qryStu");
        return student;
    }
}
