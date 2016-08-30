package service;

import entity.Admin;
import exception.PwdNullException;
import exception.PwdWrongException;
import exception.UserNotExistException;
import exception.UserNullException;
import exception.userRepeatException;

public interface AdminService {

	public void addAdmin(Admin admin) throws userRepeatException, UserNullException, PwdNullException;
	public void deleteAdmin(String user);
	public void updateAdmin(Admin admin);
	public boolean userExist(String user);
	public boolean userExist(Admin admin);
	public Admin getAdmin(String user,String pwd) throws UserNullException, PwdNullException, UserNotExistException, PwdWrongException;
}
