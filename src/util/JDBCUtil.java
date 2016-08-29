package util;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class JDBCUtil {

	private static String url = null;
	private static String user = null;
	private static String password = null;
	private static String driverClass = null;
	static{
		try {
			Properties prop = new Properties();
			InputStream in = JDBCUtil.class.getResourceAsStream("/db.properties");
			prop.load(in);
			url = prop.getProperty("url");
			user = prop.getProperty("user");
			password = prop.getProperty("password");
			driverClass = prop.getProperty("driverClass");
			Class.forName(driverClass);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("驱动程序注册失败");
		}
	}
	public static Connection getConnection(){
		try {
			Connection conn = DriverManager.getConnection(url, user, password);
			return conn;
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("数据库加载失败");
			throw new RuntimeException(e);
		}
	}
	public static void close(Connection conn){
		if(conn!=null){
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("数据库连接关闭失败");
				throw new RuntimeException(e);
			}
		}
	}
}
