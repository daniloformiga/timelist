package br.com.ufpb.pa;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import br.com.ufpb.pa.login.Login;
import br.com.ufpb.pa.login.LoginController;
import br.com.ufpb.pa.menu.MenuPrincipal;
import br.com.ufpb.pa.menu.MenuSeller;

public class MainActivity extends Activity {

	LoginController login = new LoginController();
	EditText loginText;
	EditText passwdText;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);	

		loginText = (EditText) findViewById(R.id.login);
		passwdText = (EditText) findViewById(R.id.password);
		Button btnEntrar = (Button) findViewById(R.id.buttonEnter);
		
		btnEntrar.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				
				if(login.verify(loginText.getText().toString(), passwdText.getText().toString())){
					if(login.verifyPermission(loginText.getText().toString()).equalsIgnoreCase(Login.ADMIN)){
						Intent intent = new Intent(MainActivity.this, MenuPrincipal.class);
		        		startActivity(intent);
					}
					else if(login.verifyPermission(loginText.getText().toString()).equalsIgnoreCase(Login.SELLER)){
						Intent intent = new Intent(MainActivity.this, MenuSeller.class);
		        		startActivity(intent);
					}else{
						String text = "Ocorreu um erro nas permissões!";
						Toast tempMessage = Toast.makeText(getApplicationContext(), text,Toast.LENGTH_SHORT);
						tempMessage.show();
						loginText.setText("");
						passwdText.setText("");
					}
					
				}else{
					String text = "Login e/ou Senha inválidos";
					Toast tempMessage = Toast.makeText(getApplicationContext(), text,Toast.LENGTH_SHORT);
					tempMessage.show();
					loginText.setText("");
					passwdText.setText("");
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
