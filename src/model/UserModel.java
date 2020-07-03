package model;

import java.sql.ResultSet;

import Entities.Customers;

public class UserModel {
	
	private String userName = null;
	private String password = null;
	private ResultSet result;
	private Customers user;
	
	public Customers getUser() {
		return user;
	}

	public void setUser(Customers user) {
		this.user = user;
	}

	public ResultSet getResult() {
		return result;
	}

	public void setResult(ResultSet result) {
		this.result = result;
	}

	public String getUserName() {
		return userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
}