package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Admin;
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
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

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
		if(user.trim().equals("")){
			request.setAttribute("msg2", "账户名不能为空");
			request.setAttribute("admin", ad);
			request.getRequestDispatcher("/register.jsp").forward(request, response);
		}else if(pwd.trim().equals("")){
			request.setAttribute("msg3", "密码不能为空");
			request.setAttribute("admin", ad);
			request.getRequestDispatcher("/register.jsp").forward(request, response);
		}else if(checkpwd.trim().equals("")||!checkpwd.equals(pwd)){
			request.setAttribute("msg4", "两次输入密码不相同");
			request.setAttribute("admin", ad);
			request.getRequestDispatcher("/register.jsp").forward(request, response);
		}else{
			
			try {
				AdminService service = new AdminServiceImpl();
				service.addAdmin(ad);
				request.getRequestDispatcher("/registerSuccess.jsp").forward(request, response);
			} catch (userRepeatException e) {
				request.setAttribute("msg5", "账户名已存在");
				request.setAttribute("admin", ad);
				request.getRequestDispatcher("/register.jsp").forward(request, response);
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
