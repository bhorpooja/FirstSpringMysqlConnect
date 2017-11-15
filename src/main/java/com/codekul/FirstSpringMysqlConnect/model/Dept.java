package com.codekul.FirstSpringMysqlConnect.model;

/**
 * Created by pooja on 15/11/17.
 */
public class Dept {

    Integer dept_id;
    String dept_name;

    public Integer getDept_id() {
        return dept_id;
    }

    public void setDept_id(Integer dept_id) {
        this.dept_id = dept_id;
    }

    public String getDept_name() {
        return dept_name;
    }

    public void setDept_name(String dept_name) {
        this.dept_name = dept_name;
    }
}
