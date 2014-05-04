package br.com.ufpb.pa.provider;

import org.json.JSONException;
import org.json.JSONObject;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.util.Log;
import br.com.ufpb.pa.login.Login;
import br.com.ufpb.pa.menu.MenuUsers;
import br.com.ufpb.pa.persistence.DatabaseHelper;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class UsersProvider extends ContentProvider{
	
	public static final String AUTHORITY = "br.com.ufpb.pa.provider";
	
	private static JSONObject restResponse = new JSONObject();
	
	private static RequestQueue queue;
	
	public static MenuUsers user;
	
	private static final String END = "br.com.ufpb.pa.provider.UsersProvider";
	
	private static final String USUARIOS_GET = "http://classifikdos.herokuapp.com/usuarios/";
	
	public static final Uri CONTENT_URI = Uri.parse("content://"+END+"/"+DatabaseHelper.TABLE_NAME);
	
	SQLiteDatabase db;
	DatabaseHelper dbHelper;
	
	private final static UriMatcher uriMatcher;
	
	static {
		uriMatcher = new UriMatcher(UriMatcher.NO_MATCH);
		uriMatcher.addURI(END, DatabaseHelper.TABLE_NAME, 1);
	}

	@Override
	public String getType(Uri arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Uri insert(Uri uri, ContentValues values) {
		
		Log.d("bbbbb", "bbbbbbb");
		
		JsonObjectRequest postRequest;
		db = dbHelper.getReadableDatabase();

		if (uriMatcher.match(uri) == 1) {

			//db.insert(DatabaseHelper.TABLE_NAME, null, values);

			JSONObject json = new JSONObject();

			try {

				Log.d("b", "b");

				json.put("email", values.get("email"));
				json.put("nome", values.get("nome"));
				json.put("senha", values.get("senha"));

				String url = USUARIOS_GET;
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
		this.dbHelper = new DatabaseHelper(getContext());
		return true;
	}

	@Override
	public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs,
			String sortOrder) {
		
		Cursor cursor;

		cursor = db.query(DatabaseHelper.DATABASE_NAME, projection,
				selection, selectionArgs, null, null, sortOrder);

		cursor.setNotificationUri(getContext().getContentResolver(), uri);
		db = dbHelper.getReadableDatabase();

		return cursor;
	}

	@Override
	public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) {
		try {
			
			String id = values.get("id").toString();
			final String nome = values.get("nome").toString();
			final String email = values.get("email").toString();
			final String senha = values.get("senha").toString();
			final String url = USUARIOS_GET + id;
			
			JsonObjectRequest getRequest = new JsonObjectRequest(
					Request.Method.GET, url, null,
					new Response.Listener<JSONObject>() {
						@Override
						public void onResponse(JSONObject response) {
							try {
								response.put("nome", nome);
								response.put("email", email);
								response.put("senha", senha);
								restResponse = response;
								JsonObjectRequest putRequest = new JsonObjectRequest(
										Request.Method.PUT, url, restResponse,
										new Response.Listener<JSONObject>() {
											@Override
											public void onResponse(
													JSONObject response2) {
												System.out.println(response2
														.toString());
											}
										}, new Response.ErrorListener() {
											@Override
											public void onErrorResponse(
													VolleyError error2) {
												System.out.println(error2);
											}
										});
								
								queue = Volley.newRequestQueue(getContext());
								queue.add(putRequest);
								queue.start();
								
							} catch (JSONException e) {
								e.printStackTrace();
							}
						}
					}, null);
			
			queue = Volley.newRequestQueue(getContext());
			queue.add(getRequest);
			queue.start();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		getContext().getContentResolver().notifyChange(uri, null);
		
		return 0;
	
	}
	
	@Override
	public int delete(Uri arg0, String idRemover, String[] arg2) {
		
		db = dbHelper.getReadableDatabase();
		
		db.delete(DatabaseHelper.TABLE_NAME, DatabaseHelper.ID
				+ "=" + idRemover, null);
		String url = USUARIOS_GET + idRemover;
		
		StringRequest dr = new StringRequest(Request.Method.DELETE, url,
				new Response.Listener<String>() {
					@Override
					public void onResponse(String response) {
					}
				}, new Response.ErrorListener() {
					@Override
					public void onErrorResponse(VolleyError error) {
					}
				});
		
		queue = Volley.newRequestQueue(getContext());
		queue.add(dr);
		queue.start();
		
		return 0;
	}

}
