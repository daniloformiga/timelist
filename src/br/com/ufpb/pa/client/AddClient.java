package br.com.ufpb.pa.client;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;
import br.com.ufpb.pa.R;
import br.com.ufpb.pa.menu.MenuSeller;

public class AddClient extends Activity {
	
	Button buttonSaveClient;
	Button buttonBackClient;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.add_client);
		
		buttonSaveClient = (Button) findViewById(R.id.buttonSaveClient);
		buttonBackClient = (Button) findViewById(R.id.buttonBackAddClient);
		
		buttonSaveClient.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				
				String text = "Cliente cadastrado com Sucesso!";
				Toast tempMessage = Toast.makeText(getApplicationContext(), text,Toast.LENGTH_SHORT);
				tempMessage.show();
				Intent intent = new Intent(AddClient.this, MenuSeller.class);
        		startActivity(intent);
				
			}
		});
		
		buttonBackClient.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				Intent intent = new Intent(AddClient.this, MenuSeller.class);
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
