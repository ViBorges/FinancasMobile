package com.dsw.financasmobile.controller;

import com.dsw.financasmobile.R;
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

		final Dialog dialog = new Dialog(MainActivity.this);
		
		dialog.setTitle("Selecione o Ano");
		dialog.setContentView(R.layout.year_selector);
		
		final NumberPicker numberPicker = (NumberPicker) dialog
				.findViewById(R.id.numberPicker);
		
		numberPicker.setMaxValue(2020);
		numberPicker.setMinValue(2012);
		numberPicker.setWrapSelectorWheel(false);

		Button cancelBtn = (Button) dialog.findViewById(R.id.cancelButton);
		Button setBtn = (Button) dialog.findViewById(R.id.setButton);

		setBtn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				TextView tv = (TextView) findViewById(R.id.hello);
				
				tv.setText(String.valueOf(numberPicker.getValue()));
				
				dialog.dismiss();
			}
		});

		cancelBtn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				dialog.dismiss();
			}
		});

		dialog.show();
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
