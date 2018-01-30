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

    @RequestMapping(value = "/getStudentList")
    public List<Student> getStudentList(){

        List<Student> list=student.getStudentList();

        return list;
    }

    @GetMapping(value = "/getStudent/{id}")
    public Student getStudent(@PathVariable Integer id){
        Student stud=student.getStudent(id);
        return stud;
    }

    @PostMapping(value = "/insertStudent")
    public String insertStudent(@RequestBody Student stud){
        student.insertStudent(stud);
        return "Data inserted Successfully";
    }

    @PostMapping(value = "/insertStudentList")
    public String insertStudentList(@RequestBody List<Student> stud){

        student.insertStudentList(stud);

        return "data inserted successfully...";
    }

    @DeleteMapping(value = "/deleteStudent/{id}")
    public String deleteStudent(@PathVariable Integer id){
        student.deleteStudent(id);
        return "data deleted successfully";
    }

    @PostMapping(value = "/updateStudent/{id}/{name}")
    public String deleteStud(@PathVariable Integer id,@PathVariable String name){
        student.updateStudent(id,name);
        return "data updated successfully";
    }

    @GetMapping(value = "/innerjoin")
    public List<Map<String,Object>> inJoin(){
        List<Map<String,Object>> list=student.innerJoin();
        return list;
    }


    @PostMapping(value = "/insertStud")
    public String insertStud(@RequestBody  Student stud){
        return  student.insertStud(stud);
    }



}
