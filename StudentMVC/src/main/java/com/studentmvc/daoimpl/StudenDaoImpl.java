package com.studentmvc.daoimpl;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.stdentmvc.util.SqlUtil;
import com.stdentmvc.util.SqlUtil.*;
import com.studentmvc.dao.StudentDao;
import com.studentmvc.model.Student;




public class StudenDaoImpl implements StudentDao {

	@Override
	public int add(Student s) {
		// TODO Auto-generated method stub
		int result=-1;
		try {
			SqlUtil.connectDb();
			String query="insert into student values('"+s.getId()+"','"+s.getName()+"','"+s.getPhone()+"','"+s.getMarks()+"','"+s.getCity()+"','"+s.getGender()+"')";
			result=SqlUtil.insert(query);
			SqlUtil.close();
			
		}catch(Exception e) {
			System.out.println(e);
		}
		return result;
	
	}
	
	public int delete(int id) {
		
		int result=-1;
		try {
			SqlUtil.connectDb();
			String query="delete from student where id='"+id+"'";
			result=SqlUtil.insert(query);
			SqlUtil.close();
			
		}catch(Exception e) {
			System.out.println(e);
		}
		return result;
	}
	
	public int update(int id,Student s) {
		
		int result=-1;
		try {
			SqlUtil.connectDb();
			String query="update student set name='"+s.getName()+"', phone='"+s.getPhone()+"',marks='"+s.getMarks()+"',city='"+s.getCity()+"',gender='"+s.getGender()+"' where id='"+id+"'";
			result=SqlUtil.insert(query);
			SqlUtil.close();
			
		}catch(Exception e) {
			System.out.println(e);
		}
		return result;
	}

	@Override
	public List<Student> getAll() {
		// TODO Auto-generated method stub
		List<Student> arr=new ArrayList<>();
		try {
			SqlUtil.connectDb();
			String query="select * from student";
			ResultSet rs=SqlUtil.fetch(query);
			
			while(rs.next()) {
				int id=rs.getInt(1);
				String name=rs.getString(2);
				String phone=rs.getString(3);
				int marks=rs.getInt(4);
				String city=rs.getString(5);
				String gender=rs.getString(6);
				Student s=new Student();
				s.setId(id);
				s.setName(name);
				s.setPhone(phone);
				s.setMarks(marks);
				s.setCity(city);
				s.setGender(gender);
				arr.add(s);
			}
			SqlUtil.close();
			
			
		}catch(Exception e) {
			System.out.println(e);
		}
		return arr;
	}

	@Override
	public Student getById(int id) {
		// TODO Auto-generated method stub
		
		
        Student s=null;
		try {
			SqlUtil.connectDb();
			String query="select * from student where id='"+id+"'";
			ResultSet rs=SqlUtil.fetch(query);
			
			while(rs.next()) {
				int id1=rs.getInt(1);
				String name=rs.getString(2);
				String phone=rs.getString(3);
			    int  marks=rs.getInt(4);
				String city=rs.getString(5);
				String gender=rs.getString(6);
			 s=new Student();
				s.setId(id1);
				s.setName(name);
				s.setPhone(phone);
				s.setMarks(marks);
				s.setCity(city);
				s.setGender(gender);
				
			}
			SqlUtil.close();
			
			
		}catch(Exception e) {
			System.out.println(e);
		}
		return s;
	}

}
