
//package com.capgemini.eLibrary.utils;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.SQLException;
//
//public class DBUtilities {
//
//	public static Connection getConnection() {
//		Connection con = null;
//
//		try {
//			Class.forName("com.mysql.cj.jdbc.Driver");
//			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/onlinelibrary", "root", "password");
//		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//
//		return con;
//
//	}
//
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

//}

//}


//	}
//}

