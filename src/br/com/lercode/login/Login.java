package br.com.lercode.login;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import br.com.lercode.Lercode;
import br.com.lercode.R;

public class Login extends Activity{
	
	EditText loginText;
	EditText passwdText;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login);

	Button btnEntrar = (Button) findViewById(R.id.button1);
	loginText = (EditText) findViewById(R.id.editText1);
	passwdText = (EditText) findViewById(R.id.editText2);
	
	btnEntrar.setOnClickListener(new OnClickListener() {

		@Override
		public void onClick(View v) {
			
			if(loginText.getText().toString().equalsIgnoreCase("admin") && passwdText.getText().toString().equalsIgnoreCase("admin")){
				Intent intent = new Intent(Login.this, Lercode.class);
	        	startActivity(intent);
				
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
	public void onBackPressed() {
		// TODO Auto-generated method stub
		
	}	
	
	
	

}
