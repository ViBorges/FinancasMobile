package com.dsw.financasmobile.dao;

public class TableFinancasMobileData {
	
	public static final String TABLE_USER_DATA = "user_data";
	
	static final String COLUMN_NAME = "name";
	static final String COLUMN_PASSWORD = "password";
	static final String COLUMN_CONFIRMPASSWORD = "confirm_password";
	
	public static final String CREATE_SCRIPT ="create table " + TABLE_USER_DATA + "(" 
			+ COLUMN_NAME + " STRING PRIMARY KEY" + ", " 
			+ COLUMN_PASSWORD + " STRING" + ", " 
			+ COLUMN_CONFIRMPASSWORD + " STRING" + ");";
			
	public static final String DROP_SCRIPT= "DROP TABLE "+TABLE_USER_DATA+";";
}
