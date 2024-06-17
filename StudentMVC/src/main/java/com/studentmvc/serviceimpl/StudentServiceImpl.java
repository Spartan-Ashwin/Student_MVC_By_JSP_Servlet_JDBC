package com.studentmvc.serviceimpl;

import java.util.List;

import com.studentmvc.dao.StudentDao;
import com.studentmvc.daoimpl.*;
import com.studentmvc.model.Student;
import com.studentmvc.service.StudentService;

import com.studentmvc.daoimpl.StudenDaoImpl;

public class StudentServiceImpl implements StudentService {
	

	StudentDao obj=new StudenDaoImpl();
	
	@Override
	public int add(Student s) {
		// TODO Auto-generated method stub
		
	return	obj.add(s);
		
	}

	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		return obj.delete(id);
	}

	@Override
	public int update(int id, Student s) {
		// TODO Auto-generated method stub
		return obj.update(id, s);
	}

	@Override
	public List<Student> getAll() {
		// TODO Auto-generated method stub
		return obj.getAll();
	}

	@Override
	public Student getById(int id) {
		// TODO Auto-generated method stub
		return obj.getById(id);
	}

}
