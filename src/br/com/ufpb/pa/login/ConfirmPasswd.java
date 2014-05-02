package br.com.ufpb.pa.login;

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
import br.com.ufpb.pa.TimeList;
import br.com.ufpb.pa.seller.SellerDecision;

public class ConfirmPasswd extends Activity {
	
	Button buttonEnter;
	EditText textPasswd;
	Button buttonBack;
	LoginController loginController = new LoginController();
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.confirm_passwd);
		
		buttonEnter = (Button) findViewById(R.id.buttonConfirm);
		buttonBack = (Button) findViewById(R.id.buttonBack);
		textPasswd = (EditText) findViewById(R.id.textPasswd);
		
		buttonBack.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(ConfirmPasswd.this, TimeList.class);
        		startActivity(intent);
				
			}
		});
		
		
		buttonEnter.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				
				if(textPasswd.getText().toString().equalsIgnoreCase("")){
					String text = "Preencha a senha corretamente!";
					Toast tempMessage = Toast.makeText(getApplicationContext(), text,Toast.LENGTH_SHORT);
					tempMessage.show();
				}else{
					Intent intent = new Intent(ConfirmPasswd.this, SellerDecision.class);
					startActivity(intent);
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
