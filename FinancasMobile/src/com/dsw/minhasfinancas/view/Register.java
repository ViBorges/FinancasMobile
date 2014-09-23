package com.dsw.minhasfinancas.view;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.dsw.minhasfinancas.R;
import com.dsw.minhasfinancas.DAO.UserDAO;
import com.dsw.minhasfinancas.model.User;

public class Register extends FragmentActivity {

	String USER;
	String PASSWAORD;
	String CONFIRMPASSWORD;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.cadastro);

		// chamando objetos de entrada de texto
		final EditText userName = (EditText) findViewById(R.id.emailText2);
		final EditText userPassword = (EditText) findViewById(R.id.senhaText2);
		final EditText confirmPassword = (EditText) findViewById(R.id.confirmaSenhaText);
		// Ligando objetos a DAO
		final User user = new User();
		user.setNome(userName.getEditableText().toString());
		user.setSenha(userPassword.getEditableText().toString());
		// chamando objetos de butão
		Button registerBtn = (Button) findViewById(R.id.cadastroButton);

		registerBtn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				USER = userName.getText().toString();
				PASSWAORD = userPassword.getText().toString();
				CONFIRMPASSWORD = confirmPassword.getText().toString();

				if (USER.isEmpty() || PASSWAORD.isEmpty()
						|| CONFIRMPASSWORD.isEmpty()) {

					Toast.makeText(Register.this, "Preencha todos os campos!",
							Toast.LENGTH_LONG).show();
				} else {

					if (PASSWAORD.equals(CONFIRMPASSWORD)) {

						UserDAO dao = new UserDAO(Register.this);
						dao.add(user);
						dao.close();

						Toast.makeText(Register.this,
								"Cadastro efetuado com sucesso!",
								Toast.LENGTH_SHORT).show();
						
						finish();
						

					} else {

						Toast.makeText(Register.this,
								"Erro! Senhas diferentes. Refaça o cadastro.",
								Toast.LENGTH_SHORT).show();
					}

				}

			}

		});

	}

}
