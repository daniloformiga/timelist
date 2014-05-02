package br.com.ufpb.pa.persistence;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class DBAdapter {
	
	private SQLiteDatabase database;
	private DatabaseHelper	 dbHelper;
	private String[] allColumns = { DatabaseHelper.ID, DatabaseHelper.LOGIN, DatabaseHelper.PASSWD,
	DatabaseHelper.PERMISSION};
	
	public DBAdapter(Context context) {          
		dbHelper = new DatabaseHelper(context);
	}

}
