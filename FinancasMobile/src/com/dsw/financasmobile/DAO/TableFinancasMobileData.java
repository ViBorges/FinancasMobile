package com.dsw.financasmobile.DAO;

public class TableFinancasMobileData {
	
	public static final String TABLE_USER_DATA = "user_data";
	public static final String TABLE_SPENT_DATA = "spent_data";
	public static final String TABLE_RECEIPT_DATA = "receipt_data";
	
	static final String COLUMN_NAME = "name";
	static final String COLUMN_PASSWORD = "password";
	static final String COLUMN_CONFIRMPASSWORD = "confirm_password";
	static final String COLUMN_SPENT_NAME = "spent_name";
	static final String COLUMN_SPENT_DESCRIPTION = "spent_description";
	static final String COLUMN_SPENT_VALUE = "spent_value";
	static final String COLUMN_SPENT_DATE = "spent_date";
	static final String COLUMN_SPENT_CATEGORY = "spent_category";
	static final String COLUMN_RECEIPT_NAME = "receipt_name";
	static final String COLUMN_RECEIPT_DESCRIPTION = "receipt_description";
	static final String COLUMN_RECEIPT_VALUE = "receipt_value";
	static final String COLUMN_RECEIPT_DATE = "receipt_date";
	static final String COLUMN_RECEIPT_CATEGORY = "receipt_category";
	
	public static final String CREATE_USER_SCRIPT ="create table " + TABLE_USER_DATA + "(" 
			+ COLUMN_NAME + " STRING PRIMARY KEY" + ", " 
			+ COLUMN_PASSWORD + " STRING" + ", " 
			+ COLUMN_CONFIRMPASSWORD + " STRING" + ");";
	
	public static final String CREATE_SPENT_SCRIPT ="create table " + TABLE_SPENT_DATA + "(" 
			+ COLUMN_SPENT_NAME + " STRING PRIMARY KEY" + ", " 
			+ COLUMN_SPENT_DESCRIPTION + " STRING" + ", " 
			+ COLUMN_SPENT_VALUE + " FLOAT" + ", "
			+ COLUMN_SPENT_DATE + " STRING" + ", "
			+ COLUMN_SPENT_CATEGORY + " STRING" + ");";
	
	public static final String CREATE_RECEIPT_SCRIPT ="create table " + TABLE_RECEIPT_DATA + "(" 
			+ COLUMN_NAME + " STRING PRIMARY KEY" + ", " 
			+ COLUMN_RECEIPT_DESCRIPTION + " STRING" + ", " 
			+ COLUMN_RECEIPT_VALUE + " FLOAT" + ", "
			+ COLUMN_RECEIPT_DATE + " STRING" + ", "
			+ COLUMN_RECEIPT_CATEGORY + " STRING" + ");";
	
	public static final String DROP_USER_SCRIPT= "DROP TABLE "+TABLE_USER_DATA+";";
	public static final String DROP_SPENT_SCRIPT= "DROP TABLE "+TABLE_SPENT_DATA+";";
	public static final String DROP_RECEIPT_SCRIPT= "DROP TABLE "+TABLE_RECEIPT_DATA+";";
}
