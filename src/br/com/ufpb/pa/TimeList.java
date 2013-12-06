package br.com.ufpb.pa;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

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

public class TimeList extends Activity {
	
	Button buttonBack;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.time_list);
		
			buttonBack = (Button) findViewById(R.id.buttonBackTimeList);
			
			buttonBack.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View arg0) {
					Intent intent = new Intent(TimeList.this, MenuSeller.class);
	        		startActivity(intent);
					
				}
			});
		
			final ListView listView = (ListView) findViewById(R.id.listaDaVez);
		 
		    String[] values = new String[] { "Maria                     0:40h", "João                       0:30h",
		    		"Carlos                    0:20h", "Danilo                    0:15h", "Marcos                   0:10h", "Joana                      0:05h" };

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
                 
                 Intent intent = new Intent(TimeList.this, ConfirmPasswd.class);
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
