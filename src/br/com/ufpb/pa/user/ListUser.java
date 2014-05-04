package br.com.ufpb.pa.user;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
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

import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;
import br.com.ufpb.pa.R;
import br.com.ufpb.pa.login.Login;
import br.com.ufpb.pa.login.LoginController;
import br.com.ufpb.pa.menu.MenuUsers;
import br.com.ufpb.pa.persistence.DatabaseHelper;

public class ListUser extends Activity {
	
	Button buttonBack;
	LoginController loginController = new LoginController();
	DatabaseHelper db = new DatabaseHelper(this);
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.list_user);
		
			buttonBack = (Button) findViewById(R.id.buttonBackListUser);
			
			buttonBack.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View arg0) {
					Intent intent = new Intent(ListUser.this, MenuUsers.class);
	        		startActivity(intent);
					
				}
			});
		
			final ListView listView = (ListView) findViewById(R.id.listUser);

		    final ArrayList<String> list = new ArrayList<String>();
		    
		    for(Login result : db.listarLogins()){
		    	list.add("Nome: " + result.getLogin() + " | Senha: " + result.getPasswd());
		    }
		    
		    
		    final StableArrayAdapter adapter = new StableArrayAdapter(this, android.R.layout.simple_list_item_1, list);
		    listView.setAdapter(adapter);
		    
		    listView.setOnItemClickListener(new OnItemClickListener() {
		    	 
                @Override
                public void onItemClick(AdapterView<?> parent, View view,
                   int position, long id) {
                  
                 // ListView Clicked item index
                 int itemPosition = position;
                 
                 // ListView Clicked item value
                 String itemValue = (String) listView.getItemAtPosition(position);
                    
                  // Show Alert 
                  Toast.makeText(getApplicationContext(),
                    "Position :"+itemPosition+" ListItem : " +itemValue , Toast.LENGTH_LONG)
                    .show();
                   
                }
  
           }); 
      }

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	 private class StableArrayAdapter extends ArrayAdapter<String> {

		    HashMap<String, Integer> mIdMap = new HashMap<String, Integer>();

		    public StableArrayAdapter(Context context, int textViewResourceId,
		        List<String> objects) {
		      super(context, textViewResourceId, objects);
		      for (int i = 0; i < objects.size(); ++i) {
		        mIdMap.put(objects.get(i), i);
		      }
		    }
	 }
	 
	
}
