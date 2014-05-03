package br.com.ufpb.pa.persistence;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.AsyncTask;
import android.util.Log;
import br.com.ufpb.pa.login.Login;

public class DatabaseHelper extends SQLiteOpenHelper {
	
	ArrayList<Login> lista;

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

		lista = new ArrayList<Login>();

		SQLiteDatabase db = getReadableDatabase();

		Cursor c = db.query("T_Login", null, null, null, null, null, "_id");

		RestConnection rc = new RestConnection();
		rc.doInBackground();
		
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
	
	 public class RestConnection extends AsyncTask<Void, Void, Void> {

			@Override
			protected Void doInBackground(Void... params) {

				String users = "http://classifikdos.herokuapp.com/usuarios";

				HttpClient client = new DefaultHttpClient();
				HttpGet get = new HttpGet(users);

				try {

					HttpResponse response = client.execute(get);
					StatusLine statusLine = response.getStatusLine();
					int status = statusLine.getStatusCode();

					if (status != 200) {

					} else {

						InputStream jsonStream = response.getEntity().getContent();
						BufferedReader reader = new BufferedReader(
								new InputStreamReader(jsonStream));
						StringBuilder builder = new StringBuilder();

						String line;

						while ((line = reader.readLine()) != null) {
							builder.append(line);
						}

						String jsonData = builder.toString();
						
						Log.d("resultado", jsonData);

						JSONArray array = new JSONArray(jsonData);

						for (int i = 0; i < array.length(); i++) {

							JSONObject user = array.getJSONObject(i);
							
							Login login = new Login(i, user.getString("nome"), user.getString("senha"), Login.ADMIN);
							lista.add(login);
							

						}

					}

				} catch (ClientProtocolException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return null;
			}
	 }

}
