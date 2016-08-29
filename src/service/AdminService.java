package service;

import entity.Admin;
import exception.userRepeatException;

public interface AdminService {

	public void addAdmin(Admin admin) throws userRepeatException;
	public void deleteAdmin(String user);
	public void updateAdmin(Admin admin);
	public boolean userExist(String user);
	public boolean userExist(Admin admin);
	public Admin getAdminByUser(String user);
}
