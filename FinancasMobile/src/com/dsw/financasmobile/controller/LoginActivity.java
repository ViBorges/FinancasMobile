package com.dsw.financasmobile.controller;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.dsw.financasmobile.R;
import com.dsw.financasmobile.DAO.UserDAO;
import com.dsw.financasmobile.model.User;

public class LoginActivity extends ActionBarActivity {
	
	private EditText nameText;
	private EditText passwordText;
	private Button loginButton;
	private Button orRegister;
	
	private String informedName;
	private String informedPassword;
	
	User user = new User();
	UserDAO userDAO = new UserDAO(LoginActivity.this);

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login);

		nameText = (EditText) findViewById(R.id.nameText);
		passwordText = (EditText) findViewById(R.id.passwordText);
		loginButton = (Button) findViewById(R.id.loginButton);
		orRegister = (Button) findViewById(R.id.ouCadastreSeButton);
		
		orRegister.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View view) {
				startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
			}
		});
		
		loginButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View view) {
				
				informedName = nameText.getText().toString();
				informedPassword = passwordText.getText().toString();
				
				UserDAO.getInstance(LoginActivity.this).open();
				
				if(informedName.isEmpty() || informedPassword.isEmpty()) {
					Toast.makeText(LoginActivity.this,
							"Preencha todos os campos!", Toast.LENGTH_LONG)
							.show();
				}
				else {
					if(UserDAO.getInstance(LoginActivity.this).Login(informedName, informedPassword)) {
						Toast.makeText(LoginActivity.this,
								"Login efetuado com sucesso!", Toast.LENGTH_LONG)
								.show();
						startActivity(new Intent(LoginActivity.this, YearActivity.class));
						finish();
					} else 
						Toast.makeText(LoginActivity.this,
								"Usuário não cadastrado, por favor, realize o cadastro!", Toast.LENGTH_LONG)
								.show();
					nameText.setText("");
					passwordText.setText("");
				}				
			}
		});
	}
}
