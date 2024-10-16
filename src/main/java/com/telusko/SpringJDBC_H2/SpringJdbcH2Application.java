package com.telusko.SpringJDBC_H2;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.telusko.SpringJDBC_H2.models.Student;
import com.telusko.SpringJDBC_H2.services.StudentService;

@SpringBootApplication
public class SpringJdbcH2Application {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringJdbcH2Application.class, args);
		
		Student s = context.getBean(Student.class);
		s.setName("Darshan");
		s.setRollno(2);
		s.setMarks(59);
		
		StudentService ss = context.getBean(StudentService.class);
		ss.add(s);
		
		List<Student> students = ss.getAll();
		System.out.println(students);
	}

}
