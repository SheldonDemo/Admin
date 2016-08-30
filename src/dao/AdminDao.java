package dao;

import entity.Admin;

public interface AdminDao {

	public void addAdmin(Admin admin);
	public void deleteAdmin(String user);
	public void updateAdmin(Admin admin);
	public boolean userExist(String user);
	public boolean userExist(Admin admin);
	public Admin getAdmin(String user,String pwd);
	
	
	
}
