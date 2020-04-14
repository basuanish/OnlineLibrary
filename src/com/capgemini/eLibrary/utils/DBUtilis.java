package com.capgemini.eLibrary.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DBUtilis {

	private static DBUtilis instance;
	private Connection connection;
	
	
	
	private DBUtilis(){
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://remotemysql.com:3306/gagKxXbdhO", "gagKxXbdhO", "QWxMivwD9p");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public Connection getConnection() {
		

		return connection;

	}
	
	public static DBUtilis getInstance() throws SQLException {
        if (instance == null) {
            instance = new DBUtilis();
        } else if (instance.getConnection().isClosed()) {
            instance = new DBUtilis();
        }

        return instance;
    }

//	public static void closeConnection(Connection con) {
//		if (con != null) {
//			try {
//				con.close();
//			} catch (Exception e) {
//				System.out.println("closing connection error: "+e.getMessage());
//			}
//		}
//	}
//
//	public static void closePreparedStatement(PreparedStatement ps) {
//		if (ps != null) {
//			try {
//				ps.close();
//			} catch (Exception e) {
//				System.out.println("closing prepStmt error: "+e.getMessage());
//			}
//		}
//	}
	
}