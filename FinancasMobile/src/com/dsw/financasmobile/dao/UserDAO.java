package com.dsw.financasmobile.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.dsw.financasmobile.model.User;

public class UserDAO {
	
	private SQLiteDatabase bd;
	
	private static UserDAO instance;
	private FinancasMobileHelper helper;
	
	public UserDAO(Context context) {
		helper = new FinancasMobileHelper(context);
	}
	
	public static UserDAO getInstance(Context context) {
		if (instance == null)
			instance = new UserDAO(context);
		return instance;
	}
	
	public void open() throws SQLException {
		bd = helper.getWritableDatabase();
	}
	
	public void addUser(User user) {
		
		ContentValues values = new ContentValues();
		
		values.put("name", user.getName());
		values.put("password", user.getPassword());
		
		bd.insert(TableFinancasMobileData.TABLE_USER_DATA, null, values);
		Log.d("debug", "Aluno cadastrado");
	}
	
	public void onDestroy() {
		bd.close();
	}
}
