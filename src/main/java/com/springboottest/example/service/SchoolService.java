package com.springboottest.example.service;

import com.springboottest.example.bean.Student;
import com.springboottest.example.repository.StudentRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class SchoolService {

    @Resource
    private StudentRepository studentRepository;

    @Transactional
    public Student save(Student student){
        return studentRepository.save(student);
    }

    public Optional<Student> selectByKey(Integer id){
        return studentRepository.findById(id);
    }


}
