package com.codekul.FirstSpringMysqlConnect.model;

/**
 * Created by pooja on 31/10/17.
 */

public class Student {


    Integer id;
    String name;
    String city;
    Integer dept_id;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Integer getDept_id() { return dept_id; }

    public void setDept_id(Integer dept_id) {
        this.dept_id = dept_id;
    }


    public Dept getDept() {
        return dept;
    }

    public void setDept(Dept dept) {
        this.dept = dept;
    }

    Dept dept;
}

