package br.com.ufpb.pa.menu;

import br.com.ufpb.pa.MainActivity;
import br.com.ufpb.pa.R;
import br.com.ufpb.pa.R.id;
import br.com.ufpb.pa.R.layout;
import br.com.ufpb.pa.R.menu;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MenuPrincipal extends Activity {

	TextView buttonManagerUsers;
	TextView buttonManagerReports;
	Button buttonBack;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.menu_principal);
		
		buttonManagerUsers = (TextView) findViewById(R.id.textManagerUsers);
		buttonManagerReports = (TextView) findViewById(R.id.textManagerReports);
		buttonBack = (Button) findViewById(R.id.buttonBackMenuPrincipal);
		
		buttonBack.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(MenuPrincipal.this, MainActivity.class);
        		startActivity(intent);
				
			}
		});
		
		buttonManagerUsers.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				Intent intent = new Intent(MenuPrincipal.this, MenuUsers.class);
        		startActivity(intent);
			}
		});
		
		buttonManagerReports.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(MenuPrincipal.this, MenuReports.class);
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
