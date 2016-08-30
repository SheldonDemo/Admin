package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Admin;
import exception.PwdNullException;
import exception.PwdWrongException;
import exception.UserNotExistException;
import exception.UserNullException;
import service.AdminService;
import service.serviceImpl.AdminServiceImpl;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Admin ad = new Admin();
		String user = request.getParameter("user");
		String pwd = request.getParameter("pwd");
		AdminService service = new AdminServiceImpl();
		try {
			ad = service.getAdmin(user,pwd);
			request.setAttribute("admin", ad);
			request.getRequestDispatcher("/indexOfAdmin.jsp").forward(request, response);
		} catch (UserNullException e) {
			request.setAttribute("msg1", e.getMessage());
			request.getRequestDispatcher("/index.jsp").forward(request, response);
		} catch (PwdNullException e) {
			request.setAttribute("msg6", e.getMessage());
			request.setAttribute("user", user);
			request.getRequestDispatcher("/index.jsp").forward(request, response);
		} catch (UserNotExistException e) {
			request.setAttribute("msg7", e.getMessage());
			request.setAttribute("user", user);
			request.setAttribute("pwd", pwd);
			request.getRequestDispatcher("/index.jsp").forward(request, response);
		} catch (PwdWrongException e) {
			request.setAttribute("msg8", e.getMessage());
			request.setAttribute("user", user);
			request.getRequestDispatcher("/index.jsp").forward(request, response);		
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
