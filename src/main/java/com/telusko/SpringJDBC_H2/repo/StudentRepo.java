package com.telusko.SpringJDBC_H2.repo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.DataClassRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.RowMapperResultSetExtractor;
import org.springframework.stereotype.Repository;

import com.telusko.SpringJDBC_H2.models.Student;

@Repository
public class StudentRepo {
    
    private JdbcTemplate jt;
    
    public JdbcTemplate getJt() { 
        return jt; 
    }

    @Autowired
    public void setJt(JdbcTemplate jt) { 
        this.jt = jt; 
    }

    public void save(Student s) {
        String sql = "insert into student(name, rollno, marks) values(?,?,?)";
        int status = jt.update(sql, s.getName(), s.getRollno(), s.getMarks());
        System.out.println(status == 1 ? true : false);
        System.out.println("success");
    }

    public List<Student> fetchAll() {
        String sql = "select * from student";

        return jt.query(sql, new RowMapper<Student>() {
            @Override
            public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
                Student student = new Student();

                student.setName(rs.getString("name"));
                student.setRollno(rs.getInt("rollno"));
                student.setMarks(rs.getInt("marks"));
                return student;
            }
        });
    }
}
