package dao.daoImpl;

import java.sql.SQLException;

import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;


import dao.AdminDao;
import entity.Admin;
import util.JDBCUtil;

public class AdminDaoImpl implements AdminDao{

	String sql = null;
	
	@Override
	public void addAdmin(Admin admin) {
		try {
			sql = "insert into admin(user,pwd,email) values(?,?,?)";
			JDBCUtil.getQueryRunner().update(sql, admin.getUser(), admin.getPwd(), admin.getEmail());
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	@Override
	public void deleteAdmin(String user) {
		try {
			sql = "delete from admin where user=?";
			JDBCUtil.getQueryRunner().update(sql, user);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	@Override
	public void updateAdmin(Admin admin) {
		try {
			sql = "update admin set pwd=?,email=? where user=?";
			JDBCUtil.getQueryRunner().update(sql, admin.getPwd(), admin.getEmail(), admin.getUser());
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	@Override
	public boolean userExist(String user) {
		try {
			sql = "select * from admin where user=?";
			String str = JDBCUtil.getQueryRunner().query(sql,new ScalarHandler<String>(), user);
			if(str!=null){
				return true;
			}else{
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	@Override
	public Admin getAdmin(String user,String pwd) {
		try {
			sql = "select * from admin where user=? and pwd=?";
			Admin ad  = JDBCUtil.getQueryRunner().query(sql, new BeanHandler<Admin>(Admin.class), user,pwd);
			return ad;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	@Override
	public boolean userExist(Admin admin) {
		try {
			sql = "select * from admin where user=? and pwd=?";
			String str = JDBCUtil.getQueryRunner().query(sql,new ScalarHandler<String>(), admin.getUser(), admin.getPwd());
			if(str!=null){
				return true;
			}else{
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	
	
}

