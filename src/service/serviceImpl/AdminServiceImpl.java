package service.serviceImpl;

import dao.AdminDao;
import dao.daoImpl.AdminDaoImpl;
import entity.Admin;
import exception.userRepeatException;
import service.AdminService;

public class AdminServiceImpl implements AdminService {

	AdminDao dao = new AdminDaoImpl();
	@Override
	public void addAdmin(Admin admin) throws userRepeatException {

//		if(admin.getUser().trim().equals("")){
//			throw new UserNullException("账户名不能为空");
//		}
//		if(admin.getPwd().trim().equals("")){
//			throw new PwdNullException("请输入密码");
//		}else if(!userExist(admin.getUser())){
//			throw new UserNotExistException("账户不存在请注册");
//		}else if(userExist(admin.getUser())&&!userExist(admin)){
//			throw new PwdWrongException("密码错误");
//			
//		}
		if(userExist(admin.getUser())){
			throw new userRepeatException("账号已存在");
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
	public Admin getAdminByUser(String user) {
		return dao.getAdminByUser(user);
	}

	@Override
	public boolean userExist(Admin admin) {
		return dao.userExist(admin);
	}

}
