package com.codekul.FirstSpringMysqlConnect.impl;

import com.codekul.FirstSpringMysqlConnect.model.Student;
import com.codekul.FirstSpringMysqlConnect.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Types;
import java.util.List;

/**
 * Created by pooja on 31/10/17.
 */
@Repository
public class StudentImpl implements StudentRepo {
    @Autowired
    JdbcTemplate jdbcTemplate;


    @Override
    public List<Student> getData() {

        String sql = "select * from Student;";
        List<Student> list =
                jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Student.class));
        return list;
    }

    @Override
    public Student getStudent(Integer id) {

        String sql = "select * from Student where id=?;";
        Student student =
                jdbcTemplate.queryForObject(sql, new Object[]{id}, new int[]{Types.INTEGER}, new BeanPropertyRowMapper<>(Student.class));

        return student;
    }

    @Override
    public void insertData(Student student) {
        String sql = "insert into Student values(?,?,?);";
        jdbcTemplate.update(sql, new Object[]{student.getId(), student.getName(), student.getCity()}, new int[]{Types.INTEGER, Types.VARCHAR, Types.VARCHAR});
    }

    @Override
    public void updateData() {
        String sql = "update Student set city='Mumbai' where name='ashish';";
        jdbcTemplate.update(sql);
    }

    @Override
    public void deleteData(Integer id) {
        String sql="delete from Student where id=?;";
        jdbcTemplate.update(sql,new Object[]{id},new int[]{Types.INTEGER});

    }

    @Override
    public void updateStud(Integer id, String name) {
        String sql="update Student set name=? where id=?;";
        jdbcTemplate.update(sql,new Object[]{name,id},new int[]{Types.VARCHAR,Types.INTEGER});
    }


}

