package com.capgemini.eLibrary.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import com.capgemini.eLibrary.dto.StaffMember;

public class StaffDAOImpl implements StaffDAO{

	@Override
	public String createStaff(StaffMember staffMember, DataSource dataSource) {
	
        Connection connection=null;
        PreparedStatement statement=null;
		try {
			connection = dataSource.getConnection();
			statement = connection.prepareStatement("");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				statement.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
        
		return null;
	}

	
}
