package com.codekul.FirstSpringMysqlConnect.controller;

import com.codekul.FirstSpringMysqlConnect.impl.StudentImpl;
import com.codekul.FirstSpringMysqlConnect.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by pooja on 31/10/17.
 */

@RestController
public class StudentController {

    @Autowired
    StudentImpl student;

    @RequestMapping(value = "/listofstudent")
    public List<Student> getStudentData(){

        List<Student> list=student.getData();

        return list;
    }
}
