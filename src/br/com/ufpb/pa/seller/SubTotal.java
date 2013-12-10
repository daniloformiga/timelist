package br.com.ufpb.pa.seller;

import br.com.ufpb.pa.R;
import br.com.ufpb.pa.TimeList;
import br.com.ufpb.pa.R.id;
import br.com.ufpb.pa.R.layout;
import br.com.ufpb.pa.R.menu;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class SubTotal extends Activity {
	
	Button buttonSave;
	Button buttonBack;
		
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.sub_total);
		
		buttonSave = (Button) findViewById(R.id.buttonSaveSubTotal);
		buttonBack = (Button) findViewById(R.id.buttonBackSubTotal);
				
		buttonBack.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(SubTotal.this, SellerDecision.class);
        		startActivity(intent);
				
			}
		});
		
		buttonSave.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				String text = "Cadastrado com Sucesso!";
				Toast tempMessage = Toast.makeText(getApplicationContext(), text,Toast.LENGTH_SHORT);
				tempMessage.show();
				
				Intent intent = new Intent(SubTotal.this, TimeList.class);
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
