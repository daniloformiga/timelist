package br.com.ufpb.pa.user;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import br.com.ufpb.pa.R;
import br.com.ufpb.pa.login.Login;
import br.com.ufpb.pa.login.LoginController;
import br.com.ufpb.pa.menu.MenuUsers;
import br.com.ufpb.pa.persistence.DatabaseHelper;
import br.com.ufpb.pa.provider.UsersProvider;

public class AddUser extends Activity {
	
	LoginController login = new LoginController();
	
	Button buttonSave;
	EditText textLogin;
	EditText textPasswd;
	Spinner permission;
	Button buttonBack;
	DatabaseHelper db = new DatabaseHelper(this);
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.add_user);
		
		buttonSave = (Button) findViewById(R.id.buttonSaveUser);
		buttonBack = (Button) findViewById(R.id.buttonBack);
		textLogin = (EditText) findViewById(R.id.textLogin);
		textPasswd = (EditText) findViewById(R.id.textPasswd);
		permission = (Spinner) findViewById(R.id.spinner1);
		
		buttonBack.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(AddUser.this, MenuUsers.class);
        		startActivity(intent);
				
			}
		});
		
		
		buttonSave.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				
				if(textLogin.getText().toString().equalsIgnoreCase("")){
					String text = "Preencha o usuário corretamente!";
					Toast tempMessage = Toast.makeText(getApplicationContext(), text,Toast.LENGTH_SHORT);
					tempMessage.show();
				}else if(textPasswd.getText().toString().equalsIgnoreCase("")){
					String text = "Preencha a senha corretamente!";
					Toast tempMessage = Toast.makeText(getApplicationContext(), text,Toast.LENGTH_SHORT);
					tempMessage.show();
				}else{
					
					if(permission.getSelectedItem().toString().equalsIgnoreCase("admin")){
						Login loginInsert = new Login(0,textLogin.getText().toString(), textPasswd.getText().toString(), Login.ADMIN);
						db.insert(loginInsert);
						//login.addLogin(textLogin.getText().toString(), textPasswd.getText().toString(), Login.ADMIN);
					}
					else if(permission.getSelectedItem().toString().equalsIgnoreCase("vendedor")){
						Login loginInsert = new Login(0,textLogin.getText().toString(), textPasswd.getText().toString(), Login.SELLER);
						db.insert(loginInsert);
						//login.addLogin(textLogin.getText().toString(), textPasswd.getText().toString(), Login.SELLER);
					}
					
					textLogin.setText("");
					textPasswd.setText("");
					Log.d("a", "a");
			
					//ContentResolver content = getContentResolver();
					//content.insert(UsersProvider.CONTENT_URI, null);
					
					String text = "Usuário cadastrado com Sucesso!";
					Toast tempMessage = Toast.makeText(getApplicationContext(), text,Toast.LENGTH_SHORT);
					tempMessage.show();
				
				}
				
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
