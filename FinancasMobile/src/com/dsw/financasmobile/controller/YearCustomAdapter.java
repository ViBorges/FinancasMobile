package com.dsw.financasmobile.controller;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.dsw.financasmobile.R;
import com.dsw.financasmobile.model.Data;

public class YearCustomAdapter extends BaseAdapter {

	private Context context;
	private List<Data> list;
	
	public YearCustomAdapter(Context context, List<Data> list){
		this.context = context;
		this.list = list;
	}
	
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return list.size();
	}

	@Override
	public Object getItem(int arg0) {
		// TODO Auto-generated method stub
		return list.get(arg0);
	}

	@Override
	public long getItemId(int arg0) {
		// TODO Auto-generated method stub
		return arg0;
	}

	@Override
	public View getView(int position, View view, ViewGroup viewGroup) {
		
		YearActivity yearActivity = new YearActivity();
		
		if(view==null) {
			LayoutInflater inflater = (LayoutInflater) yearActivity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			view = inflater.inflate(R.layout.year_list_view_row_item, viewGroup, false);
		}
		
		
		TextView tv = (TextView) view.findViewById(R.id.year);
		tv.setText(list.get(position).getYear());
		
		
		Button editButton = (Button) view.findViewById(R.id.edit);
		editButton.setOnClickListener(new Button.OnClickListener(){
			@Override
			public void onClick(View view) {
				Toast.makeText(view.getContext(), "Deleted", Toast.LENGTH_SHORT).show();
			}
		});
		
		Button deleteButton = (Button) view.findViewById(R.id.delete);
		deleteButton.setOnClickListener(new Button.OnClickListener(){
			@Override
			public void onClick(View view) {
				Toast.makeText(view.getContext(), "Edit", Toast.LENGTH_SHORT).show();
			}
		});
		
		return view;
	}
}