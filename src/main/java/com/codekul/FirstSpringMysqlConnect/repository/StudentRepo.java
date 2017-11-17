package com.codekul.FirstSpringMysqlConnect.repository;

import com.codekul.FirstSpringMysqlConnect.model.Student;

import java.util.List;
import java.util.Map;

/**
 * Created by pooja on 31/10/17.
 */
public interface StudentRepo {

    List<Student> getStudentList();

    Student getStudent(Integer id);

    void insertStudent(Student student);

    void insertStudentList(List<Student> student);

    void deleteStudent(Integer id);

    void updateStudent(Integer id,String name);

    List<Map<String,Object>> innerJoin();

    String insertStud(Student student);


}
