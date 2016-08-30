package dao.daoImpl;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;


import dao.AdminDao;
import entity.Admin;
import util.JDBCUtil;

public class AdminDaoImpl implements AdminDao{

	private Connection conn = null;
	private QueryRunner qr = new QueryRunner();
	String sql = null;
	
	@Override
	public void addAdmin(Admin admin) {
		try {
			conn = JDBCUtil.getConnection();
			sql = "insert into admin(user,pwd,email) values(?,?,?)";
			qr.update(conn, sql, admin.getUser(), admin.getPwd(), admin.getEmail());
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally{
			JDBCUtil.close(conn);
		}
	}

	@Override
	public void deleteAdmin(String user) {
		try {
			conn = JDBCUtil.getConnection();
			sql = "delete from admin where user=?";
			qr.update(conn, sql, user);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally{
			JDBCUtil.close(conn);
		}
	}

	@Override
	public void updateAdmin(Admin admin) {
		try {
			conn = JDBCUtil.getConnection();
			sql = "update admin set pwd=?,email=? where user=?";
			qr.update(conn, sql, admin.getPwd(), admin.getEmail(), admin.getUser());
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally{
			JDBCUtil.close(conn);
		}
	}

	@Override
	public boolean userExist(String user) {
		try {
			conn = JDBCUtil.getConnection();
			sql = "select * from admin where user=?";
			String str = qr.query(conn, sql,new ScalarHandler<String>(), user);
			if(str!=null){
				return true;
			}else{
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally{
			JDBCUtil.close(conn);
		}
	}

	@Override
	public Admin getAdmin(String user,String pwd) {
		try {
			conn = JDBCUtil.getConnection();
			sql = "select * from admin where user=? and pwd=?";
			Admin ad  = qr.query(conn, sql, new BeanHandler<Admin>(Admin.class), user,pwd);
			return ad;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally{
			JDBCUtil.close(conn);
		}
	}

	@Override
	public boolean userExist(Admin admin) {
		try {
			conn = JDBCUtil.getConnection();
			sql = "select * from admin where user=? and pwd=?";
			String str = qr.query(conn, sql,new ScalarHandler<String>(), admin.getUser(), admin.getPwd());
			if(str!=null){
				return true;
			}else{
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally{
			JDBCUtil.close(conn);
		}
	}

	
	
}
