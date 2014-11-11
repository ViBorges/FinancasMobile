package com.dsw.financasmobile.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.dsw.financasmobile.model.User;

public class UserDAO {

	private SQLiteDatabase bd;

	private static UserDAO instance;
	private FinancasMobileHelper helper;
	private static final String TAG = "DAOUser";

	private String[] allColumns = { TableFinancasMobileData.COLUMN_NAME,
			TableFinancasMobileData.COLUMN_PASSWORD,
			TableFinancasMobileData.COLUMN_CONFIRMPASSWORD };

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
	
	public void close() throws SQLException {
		bd.close();
	}

	public void insertUserData(User user) throws SQLException {

		if (bd == null) {
			Log.e(TAG, "inserting with null db!! aborting...");
			return;
		}

		ContentValues values = new ContentValues();

		values.put(TableFinancasMobileData.COLUMN_NAME, user.getName());
		values.put(TableFinancasMobileData.COLUMN_PASSWORD, user.getPassword());
		values.put(TableFinancasMobileData.COLUMN_CONFIRMPASSWORD, user.getConfirmPassword());

		bd.insert(TableFinancasMobileData.TABLE_USER_DATA, null, values);
		Log.d("debug", "Aluno cadastrado");
	}
	
	public User readExerciseData(String name) throws SQLException {

		if (bd == null) {
			Log.e(TAG, "reading from null db!! aborting...");
			return null;
		}

		Cursor cursor = bd.query(TableFinancasMobileData.TABLE_USER_DATA, allColumns, TableFinancasMobileData.COLUMN_NAME
				+ "=?", new String[] { name }, null, null, null);

		User user = null;

		if (cursor.moveToFirst())
			user = userToTableFinancasMobileData(cursor);

		cursor.close();
		return user;
	}
	
	private User userToTableFinancasMobileData(Cursor cursor) {
		String name = cursor.getString(cursor.getColumnIndex(TableFinancasMobileData.COLUMN_NAME));
		String password = cursor.getString(cursor.getColumnIndex(TableFinancasMobileData.COLUMN_PASSWORD));
		String confirmPassword = cursor.getString(cursor.getColumnIndex(TableFinancasMobileData.COLUMN_CONFIRMPASSWORD));
		return new User(name, password, confirmPassword);
	}
	
	public void onDestroy() {
		bd.close();
	}
}
