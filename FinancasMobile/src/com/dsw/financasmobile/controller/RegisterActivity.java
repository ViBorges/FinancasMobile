package com.dsw.financasmobile.controller;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.dsw.financasmobile.R;
import com.dsw.financasmobile.dao.UserDAO;
import com.dsw.financasmobile.model.User;

public class RegisterActivity extends FragmentActivity {

	private EditText userName;
	private EditText userPassword;
	private EditText userConfirmPassword;
	private Button registerBotton;

	User user = new User();
	UserDAO dataBase = new UserDAO(RegisterActivity.this);

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

				user.setName(userName.getText().toString());
				user.setPassword(userPassword.getText().toString());
				user.setConfirmPassword(userConfirmPassword.getText().toString());

				if (user.getName().isEmpty() || user.getPassword().isEmpty()
						|| user.getConfirmPassword().isEmpty()) {

					Toast.makeText(RegisterActivity.this,
							"Preencha todos os campos!", Toast.LENGTH_LONG)
							.show();
				} else {
					if (user.getPassword().equals(user.getConfirmPassword())) {

						dataBase.open();
						dataBase.insertUserData(user);
						dataBase.close();

						Toast.makeText(RegisterActivity.this,
								"Cadastro efetuado com sucesso!",
								Toast.LENGTH_SHORT).show();

						finish();
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
