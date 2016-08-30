package service.serviceImpl;

import dao.AdminDao;
import dao.daoImpl.AdminDaoImpl;
import entity.Admin;
import exception.PwdNullException;
import exception.PwdWrongException;
import exception.UserNotExistException;
import exception.UserNullException;
import exception.userRepeatException;
import service.AdminService;

public class AdminServiceImpl implements AdminService {

	AdminDao dao = new AdminDaoImpl();
	@Override
	public void addAdmin(Admin admin) throws userRepeatException, UserNullException, PwdNullException {

		if(admin.getUser().trim().equals("")){
			throw new UserNullException("账户名不能为空");
		}
		if(userExist(admin.getUser())){
			throw new userRepeatException("账号已存在");
		}
		if(admin.getPwd().trim().equals("")){
			throw new PwdNullException("请输入密码");
		}
		dao.addAdmin(admin);
	}

	@Override
	public void deleteAdmin(String user) {

		dao.deleteAdmin(user);
	}

	@Override
	public void updateAdmin(Admin admin) {

		dao.updateAdmin(admin);
	}

	@Override
	public boolean userExist(String user) {
		return dao.userExist(user);
	}

	@Override
	public Admin getAdmin(String user,String pwd) throws UserNullException, PwdNullException, UserNotExistException, PwdWrongException {

		if(user.trim().equals("")){
			throw new UserNullException("账户名不能为空");
		}
		if(pwd.trim().equals("")){
			throw new PwdNullException("请输入密码");
		}
		if(!userExist(user)){
			throw new UserNotExistException("账户不存在请注册");
		}
		if(dao.getAdmin(user,pwd)==null){
			throw new PwdWrongException("密码错误");
		}
		return dao.getAdmin(user,pwd);
	}

	@Override
	public boolean userExist(Admin admin) {
		return dao.userExist(admin);
	}

}
