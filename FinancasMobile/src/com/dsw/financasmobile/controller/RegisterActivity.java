package com.dsw.financasmobile.controller;

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

public class RegisterActivity extends ActionBarActivity {

	private EditText userName;
	private EditText userPassword;
	private EditText userConfirmPassword;
	private Button registerBotton;

	UserDAO userDAO = new UserDAO(RegisterActivity.this);

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.cadastro);

		userName = (EditText) findViewById(R.id.emailText2);
		userPassword = (EditText) findViewById(R.id.senhaText2);
		userConfirmPassword = (EditText) findViewById(R.id.confirmaSenhaText);
		registerBotton = (Button) findViewById(R.id.cadastroButton);

		registerBotton.setOnClickListener(new OnClickListener() {

			public void onClick(View view) {

				String name = userName.getText().toString();
				String password = userPassword.getText().toString();
				String confirmPassword = userConfirmPassword.getText().toString();
				
				User user = new User(name, password, confirmPassword);

				if (user.getName().isEmpty() || user.getPassword().isEmpty()
						|| user.getConfirmPassword().isEmpty()) {

					Toast.makeText(RegisterActivity.this,
							"Preencha todos os campos!", Toast.LENGTH_LONG)
							.show();
				} else {
					if (user.getPassword().equals(user.getConfirmPassword())) {

						UserDAO.getInstance(RegisterActivity.this).open();
						UserDAO.getInstance(RegisterActivity.this).insertUserData(user);
						UserDAO.getInstance(RegisterActivity.this).close();
						
						finish();
						
						Toast.makeText(RegisterActivity.this,
								"Cadastro efetuado com sucesso!",
								Toast.LENGTH_SHORT).show();
					} else {
						Toast.makeText(
								RegisterActivity.this,
								"Erro, Senhas diferentes! Digite novamente a senha.",
								Toast.LENGTH_SHORT).show();
					}
				}
			}
		});
	}
}
