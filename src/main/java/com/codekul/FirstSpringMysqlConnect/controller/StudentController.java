package com.codekul.FirstSpringMysqlConnect.controller;

import com.codekul.FirstSpringMysqlConnect.impl.StudentImpl;
import com.codekul.FirstSpringMysqlConnect.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
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

    @RequestMapping(value = "/student/{id}")
    public Student getStudent(@PathVariable Integer id){
        Student stud=student.getStudent(id);
        return stud;
    }

    @RequestMapping(value = "/insert")
    public String insertStudent(@RequestBody Student stud){
        student.insertData(stud);
        return "Data inserted Successfully";
    }

    @RequestMapping(value = "/update")
    public String updateStudent(){
       student.updateData();
        return "Data updated successfully";
    }

    @RequestMapping(value = "/delete/{id}")
    public String deleteStudent(@PathVariable Integer id){
        student.deleteData(id);
        return "data deleted successfully";
    }

    @RequestMapping(value = "/update/{id}/{name}")
    public String deleteStud(@PathVariable Integer id,@PathVariable String name){
        student.updateStud(id,name);
        return "data updated successfully";
    }
}
