package br.com.ufpb.pa;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class EditUser extends Activity {
	
	Button buttonEdit;
	EditText textLogin;
	EditText textNewPasswd;
	Spinner permission;
	Button buttonBack;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.edit_user);
		
		buttonEdit = (Button) findViewById(R.id.buttonEditUser);
		buttonBack = (Button) findViewById(R.id.buttonBackEditUser);
		textLogin = (EditText) findViewById(R.id.textEditUserLogin);
		textNewPasswd = (EditText) findViewById(R.id.textNewPasswdEditUser);
		permission = (Spinner) findViewById(R.id.editPermissonUser);
		
		buttonBack.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(EditUser.this, MenuUsers.class);
        		startActivity(intent);
				
			}
		});
		
		
		buttonEdit.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				
				if(textLogin.getText().toString().equalsIgnoreCase("")){
					String text = "Preencha o usuário corretamente!";
					Toast tempMessage = Toast.makeText(getApplicationContext(), text,Toast.LENGTH_SHORT);
					tempMessage.show();
				}else if(textNewPasswd.getText().toString().equalsIgnoreCase("")){
					String text = "Preencha a senha corretamente!";
					Toast tempMessage = Toast.makeText(getApplicationContext(), text,Toast.LENGTH_SHORT);
					tempMessage.show();
				}else{
					String text = "Usuário " + textLogin.getText() + " alterado com Sucesso!";
					Toast tempMessage = Toast.makeText(getApplicationContext(), text,Toast.LENGTH_SHORT);
					tempMessage.show();
					textLogin.setText("");
					textNewPasswd.setText("");
					
				
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
