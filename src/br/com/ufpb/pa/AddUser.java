package br.com.ufpb.pa;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.textservice.TextServicesManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import br.com.ufpb.pa.login.Login;

public class AddUser extends Activity {
	
	Button buttonSave;
	EditText textLogin;
	EditText textPasswd;
	Spinner permission;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.add_user);
		
		buttonSave = (Button) findViewById(R.id.buttonSaveUser);
		textLogin = (EditText) findViewById(R.id.textLogin);
		textPasswd = (EditText) findViewById(R.id.textPasswd);
		permission = (Spinner) findViewById(R.id.spinner1);
		
		
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
					
					Login.logins.put(textLogin.getText().toString(), textPasswd.getText().toString());
					
					if(permission.getSelectedItem().toString().equalsIgnoreCase("admin")){
						Login.permissions.put(textLogin.getText().toString(), Login.ADMIN);
					}
					else if(permission.getSelectedItem().toString().equalsIgnoreCase("vendedor")){
						Login.permissions.put(textLogin.getText().toString(), Login.SELLER);
					}
					
					textLogin.setText("");
					textPasswd.setText("");
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
