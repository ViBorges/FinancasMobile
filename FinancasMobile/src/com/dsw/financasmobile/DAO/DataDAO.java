package com.dsw.financasmobile.DAO;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.dsw.financasmobile.model.Data;

public class DataDAO {

	private SQLiteDatabase dataBase;

	private static DataDAO instance;
	private FinancasMobileHelper helper;
	private static final String TAG = "DAOReceipt";

	private String[] allColumns = { TableFinancasMobileData.COLUMN_DATA_NAME,
			TableFinancasMobileData.COLUMN_DATA_DESCRIPTION,
			TableFinancasMobileData.COLUMN_DATA_VALUE,
			TableFinancasMobileData.COLUMN_DATA_YEAR,
			TableFinancasMobileData.COLUMN_DATA_MONTH,
			TableFinancasMobileData.COLUMN_DATA_CATEGORY };
	
	public DataDAO(Context context) {
		helper = new FinancasMobileHelper(context);
	}
	
	public static DataDAO getInstance(Context context) {
		if (instance == null)
			instance = new DataDAO(context);
		return instance;
	}

	public void open() throws SQLException {
		dataBase = helper.getWritableDatabase();
	}
	
	public void close() throws SQLException {
		dataBase.close();
	}

	public void insertReceiptData(Data data) throws SQLException {

		if (dataBase == null) {
			Log.e(TAG, "inserting with null db!! aborting...");
			return;
		}

		ContentValues values = new ContentValues();

		values.put(TableFinancasMobileData.COLUMN_DATA_NAME, data.getName());
		values.put(TableFinancasMobileData.COLUMN_DATA_DESCRIPTION, data.getDescription());
		values.put(TableFinancasMobileData.COLUMN_DATA_VALUE, data.getValue());
		values.put(TableFinancasMobileData.COLUMN_DATA_YEAR, data.getYear());
		values.put(TableFinancasMobileData.COLUMN_DATA_MONTH, data.getMonth());
		values.put(TableFinancasMobileData.COLUMN_DATA_CATEGORY, data.getCategory());

		dataBase.insert(TableFinancasMobileData.TABLE_DATA, null, values);
		
		Log.d("debugg","Ano Cadastrado");
	}
	
	public List<Data> readAllReceipts() {

		Log.d("debugg","Entrou no metodo de Leitura");
		List<Data> dataList = new ArrayList<Data>();

		if (dataBase == null) {
			Log.e(TAG, "reading from null db!! aborting...");
			return null;
		}

		Cursor cursor = dataBase.query(TableFinancasMobileData.TABLE_DATA, allColumns, null, null, null, null, null);

		if (cursor.moveToFirst()) {
			Data data = cursorToDataYear(cursor);
			dataList.add(data);

			while (cursor.moveToNext()) {
				data = cursorToDataYear(cursor);
				dataList.add(data);
			}
		}

		Log.d("debugg","Resultado da Leitura: " + dataList);
		return dataList;
	}
	
	public List<Data> readAllDataYears() {

		List<Data> dataYearList = new ArrayList<Data>();

		if (dataBase == null) {
			Log.e(TAG, "reading from null db!! aborting...");
			return null;
		}

		Cursor cursor = dataBase.query(TableFinancasMobileData.TABLE_DATA, allColumns, null, null, null, null, null);

		while(cursor.moveToNext()) {
			Data data = new Data();
			data.setYear(cursor.getString(0));
			
			dataYearList.add(data);
		}

		return dataYearList;
	}
	
	private Data cursorToDataYear(Cursor cursor) {

		String name= cursor.getString(cursor.getColumnIndex(TableFinancasMobileData.COLUMN_DATA_NAME));
		String description = cursor.getString(cursor.getColumnIndex(TableFinancasMobileData.COLUMN_DATA_DESCRIPTION));
		float value = cursor.getFloat(cursor.getColumnIndex(TableFinancasMobileData.COLUMN_DATA_VALUE));
		String year = cursor.getString(cursor.getColumnIndex(TableFinancasMobileData.COLUMN_DATA_YEAR));
		String month = cursor.getString(cursor.getColumnIndex(TableFinancasMobileData.COLUMN_DATA_MONTH));
		String category = cursor.getString(cursor.getColumnIndex(TableFinancasMobileData.COLUMN_DATA_CATEGORY));
		return new Data(name, description, value, year, month, category);

	}
}
