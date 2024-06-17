package com.studentmvc.dao;

import java.util.List;

import com.studentmvc.model.*;

public interface StudentDao {
	
	
   int add(Student s);
	
	int delete(int id);
	
	int update(int id,Student s);
	
	List<Student> getAll();
	
	Student getById(int id);
	

}
