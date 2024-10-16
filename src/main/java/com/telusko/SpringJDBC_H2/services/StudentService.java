package com.telusko.SpringJDBC_H2.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.telusko.SpringJDBC_H2.models.Student;
import com.telusko.SpringJDBC_H2.repo.StudentRepo;

@Service
public class StudentService {
	
	private StudentRepo sr;
	
	public StudentRepo getSr() {
		return sr;
	}


	@Autowired
	public void setSr(StudentRepo sr) {
		this.sr = sr;
	}



	public void add(Student s) {
		
		sr.save(s);
		
	}


	public List<Student> getAll() {
		
		return sr.fetchAll();
	}
	
	

}
