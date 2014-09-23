package com.dsw.minhasfinancas.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.dsw.minhasfinancas.R;

public class Login extends FragmentActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login);

		Button orRegister = (Button) findViewById(R.id.ouCadastreSeButton);
		
		orRegister.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				startActivity(new Intent(Login.this, Register.class));
				
			}
		});

	}

}
