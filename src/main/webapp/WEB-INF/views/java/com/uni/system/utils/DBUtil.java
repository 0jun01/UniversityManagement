package com.uni.system.utils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.InitialContext;
import javax.sql.DataSource;

public class DBUtil {

	private static DataSource dataSource;

	static {
		try {
			InitialContext ctx = new InitialContext();
			dataSource = (DataSource) ctx.lookup("java:comp/env/jdbc/six");
			System.out.println("연결성공");
		} catch (Exception e) {
			System.out.println("DBUtil 초기화 실패");
			e.printStackTrace();
		}
	}

	public static Connection getConnection() throws SQLException {

		return dataSource.getConnection();
	}
	
	
}
