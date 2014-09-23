package com.dsw.minhasfinancas.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.dsw.minhasfinancas.model.User;

public class UserDAO extends SQLiteOpenHelper {

	private static int VERSION = 1;
	private static String USER_TABLE = "User";


	public UserDAO(Context context) {
		super(context, USER_TABLE, null, VERSION);
	}

	public void add(User user) {
		ContentValues values = new ContentValues();
		values.put("name", user.getNome());
		values.put("password", user.getSenha());
		getWritableDatabase().insert(USER_TABLE, null, values);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {

		String sql = "CREATE TABLE " + USER_TABLE
				+ "(id INTEGER PRIMARY KEY," + "name TEXT UNIQUE NOT NULL,"
				+ "password TEXT" + ");";
		db.execSQL(sql);

	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		db.execSQL("DROP TABLE IF EXISTS " + UserDAO.USER_TABLE);
		this.onCreate(db);

	}

}
