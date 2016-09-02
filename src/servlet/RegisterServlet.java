package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Admin;
import exception.PwdNullException;
import exception.UserNullException;
import exception.userRepeatException;
import service.AdminService;
import service.serviceImpl.AdminServiceImpl;

/**
 * Servlet implementation class Register
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		String user = null;
		String pwd = null;
		String checkpwd = null;
		String email = null;
		Admin ad = new Admin();
		user = request.getParameter("user");
		pwd = request.getParameter("pwd");
		checkpwd = request.getParameter("checkpwd");
		ad.setUser(user);
		ad.setPwd(pwd);
		ad.setEmail(email);
		if(checkpwd.trim().equals("")||!checkpwd.equals(pwd)){
			request.setAttribute("msg4", "两次输入密码不相同");
			request.setAttribute("admin", ad);
			request.getRequestDispatcher("/register.jsp").forward(request, response);
		}else{
			try {
				AdminService service = new AdminServiceImpl();
				service.addAdmin(ad);
				request.getRequestDispatcher("/registerSuccess.jsp").forward(request, response);
			} catch (userRepeatException e) {
				request.setAttribute("msg5", e.getMessage());
				request.setAttribute("admin", ad);
				request.getRequestDispatcher("/register.jsp").forward(request, response);
			} catch (UserNullException e) {
				request.setAttribute("msg2", e.getMessage());
				request.setAttribute("admin", ad);
				request.getRequestDispatcher("/register.jsp").forward(request, response);			
			} catch (PwdNullException e) {
				request.setAttribute("msg3", e.getMessage());
				request.setAttribute("admin", ad);
				request.getRequestDispatcher("/register.jsp").forward(request, response);			
			}
		}
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
