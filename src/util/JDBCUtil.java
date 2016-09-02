package util;


import javax.sql.DataSource;

import org.apache.commons.dbutils.QueryRunner;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class JDBCUtil {

	
	public static QueryRunner getQueryRunner(String str){
		DataSource datasourse = new ComboPooledDataSource(str);

		return new QueryRunner(datasourse);
	}

}
