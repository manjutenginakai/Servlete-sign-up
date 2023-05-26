package Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.Student_dao;
import Dto.Student;

@WebServlet("/Update")
public class Update extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id=Integer.parseInt(req.getParameter("id"));
		String  name=req.getParameter("name");
		long mobile=Long.parseLong(req.getParameter("phone"));
		String password = req.getParameter("password");
		String email=req.getParameter("email");
		
		Student student=new Student();
		student.setId(id);
		student.setName(name);
		student.setEmail(email);
		student.setPassword(password);
		student.setPhone(mobile);
		
		Student_dao dao=new Student_dao();
		dao.update(student);
		
		resp.getWriter().print("<h1>Updated Successfully");
		req.getRequestDispatcher("Home.html").include(req, resp);
	}
}
