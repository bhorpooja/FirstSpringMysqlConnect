package com.codekul.FirstSpringMysqlConnect.repository;

import com.codekul.FirstSpringMysqlConnect.model.Student;

import java.util.List;

/**
 * Created by pooja on 31/10/17.
 */
public interface StudentRepo {

    List<Student> getData();

//    Student getStudent(Integer id);

}
