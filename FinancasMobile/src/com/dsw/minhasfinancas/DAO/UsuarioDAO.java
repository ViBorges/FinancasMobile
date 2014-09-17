package com.dsw.minhasfinancas.DAO;

import com.dsw.minhasfinancas.MODEL.Usuario;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class UsuarioDAO extends SQLiteOpenHelper {

	private static int VERSION = 1;
	private static String USUARIO_TABELA = "Usuario";
	private static String[] COLS = { "id", "nome", "senha" };

	public UsuarioDAO(Context context) {
		super(context, USUARIO_TABELA, null, VERSION);
	}

	public void adicionar(Usuario usuario) {
		ContentValues values = new ContentValues();
		values.put("nome", usuario.getNome());
		values.put("senha", usuario.getSenha());
		getWritableDatabase().insert(USUARIO_TABELA, null, values);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {

		String sql = "CREATE TABLE " + USUARIO_TABELA
				+ "(id INTEGER PRIMARY KEY," + "nome TEXT UNIQUE NOT NULL,"
				+ "senha TEXT" + ");";
		db.execSQL(sql);

		Cursor cursor = getWritableDatabase().query(USUARIO_TABELA, COLS, null,
				null, null, null, null);
		cursor.moveToFirst();
		
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		db.execSQL("DROP TABLE IF EXISTS " + UsuarioDAO.USUARIO_TABELA);
		this.onCreate(db);

	}

}
