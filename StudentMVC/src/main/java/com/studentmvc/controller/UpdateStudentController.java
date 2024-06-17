package com.studentmvc.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import com.studentmvc.model.Student;
import com.studentmvc.serviceimpl.StudentServiceImpl;

/**
 * Servlet implementation class UpdateStudentController
 */
public class UpdateStudentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	StudentServiceImpl obj=new StudentServiceImpl();
	
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateStudentController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		
		try {
			
			int id =Integer.parseInt(request.getParameter("id"));
			Student s=obj.getById(id);
			
			String name=s.getName();
			String phone=s.getPhone();
		    int marks=s.getMarks();
		    String city=s.getCity();
		    String gender=s.getGender();
		    
	
			
			request.setAttribute("myobj", s);
		   
		    
		 
			
	    
	

		    RequestDispatcher rd=request.getRequestDispatcher("update.jsp");
			rd.forward(request, response);
		 
		    
		    
		    
		    
			
			
			
		}catch(Exception e) {
			
			
		}
	   
	  
	   
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		PrintWriter out=response.getWriter();
		
		try {
			int id=Integer.parseInt(request.getParameter("id"));
			String name=request.getParameter("name");
			String phone=request.getParameter("phone");
			int marks=Integer.parseInt(request.getParameter("marks"));
			String city=request.getParameter("city");
			String gender=request.getParameter("gender");
		
			Student s=new Student();
			s.setId(id);
			s.setName(name);
			s.setPhone(phone);
			s.setMarks(marks);
			s.setCity(city);
			gender=gender.trim();
			s.setGender(gender);
			
			StudentServiceImpl obj=new StudentServiceImpl();
			System.out.println(obj.update(id, s));
			
			
			
			//out.println("<script> <div class='alert alert-info' role='alert'>updatd sucessfully!</div> </script>");
			
			List<Student> students=obj.getAll();
			RequestDispatcher rd=request.getRequestDispatcher("student-list.jsp");
			request.setAttribute("studentList", students);
			rd.forward(request, response);
		  // response.sendRedirect("student-list.jsp");
			
		}catch(Exception e) {
			System.out.println("Updater wala");
			System.out.println(e);
			
		}
		
		
		
	}

}
