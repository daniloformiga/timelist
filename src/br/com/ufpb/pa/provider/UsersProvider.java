package br.com.ufpb.pa.provider;

import org.json.JSONException;
import org.json.JSONObject;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.text.GetChars;
import android.util.Log;
import br.com.ufpb.pa.menu.MenuUsers;
import br.com.ufpb.pa.persistence.DatabaseHelper;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

public class UsersProvider extends ContentProvider{
	
	private static RequestQueue queue;
	
	public static MenuUsers user;
	
	private static final String END = "br.com.ufpb.pa.provider.UsersProvider";
	public static final Uri CONTENT_URI = Uri.parse("content://"+END+"/"+DatabaseHelper.TABLE_NAME);
	
	SQLiteDatabase db;
	DatabaseHelper dbHelper;
	
	private final static UriMatcher uriMatcher;
	
	static {
		uriMatcher = new UriMatcher(UriMatcher.NO_MATCH);
		uriMatcher.addURI(END, DatabaseHelper.TABLE_NAME, 1);
	}

	@Override
	public int delete(Uri arg0, String arg1, String[] arg2) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getType(Uri arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Uri insert(Uri uri, ContentValues values) {
		
		JsonObjectRequest postRequest;
		db = dbHelper.getReadableDatabase();

		if (uriMatcher.match(uri) == 1) {

			db.insert(DatabaseHelper.TABLE_NAME, null, values);

			// String j =
			// "{\"cnpj\":\"12345678901234\",\"nome\":\"Sinval\",\"usuario\":{\"email\":\"sinval.vieira@dce.ufpb.br\",\"id\":1,\"senha\":\"123456\",\"telefone\":\"88667755\",\"version\":0}}";

			JSONObject json = new JSONObject();

			try {

				JSONObject user = new JSONObject("");


				json.put("nome", values.get("name"));
				json.put("cnpj", values.get("cnpj"));
				json.put("usuario", user);

				System.out.println(json.toString());

				String url = "http://54.187.110.85:8080/iConta/clientes";
				postRequest = new JsonObjectRequest(Request.Method.POST, url,
						json, new Response.Listener<JSONObject>() {
							@Override
							public void onResponse(JSONObject response) {
								System.out.println(response);
							}
						}, new Response.ErrorListener() {
							@Override
							public void onErrorResponse(VolleyError error) {
								System.out.println(error);

							}
						});

				queue = Volley.newRequestQueue(getContext());
				queue.add(postRequest);
				queue.start();

			} catch (JSONException e) {
				e.printStackTrace();
			}

		}

		db.close();
		getContext().getContentResolver().notifyChange(uri, null);

		return null;
		
	}

	@Override
	public boolean onCreate() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Cursor query(Uri uri, String[] arg1, String arg2, String[] arg3,
			String arg4) {
		
		Cursor cursor;

		cursor = db.query(DatabaseHelper.DATABASE_NAME, arg1,
				arg2, arg3, null, null, arg4);

		cursor.setNotificationUri(getContext().getContentResolver(), uri);
		db = dbHelper.getReadableDatabase();

		return cursor;
	}

	@Override
	public int update(Uri arg0, ContentValues arg1, String arg2, String[] arg3) {
		// TODO Auto-generated method stub
		return 0;
	}

}
