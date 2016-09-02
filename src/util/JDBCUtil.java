package util;


import javax.sql.DataSource;

import org.apache.commons.dbutils.QueryRunner;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class JDBCUtil {

	private static DataSource datasourse;
	static{
		
		datasourse = new ComboPooledDataSource();
	}
	
	public static QueryRunner getQueryRunner(){

		return new QueryRunner(datasourse);
	}

}
