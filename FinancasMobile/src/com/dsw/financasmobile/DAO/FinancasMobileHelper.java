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
	public void onCreate(SQLiteDatabase dataBase) {
		dataBase.execSQL(TableFinancasMobileData.CREATE_USER_SCRIPT);
		dataBase.execSQL(TableFinancasMobileData.DROP_DATA_SCRIPT);
	}

	@Override
	public void onUpgrade(SQLiteDatabase dataBase, int oldVersion, int newVersion) {
		dataBase.execSQL(TableFinancasMobileData.DROP_USER_SCRIPT);
		dataBase.execSQL(TableFinancasMobileData.DROP_DATA_SCRIPT);
		onCreate(dataBase);
	}

}
