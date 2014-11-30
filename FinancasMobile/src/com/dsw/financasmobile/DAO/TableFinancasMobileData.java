package com.dsw.financasmobile.DAO;

public class TableFinancasMobileData {
	
	public static final String TABLE_USER_DATA = "user_data";
	public static final String TABLE_DATA = "data";
	
	static final String COLUMN_NAME = "name";
	static final String COLUMN_PASSWORD = "password";
	static final String COLUMN_CONFIRMPASSWORD = "confirm_password";
	static final String COLUMN_DATA_NAME = "data_name";
	static final String COLUMN_DATA_DESCRIPTION = "data_description";
	static final String COLUMN_DATA_VALUE = "data_value";
	static final String COLUMN_DATA_YEAR = "data_year";
	static final String COLUMN_DATA_MONTH = "data_month";
	static final String COLUMN_DATA_CATEGORY = "data_category";
	
	public static final String CREATE_USER_SCRIPT ="create table " + TABLE_USER_DATA + "(" 
			+ COLUMN_NAME + " STRING PRIMARY KEY" + ", " 
			+ COLUMN_PASSWORD + " STRING" + ", " 
			+ COLUMN_CONFIRMPASSWORD + " STRING" + ");";
	
	public static final String CREATE_DATA_SCRIPT ="create table " + TABLE_DATA + "(" 
			+ COLUMN_DATA_NAME + " STRING PRIMARY KEY" + ", " 
			+ COLUMN_DATA_DESCRIPTION + " STRING" + ", " 
			+ COLUMN_DATA_VALUE + " FLOAT" + ", "
			+ COLUMN_DATA_YEAR + " STRING" + ", "
			+ COLUMN_DATA_MONTH + " STRING" + ", "
			+ COLUMN_DATA_CATEGORY + " STRING" + ");";
	
	public static final String DROP_USER_SCRIPT= "DROP TABLE "+TABLE_USER_DATA+";";
	public static final String DROP_DATA_SCRIPT= "DROP TABLE "+TABLE_DATA+";";
}