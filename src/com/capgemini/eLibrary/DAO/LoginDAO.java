package com.capgemini.eLibrary.DAO;

import java.sql.SQLException;

import com.capgemini.eLibrary.exceptions.InvalidUserException;
import com.capgemini.eLibrary.forms.LoginForm;

public interface LoginDAO {

	public boolean checkLogin(LoginForm loginForm) throws SQLException, InvalidUserException;
}
