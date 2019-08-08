package com.revature.dao;

import java.sql.SQLException;

public interface UserDao {

	public abstract boolean verifyPassword(String username, String password) throws SQLException;
	
	
	
}
