package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Admin;
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
		ad.setUser(user);
		ad.setPwd(pwd);
		AdminService service = new AdminServiceImpl();
		if(user.trim().equals("")){
			request.setAttribute("msg1","账户名不能为空" );
			request.setAttribute("admin", ad);
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}else if(pwd.trim().equals("")){
			request.setAttribute("msg6","请输入密码" );
			request.setAttribute("admin", ad);
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}else if(!service.userExist(user)){
			request.setAttribute("msg7","账户不存在请注册" );
			request.setAttribute("admin", ad);
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}else if(service.userExist(user)&&!service.userExist(ad)){
			request.setAttribute("msg8","密码错误" );
			ad.setPwd("");
			request.setAttribute("admin", ad);
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}else{
			request.setAttribute("admin", ad);
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
