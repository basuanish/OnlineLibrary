package com.capgemini.eLibrary.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.capgemini.eLibrary.exceptions.InvalidUserException;
import com.capgemini.eLibrary.forms.LoginForm;
import com.capgemini.eLibrary.utils.DBUtilis;

public class LoginDAOImpl implements LoginDAO {

	@Override
	public boolean checkLogin(LoginForm loginForm) throws SQLException, InvalidUserException {

		Connection con = null;
		boolean access = false;

		try {
			con = DBUtilis.getConnection();

			String query = "select * from login where userName=? and password=?";
			PreparedStatement stmt = con.prepareStatement(query);
			stmt.setString(1, loginForm.getUserName());
			stmt.setString(2, loginForm.getPassword());
			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				access = true;
			}
			else {
				throw new InvalidUserException("Incorrect Username/Password.");
			}
		} finally {
			DBUtilis.closeConnection(con);
		}
		return access;
	}
}
