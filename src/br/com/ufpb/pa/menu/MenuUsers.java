package br.com.ufpb.pa.menu;

import br.com.ufpb.pa.MainActivity;
import br.com.ufpb.pa.R;
import br.com.ufpb.pa.R.id;
import br.com.ufpb.pa.R.layout;
import br.com.ufpb.pa.R.menu;
import br.com.ufpb.pa.user.AddUser;
import br.com.ufpb.pa.user.EditUser;
import br.com.ufpb.pa.user.ListUser;
import br.com.ufpb.pa.user.RemoveUser;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MenuUsers extends Activity {
	
	TextView buttonAddUser;
	TextView buttonRemoveUser;
	TextView buttonEditUser;
	TextView buttonListUser;
	Button buttonExit;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.menu_users);
		
		buttonAddUser = (TextView) findViewById(R.id.textAddUser);
		buttonRemoveUser = (TextView) findViewById(R.id.textRemoveUser);
		buttonEditUser = (TextView) findViewById(R.id.textEditUser);
		buttonListUser = (TextView) findViewById(R.id.textListUser);
		buttonExit = (Button) findViewById(R.id.buttonExitMenuUser);
		
		buttonAddUser.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				Intent intent = new Intent(MenuUsers.this, AddUser.class);
        		startActivity(intent);
			}
		});
		
		buttonRemoveUser.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				Intent intent = new Intent(MenuUsers.this, RemoveUser.class);
				startActivity(intent);
				
			}
		});
		
		buttonEditUser.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				Intent intent = new Intent(MenuUsers.this, EditUser.class);
				startActivity(intent);
				
			}
		});
		
		buttonListUser.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				Intent intent = new Intent(MenuUsers.this, ListUser.class);
				startActivity(intent);
				
			}
		});
		
		buttonExit.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				Intent intent = new Intent(MenuUsers.this, MainActivity.class);
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
