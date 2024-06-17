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
 * Servlet implementation class DeleteStudentController
 */
public class DeleteStudentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteStudentController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		try {
			int id=Integer.parseInt(request.getParameter("id"));
			
			StudentServiceImpl obj=new StudentServiceImpl();
			int result=obj.delete(id);
			List<Student> students=obj.getAll();
			RequestDispatcher rd=request.getRequestDispatcher("student-list.jsp");
			request.setAttribute("studentList", students);
			rd.forward(request, response);
		   response.sendRedirect("student-list.jsp");
		   
			
		}catch(Exception e) {
			System.out.println("Deleter wala");
			System.out.println(e);
			
		}
		
		
	}

}
