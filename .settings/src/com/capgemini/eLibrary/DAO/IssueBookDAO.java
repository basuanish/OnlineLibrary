package com.capgemini.eLibrary.DAO;

import java.sql.SQLException;

import com.capgemini.eLibrary.dto.BookEntity;
import com.capgemini.eLibrary.exceptions.InvalidBookException;
import com.capgemini.eLibrary.forms.IssueBookForm;

public interface IssueBookDAO {

	public BookEntity issueBook(IssueBookForm form) throws SQLException, InvalidBookException;
}
