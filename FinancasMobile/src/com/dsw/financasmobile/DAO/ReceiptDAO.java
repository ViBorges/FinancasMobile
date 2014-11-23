package com.dsw.financasmobile.DAO;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.dsw.financasmobile.model.Receipt;

public class ReceiptDAO {

	private SQLiteDatabase dataBase;

	private static SpentDAO instance;
	private FinancasMobileHelper helper;
	private static final String TAG = "DAOReceipt";

	private String[] allColumns = { TableFinancasMobileData.COLUMN_RECEIPT_NAME,
			TableFinancasMobileData.COLUMN_RECEIPT_DESCRIPTION,
			TableFinancasMobileData.COLUMN_RECEIPT_VALUE,
			TableFinancasMobileData.COLUMN_RECEIPT_DATE,
			TableFinancasMobileData.COLUMN_RECEIPT_CATEGORY };

	public ReceiptDAO(Context context) {
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

	public void insertSpentData(Receipt receipt) throws SQLException {

		if (dataBase == null) {
			Log.e(TAG, "inserting with null db!! aborting...");
			return;
		}

		ContentValues values = new ContentValues();

		values.put(TableFinancasMobileData.COLUMN_RECEIPT_NAME, receipt.getName());
		values.put(TableFinancasMobileData.COLUMN_RECEIPT_DESCRIPTION, receipt.getDescription());
		values.put(TableFinancasMobileData.COLUMN_RECEIPT_VALUE, receipt.getValue());
		values.put(TableFinancasMobileData.COLUMN_RECEIPT_DATE, receipt.getReceiptDate());
		values.put(TableFinancasMobileData.COLUMN_RECEIPT_CATEGORY, receipt.getCategory());

		dataBase.insert(TableFinancasMobileData.TABLE_RECEIPT_DATA, null, values);
	}
	
	public List<Receipt> readAllReceipts() {

		List<Receipt> receiptDataList = new ArrayList<Receipt>();

		if (dataBase == null) {
			Log.e(TAG, "reading from null db!! aborting...");
			return null;
		}

		Cursor cursor = dataBase.query(TableFinancasMobileData.TABLE_RECEIPT_DATA, allColumns, null, null, null, null, null);

		if (cursor.moveToFirst()) {
			Receipt receiptData = cursorToReceiptData(cursor);
			receiptDataList.add(receiptData);

			while (cursor.moveToNext()) {
				receiptData = cursorToReceiptData(cursor);
				receiptDataList.add(receiptData);
			}
		}

		return receiptDataList;
	}
	
	private Receipt cursorToReceiptData(Cursor cursor) {

		String name= cursor.getString(cursor.getColumnIndex(TableFinancasMobileData.COLUMN_RECEIPT_NAME));
		String description = cursor.getString(cursor.getColumnIndex(TableFinancasMobileData.COLUMN_RECEIPT_DESCRIPTION));
		float value = cursor.getFloat(cursor.getColumnIndex(TableFinancasMobileData.COLUMN_RECEIPT_VALUE));
		String receiptDate = cursor.getString(cursor.getColumnIndex(TableFinancasMobileData.COLUMN_RECEIPT_DATE));
		String category = cursor.getString(cursor.getColumnIndex(TableFinancasMobileData.COLUMN_RECEIPT_CATEGORY));
		return new Receipt(name, description, value, receiptDate, category);

	}
}
