package com.capgemini.eLibrary.DAO;

import java.sql.SQLException;

import com.capgemini.eLibrary.exceptions.InvalidUserException;
import com.capgemini.eLibrary.forms.LoginForm;
import com.capgemini.eLibrary.forms.MemberLoginForm;

public interface MemberLoginDAO {

	public boolean checkLogin(MemberLoginForm loginForm) throws SQLException, InvalidUserException;
}
