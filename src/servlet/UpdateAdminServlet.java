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
 * Servlet implementation class UpdateAdminServlet
 */
@WebServlet("/UpdateAdminServlet")
public class UpdateAdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateAdminServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String user = request.getParameter("user");
		String oldpwd = request.getParameter("oldpwd");
		String newpwd = request.getParameter("newpwd");
		String checknewpwd = request.getParameter("checknewpwd");
		AdminService service = new AdminServiceImpl();
		Admin ad = new Admin();
		try {
			service.getAdmin(user, oldpwd);
				
			if("".equals(checknewpwd.trim())||!checknewpwd.equals(newpwd)){
					request.setAttribute("msg10", "两次输入密码不相同");
					request.setAttribute("oldpwd",oldpwd );
					request.getRequestDispatcher("/update.jsp").forward(request, response);
			}else{
				ad.setUser(user);
				ad.setPwd(newpwd);
				service.updateAdmin(ad);
				request.getRequestDispatcher("/updateSuccess.jsp").forward(request, response);
			}
		} catch (UserNullException | PwdNullException | UserNotExistException | PwdWrongException e) {
			request.setAttribute("msg9", "密码错误");
			request.getRequestDispatcher("/update.jsp").forward(request, response);
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
