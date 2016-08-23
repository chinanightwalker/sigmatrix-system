package com.sigmatrix.sc.utils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class ContensUtil {
	/**
	 * 获取数据库连接
	 * @return
	 */
	public static DBConnectionPool getDBconn(String url,String userName,String pwd){
		String driver = "com.mysql.jdbc.Driver";
		DBConnectionPool dbConnectionPool = null;
		dbConnectionPool = new DBConnectionPool("haha",
				driver, url, userName, pwd, 10);
		return dbConnectionPool;
	}
	public static void  closeDBConn( Statement stmt,Connection connection,DBConnectionPool dBConnectionPool){
		try {
			if(stmt!=null){
				stmt.close();
			}
			if(connection!=null){
				connection.close();
			}
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		if(dBConnectionPool!=null&&connection!=null){
			dBConnectionPool.freeConnection(connection);
		}
		}
	public static void  closeDBConn1( Statement stmt,Connection connection,DBConnectionPool dBConnectionPool,ResultSet rs){
			try {
				if(stmt!=null){
					stmt.close();
				}
				if(connection!=null){
					connection.close();
				}
				if(rs != null)
				{
					rs.close();
				}
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		if(dBConnectionPool!=null&&connection!=null){
			dBConnectionPool.freeConnection(connection);
		}
	}
}
