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
//			throw new UserNullException("�˻�������Ϊ��");
//		}
//		if(admin.getPwd().trim().equals("")){
//			throw new PwdNullException("����������");
//		}else if(!userExist(admin.getUser())){
//			throw new UserNotExistException("�˻���������ע��");
//		}else if(userExist(admin.getUser())&&!userExist(admin)){
//			throw new PwdWrongException("�������");
//			
//		}
		if(userExist(admin.getUser())){
			throw new userRepeatException("�˺��Ѵ���");
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
