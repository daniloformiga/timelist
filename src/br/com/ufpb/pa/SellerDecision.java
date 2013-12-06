package br.com.ufpb.pa;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

public class SellerDecision extends Activity {

	TextView textYesSeller;
	TextView textNoSeller;
	TextView textIexit;
	TextView textIback;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.seller_decision);

		textYesSeller = (TextView) findViewById(R.id.textYesSeller);
		textNoSeller = (TextView) findViewById(R.id.textNoSeller);
		textIexit = (TextView) findViewById(R.id.textIexit);
		textIback = (TextView) findViewById(R.id.textIback);

		textYesSeller.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intent = new Intent(SellerDecision.this, SubTotal.class);
				startActivity(intent);

			}
		});

		textNoSeller.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intent = new Intent(SellerDecision.this, TimeList.class);
				startActivity(intent);

			}
		});

		textIexit.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intent = new Intent(SellerDecision.this, TimeList.class);
				startActivity(intent);

			}
		});

		textIback.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intent = new Intent(SellerDecision.this, TimeList.class);
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
