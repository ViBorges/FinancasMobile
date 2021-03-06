package com.dsw.financasmobile.model;

public class User {

	private String name;
	private String password;
	private String confirmPassword;
	
	public User() {

	}
	
	public User(String name, String password, String confirmPassword) {
		this.name = name;
		this.password = password;
		this.confirmPassword = confirmPassword;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", password=" + password
				+ ", confirmPassword=" + confirmPassword + "]";
	}
}
