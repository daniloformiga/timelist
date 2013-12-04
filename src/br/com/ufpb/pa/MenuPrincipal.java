package br.com.ufpb.pa;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

public class MenuPrincipal extends Activity {

	TextView buttonManagerUsers;
	TextView buttonManagerReports;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.menu_principal);
		
		buttonManagerUsers = (TextView) findViewById(R.id.textManagerUsers);
		buttonManagerReports = (TextView) findViewById(R.id.textManagerReports);
		
		buttonManagerUsers.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				Intent intent = new Intent(MenuPrincipal.this, MenuUsers.class);
        		startActivity(intent);
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
}
