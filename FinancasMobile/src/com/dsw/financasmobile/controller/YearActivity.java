package com.dsw.financasmobile.controller;

import java.util.List;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.NumberPicker;

import com.dsw.financasmobile.R;
import com.dsw.financasmobile.DAO.DataDAO;
import com.dsw.financasmobile.model.Data;

public class YearActivity extends Activity {

	DataDAO dataDAO = new DataDAO(YearActivity.this);
	
	EditText name;
	EditText value;
	EditText description;
	Button cancelBtn;
	Button setBtn;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.list_view);
	}

	public void yearDialog() {

		final Dialog dialog = new Dialog(YearActivity.this);

		dialog.setTitle("Faça o Cadastro");
		dialog.setContentView(R.layout.year_dialog);

		/*final NumberPicker numberPickerYear = (NumberPicker) dialog
				.findViewById(R.id.numberPickerYear);

		numberPickerYear.setMaxValue(2020);
		numberPickerYear.setMinValue(2012);
		numberPickerYear.setWrapSelectorWheel(false);

		final NumberPicker numberPickerMonth = (NumberPicker) dialog
				.findViewById(R.id.numberPickerMonth);

		numberPickerMonth.setMaxValue(11);
		numberPickerMonth.setMinValue(0);
		numberPickerMonth.setDisplayedValues(new String[] {"Janeiro",
				"Fervereiro", "Março", "Abril", "Maio", "Junho", "Julho",
				"Agosto", "Setembro", "Outubro", "Novembro", "Dezembro"});

		final NumberPicker numberPickerCategory = (NumberPicker) dialog
				.findViewById(R.id.numberPickerCategory);

		numberPickerCategory.setMaxValue(1);
		numberPickerCategory.setMinValue(0);
		numberPickerCategory.setDisplayedValues(new String [] {"Gasto", "Ganho"});
*/
		name = (EditText) dialog.findViewById(R.id.nameDataText);
		//value = (EditText) dialog.findViewById(R.id.valueData);
		//description = (EditText) dialog.findViewById(R.id.descriptionData);
		//cancelBtn = (Button) dialog.findViewById(R.id.cancelButton);
		//setBtn = (Button) dialog.findViewById(R.id.setButton);

		// final ArrayList<String> list = new ArrayList<String>();

		setBtn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View view) {
				//String yearData = String.valueOf(numberPickerYear.getValue());
				//String mothData = String.valueOf(numberPickerMonth.getValue());
				//String categoryData = String.valueOf(numberPickerCategory.getValue());
				//Float valueData = Float.valueOf(value.getText().toString());
				//String descriptionData = String.valueOf(value.getText().toString());
				
				
				Data data = new Data();
				//data.setYear(yearData);

				DataDAO.getInstance(YearActivity.this).open();
				DataDAO.getInstance(YearActivity.this).insertReceiptData(data);
				Log.d("debugg", "Log do ganho: " + data.toString());
				List<Data> list = DataDAO.getInstance(YearActivity.this)
						.readAllDataYears();
				DataDAO.getInstance(YearActivity.this).close();

				ListView listView = (ListView) findViewById(R.id.list);

				YearCustomAdapter yearCustomAdapter = new YearCustomAdapter(
						YearActivity.this, list);
				listView.setAdapter(yearCustomAdapter);

				DataDAO.getInstance(YearActivity.this).close();

				Log.d("debugg", "Valor da Dialog");
				Log.d("debugg", "Log do ganho: " + data.toString());
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
