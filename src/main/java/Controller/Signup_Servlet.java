package Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.Student_dao;
import Dto.Student;

@WebServlet("/xyz")
public class Signup_Servlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//	String  name=req.getParameter("Name");
//	String  email=req.getParameter("E-mail");
//	long P_Number =Long.parseLong(req.getParameter("P_number"));
//	String password = req.getParameter("Password");
//	String Gender = req.getParameter("Gender");
//	
	
		Student student =new Student(); 
		 student.setEmail(req.getParameter("E-mail"));
		    student.setGender(req.getParameter("Gender"));
	    student.setPhone(Long.parseLong(req.getParameter("P_number")));
	    student.setName(req.getParameter("Name"));
	    student.setPassword(req.getParameter("Password"));
	    
	    Student_dao dao= new Student_dao();
	    dao.save(student);
	    
	    resp.getWriter().print("<h1>Data save succussfully</h1>");
	    req.getRequestDispatcher("Login.html").include(req, resp);
	}
	
}
