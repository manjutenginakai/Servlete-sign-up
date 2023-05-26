package Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

import Dao.Student_dao;

@WebServlet("/delete")
public class Delete_Servlet extends HttpServlet {
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {

		int id = Integer.parseInt(req.getParameter("id"));
		Student_dao dao = new Student_dao();
		dao.delete(id);

		res.getWriter().print("<h1>Deleted succussfully</h1>");
		req.getRequestDispatcher("Home.html").include(req, res);
	}
}
