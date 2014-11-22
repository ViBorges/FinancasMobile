package com.dsw.financasmobile.DAO;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class FinancasMobileHelper extends SQLiteOpenHelper{

	public static final int DB_VERSION = 1;
	public static final String DB_NAME = "financas_mobile_DB";

	public FinancasMobileHelper(Context context) {
		super(context, DB_NAME, null, DB_VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL(TableFinancasMobileData.CREATE_USER_SCRIPT);
		db.execSQL(TableFinancasMobileData.CREATE_SPENT_SCRIPT);
		db.execSQL(TableFinancasMobileData.CREATE_RECEIPT_SCRIPT);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		db.execSQL(TableFinancasMobileData.DROP_USER_SCRIPT);
		db.execSQL(TableFinancasMobileData.DROP_SPENT_SCRIPT);
		db.execSQL(TableFinancasMobileData.DROP_RECEIPT_SCRIPT);
		onCreate(db);
	}

}
