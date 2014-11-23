package com.dsw.financasmobile.controller;

import android.R;
import android.app.Dialog;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.NumberPicker;
import android.widget.TextView;

public class MainActivity extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		
	}
	
public void yearDialog() {
		
		

		final Dialog d = new Dialog(MainActivity.this);
		d.setTitle("Selecione o Ano");
		d.setContentView(R.layout.year_selector);
		final NumberPicker np = (NumberPicker) d
				.findViewById(R.id.numberPicker);
		np.setMaxValue(2020);
		np.setMinValue(2012);
		np.setWrapSelectorWheel(false);
		
		
		
		Button cancelBtn = (Button) d.findViewById(R.id.cancelButton);
		Button setBtn = (Button) d.findViewById(R.id.setButton);
		
		setBtn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				TextView tv = (TextView) findViewById(R.id.hello);
				tv.setText(String.valueOf(np.getValue()));
				d.dismiss();
				
			}
		});

		cancelBtn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				d.dismiss();

			}
		});

		d.show();

	}


	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_new) {
			
			yearDialog();
			
		}
		return super.onOptionsItemSelected(item);
	}
}
