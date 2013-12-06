package br.com.ufpb.pa;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import br.com.ufpb.pa.login.Login;

public class ListUser extends Activity {
	
	Button buttonBack;
	
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
		 
			int contador = 0;
			String[] values = new String[Login.logins.size()];
			
			Set<String> chaves = Login.logins.keySet();  
	        for (Iterator<String> iterator = chaves.iterator(); iterator.hasNext();)  
	        {  
	        	values[contador] = iterator.next();
	        	contador++;
	        }

		    final ArrayList<String> list = new ArrayList<String>();
		    
		    for (int i = 0; i < values.length; ++i) {
		      list.add(values[i]);
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
                 
                 Intent intent = new Intent(ListUser.this, ConfirmPasswd.class);
	        	 startActivity(intent);
                    
                  // Show Alert 
                  /*Toast.makeText(getApplicationContext(),
                    "Position :"+itemPosition+" ListItem : " +itemValue , Toast.LENGTH_LONG)
                    .show();
                   */
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
