package br.com.ufpb.pa;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MenuSeller extends Activity {
	
	TextView buttonAddClient;
	TextView buttonTimeList;
	Button buttonExit;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.menu_seller);
		
		buttonAddClient = (TextView) findViewById(R.id.textCadastro);
		buttonTimeList = (TextView) findViewById(R.id.textSistemaDaVez);
		buttonExit = (Button) findViewById(R.id.buttonExit);
		
		buttonAddClient.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				Intent intent = new Intent(MenuSeller.this, AddClient.class);
        		startActivity(intent);
			}
		});
		
		buttonTimeList.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				Intent intent = new Intent(MenuSeller.this, TimeList.class);
        		startActivity(intent);
				
			}
		});
		
		buttonExit.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(MenuSeller.this, MainActivity.class);
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
