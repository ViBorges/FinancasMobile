package com.dsw.financasmobile.DAO;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.dsw.financasmobile.model.Spent;

public class SpentDAO {

	private SQLiteDatabase dataBase;

	private static SpentDAO instance;
	private FinancasMobileHelper helper;
	private static final String TAG = "DAOSpent";

	private String[] allColumns = { TableFinancasMobileData.COLUMN_SPENT_NAME,
			TableFinancasMobileData.COLUMN_SPENT_DESCRIPTION,
			TableFinancasMobileData.COLUMN_SPENT_VALUE,
			TableFinancasMobileData.COLUMN_SPENT_DATE,
			TableFinancasMobileData.COLUMN_SPENT_CATEGORY };

	public SpentDAO(Context context) {
		helper = new FinancasMobileHelper(context);
	}
	
	public static SpentDAO getInstance(Context context) {
		if (instance == null)
			instance = new SpentDAO(context);
		return instance;
	}

	public void open() throws SQLException {
		dataBase = helper.getWritableDatabase();
	}
	
	public void close() throws SQLException {
		dataBase.close();
	}

	public void insertSpentData(Spent spent) throws SQLException {

		if (dataBase == null) {
			Log.e(TAG, "inserting with null db!! aborting...");
			return;
		}

		ContentValues values = new ContentValues();

		
		values.put(TableFinancasMobileData.COLUMN_SPENT_NAME, spent.getName());
		values.put(TableFinancasMobileData.COLUMN_SPENT_DESCRIPTION, spent.getDescription());
		values.put(TableFinancasMobileData.COLUMN_SPENT_VALUE, spent.getValue());
		values.put(TableFinancasMobileData.COLUMN_SPENT_DATE, spent.getSpentDate());
		values.put(TableFinancasMobileData.COLUMN_SPENT_CATEGORY, spent.getCategory());

		dataBase.insert(TableFinancasMobileData.TABLE_SPENT_DATA, null, values);
	}
	
	public List<Spent> readAllSpents() {

		List<Spent> spentDataList = new ArrayList<Spent>();

		if (dataBase == null) {
			Log.e(TAG, "reading from null db!! aborting...");
			return null;
		}

		Cursor cursor = dataBase.query(TableFinancasMobileData.TABLE_SPENT_DATA, allColumns, null, null, null, null, null);

		if (cursor.moveToFirst()) {
			Spent spentData = cursorToSpentData(cursor);
			spentDataList.add(spentData);

			while (cursor.moveToNext()) {
				spentData = cursorToSpentData(cursor);
				spentDataList.add(spentData);
			}
		}

		return spentDataList;
	}
	
	private Spent cursorToSpentData(Cursor cursor) {

		String name= cursor.getString(cursor.getColumnIndex(TableFinancasMobileData.COLUMN_SPENT_NAME));
		String description = cursor.getString(cursor.getColumnIndex(TableFinancasMobileData.COLUMN_SPENT_DESCRIPTION));
		float value = cursor.getFloat(cursor.getColumnIndex(TableFinancasMobileData.COLUMN_SPENT_VALUE));
		String spentDate = cursor.getString(cursor.getColumnIndex(TableFinancasMobileData.COLUMN_SPENT_DATE));
		String category = cursor.getString(cursor.getColumnIndex(TableFinancasMobileData.COLUMN_SPENT_CATEGORY));
		return new Spent(name, description, value, spentDate, category);

	}
}
