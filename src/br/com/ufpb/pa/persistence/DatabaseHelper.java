package br.com.ufpb.pa.persistence;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import br.com.ufpb.pa.login.Login;

public class DatabaseHelper extends SQLiteOpenHelper {

	public static final String DATABASE_NAME = "timelistOficial.db";
	public static final String TABLE_NAME = "T_Login";
	private static final int DATABASE_VERSION = 1;
	public static final String ID = "_id";
	public static final String LOGIN = "login";
	public static final String PASSWD = "passwd";
	public static final String PERMISSION = "permission";
	
	private static final String DATABASE_CREATE = "create table " + TABLE_NAME
			+ "( " + ID + " integer primary key autoincrement, " + LOGIN
			+ " text not null, " + PASSWD + " text not null, " + PERMISSION
			+ " text not null);";

	public DatabaseHelper(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);

	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		  db.execSQL(DATABASE_CREATE);

	}

	public void insert(Login login) {
		SQLiteDatabase db = getWritableDatabase();
		ContentValues cv = new ContentValues();
		cv.put("login", login.getLogin());
		cv.put("passwd", login.getPasswd());
		cv.put("permission", login.getPermission());
		db.insert("T_Login", null, cv);

		db.close();
	}

	public List<Login> listarLogins() {
		Login login;

		ArrayList<Login> lista = new ArrayList<Login>();

		SQLiteDatabase db = getReadableDatabase();

		Cursor c = db.query("T_Login", null, null, null, null, null, "_id");

		if (c.getCount() > 0) {

			c.moveToFirst();

			while (!c.isAfterLast()) {

				Long id = c.getLong(0);
				String loginBD = c.getString(1);
				String passwdBD = c.getString(2);
				String permissionBD = c.getString(3);

				login = new Login(id, loginBD, passwdBD, permissionBD);
				lista.add(login);
				c.moveToNext();

			}
		}
		c.close();
		db.close();
		return lista;
		
		
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		Log.w(DatabaseHelper.class.getName(),
				"Upgrading database from version " + oldVersion + " to "
						+ newVersion + ", which will destroy all old data");
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
		onCreate(db);

	}

}
