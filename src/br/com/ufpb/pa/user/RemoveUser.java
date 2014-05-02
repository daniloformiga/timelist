package br.com.ufpb.pa.user;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import br.com.ufpb.pa.R;
import br.com.ufpb.pa.login.LoginController;
import br.com.ufpb.pa.menu.MenuUsers;

public class RemoveUser extends Activity {
	
	Button buttonRemove;
	EditText textLogin;
	Button buttonBack;
	LoginController loginController = new LoginController();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.remove_user);
		
		buttonRemove = (Button) findViewById(R.id.buttonRemoveUser);
		buttonBack = (Button) findViewById(R.id.buttonBackRemoveUser);
		textLogin = (EditText) findViewById(R.id.textLoginRemoveUser);
			
		buttonBack.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(RemoveUser.this, MenuUsers.class);
        		startActivity(intent);
				
			}
		});
		
		
		buttonRemove.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				
				if(textLogin.getText().toString().equalsIgnoreCase("")){
					String text = "Preencha o usuário corretamente!";
					Toast tempMessage = Toast.makeText(getApplicationContext(), text,Toast.LENGTH_SHORT);
					tempMessage.show();
					
				}else{
					loginController.removeLogin(textLogin.getText().toString());
					String text = "Usuário " + textLogin.getText().toString() + " removido com Sucesso!";
					Toast tempMessage = Toast.makeText(getApplicationContext(), text,Toast.LENGTH_SHORT);
					tempMessage.show();
					textLogin.setText("");
				
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
