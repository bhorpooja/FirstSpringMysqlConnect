package com.codekul.FirstSpringMysqlConnect.impl;


import com.codekul.FirstSpringMysqlConnect.model.Dept;
import com.codekul.FirstSpringMysqlConnect.model.Student;
import com.codekul.FirstSpringMysqlConnect.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;
import java.util.Map;

/**
 * Created by pooja on 31/10/17.
 */
@Repository
public class StudentImpl implements StudentRepo{



    @Autowired
    JdbcTemplate jdbcTemplate;


    @Override
    public List<Student> getStudentList() {

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
    public void insertStudent(Student student) {
        String sql = "insert into Student values(?,?,?,?);";
        jdbcTemplate.update(sql,
                new Object[]{student.getId(), student.getName(), student.getCity(),student.getDept_id()},
                new int[]{Types.INTEGER, Types.VARCHAR, Types.VARCHAR,Types.INTEGER});
    }

    @Override
    public void insertStudentList(List<Student> student) {

        String sql="insert into Student values(?,?,?,?);";

        jdbcTemplate.batchUpdate(sql,
                new BatchPreparedStatementSetter() {

            @Override
            public void setValues(PreparedStatement ps, int i) throws SQLException {
                Student stud=student.get(i);
                ps.setInt(1,stud.getId());
                ps.setString(2,stud.getName());
                ps.setString(3,stud.getCity());
                ps.setInt(4,stud.getDept_id());

            }

            @Override
            public int getBatchSize() {
                return student.size();
            }
        });
    }



    @Override
    public void deleteStudent(Integer id) {
        String sql="delete from Student where id=?;";
        jdbcTemplate.update(sql,new Object[]{id},new int[]{Types.INTEGER});

    }

    @Override
    public void updateStudent(Integer id, String name) {
        String sql="update Student set name=? where id=?;";
        jdbcTemplate.update(sql,new Object[]{name,id},new int[]{Types.VARCHAR,Types.INTEGER});
    }

    @Override
    public List<Map<String, Object>> innerJoin() {
        String sql=" select Student.id,Student.name,Student.city,Dept.dept_name from Student inner join Dept on Student.dept_id=Dept.dept_id;";
        List<Map<String,Object>> list=jdbcTemplate.queryForList(sql);
        return list;
    }

    @Override
    public String insertStud(Student student) {

        Dept dObj=student.getDept();
        Integer d_id=dObj.getDept_id();
        Dept dObj1=getDept(d_id);
        String msg="";
        if(dObj1!=null) {
            if (dObj.getDept_id().equals(dObj1.getDept_id())) {
                msg=insertStud1(student);
            }
        }
                else {
                   msg=insertDept(dObj);
                   insertStud1(student);
                }
         return msg;
        }




    public Dept getDept(Integer dept_id){

        Dept dept1;
        try {

            String sql="select * from Dept where dept_id=?;";
            dept1 = jdbcTemplate.queryForObject(sql,
                    new Object[]{dept_id},
                    new int[]{Types.INTEGER},
                    new BeanPropertyRowMapper<>(Dept.class));

        }
        catch (EmptyResultDataAccessException e){
            return null;
        }
        return dept1;
    }

    public String insertStud1(Student student) {
        String sql = "insert into Student values(?,?,?,?);";
        jdbcTemplate.update(sql,
                new Object[]{student.getId(), student.getName(), student.getCity(),student.getDept_id()},
                new int[]{Types.INTEGER, Types.VARCHAR, Types.VARCHAR,Types.INTEGER});
        return "Student data inserted successfully";
    }

    public String insertDept(Dept dept) {
        String sql = "insert into Dept values(?,?);";
        jdbcTemplate.update(sql,
                new Object[]{dept.getDept_id(),dept.getDept_name()},
                new int[]{Types.INTEGER, Types.VARCHAR});
        return "Department and Student Inserted successfully";
    }



}

