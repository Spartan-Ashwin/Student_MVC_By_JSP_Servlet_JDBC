package com.studentmvc.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import com.studentmvc.model.Student;
import com.studentmvc.serviceimpl.StudentServiceImpl;

/**
 * Servlet implementation class StudentController
 */
public class StudentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	StudentServiceImpl obj=new StudentServiceImpl();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			List<Student> students=obj.getAll();
			RequestDispatcher rd=request.getRequestDispatcher("student-list.jsp");
			request.setAttribute("studentList", students);
			rd.forward(request, response);
		}catch(Exception e) {
			System.out.println(e);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		 
		try {
			int id=Integer.parseInt(request.getParameter("id"));
			int marks=Integer.parseInt(request.getParameter("marks"));
			String phone=request.getParameter("phone");
			String city=request.getParameter("city");
			String gender=request.getParameter("gender");
			String name=request.getParameter("name");
		
			Student s=new Student(id,name,phone,gender,marks,city);
			int result=obj.add(s);
			RequestDispatcher rd=request.getRequestDispatcher("register.jsp");
			
			if(result>0) {
				request.setAttribute("msg", "Student Registered !");
			}else {
				request.setAttribute("errorMsg", "Problem in Registration !");
			}
			
			rd.forward(request, response);
			
			
			
		}catch(Exception e) {
	}


}
	
}