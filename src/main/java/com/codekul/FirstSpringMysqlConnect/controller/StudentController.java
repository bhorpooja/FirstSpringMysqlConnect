package com.codekul.FirstSpringMysqlConnect.controller;

import com.codekul.FirstSpringMysqlConnect.impl.StudentImpl;
import com.codekul.FirstSpringMysqlConnect.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

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

    @RequestMapping(value = "/studentlist")
    public String insertStudentList(@RequestBody List<Student> stud){

        student.insertStudent(stud);

        return "data inserted successfully...";
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

    @GetMapping(value = "/innerjoin")
    public List<Map<String,Object>> inJoin(){
        List<Map<String,Object>> list=student.innerJoin();
        return list;
    }
}
