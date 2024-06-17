package com.studentmvc.service;

import java.util.List;

import com.studentmvc.model.Student;

public interface StudentService {
	
   int add(Student s);
	
	int delete(int id);
	
	int update(int id,Student s);
	
	List<Student> getAll();
	
	Student getById(int id);

}
