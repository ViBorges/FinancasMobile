package com.dsw.minhasfinancas.VIEW;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.dsw.minhasfinancas.R;
import com.dsw.minhasfinancas.DAO.UsuarioDAO;
import com.dsw.minhasfinancas.MODEL.Usuario;

public class Cadastro extends FragmentActivity {

	String USUARIO;
	String SENHA;
	String CONFIRMASENHA;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.cadastro);

		// chamando objetos de entrada de texto
		final EditText usuarioNome = (EditText) findViewById(R.id.emailText2);
		final EditText usuarioSenha = (EditText) findViewById(R.id.senhaText2);
		final EditText confirmaSenha = (EditText) findViewById(R.id.confirmaSenhaText);
		// Ligando objetos a DAO
		final Usuario usuario = new Usuario();
		usuario.setNome(usuarioNome.getText().toString());
		usuario.setSenha(usuarioSenha.getText().toString());
		// chamando objetos de butão
		Button butaoCadastro = (Button) findViewById(R.id.cadastroButton);

		butaoCadastro.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				USUARIO = usuarioNome.getText().toString();
				SENHA = usuarioSenha.getText().toString();
				CONFIRMASENHA = confirmaSenha.getText().toString();

				if (USUARIO.isEmpty() || SENHA.isEmpty()
						|| CONFIRMASENHA.isEmpty()) {

					Toast.makeText(Cadastro.this, "Preencha todos os campos!",
							Toast.LENGTH_LONG).show();
				} else {

					if (SENHA.equals(CONFIRMASENHA)) {

						UsuarioDAO dao = new UsuarioDAO(Cadastro.this);
						dao.adicionar(usuario);
						dao.close();

						Toast.makeText(Cadastro.this,
								"Cadastro efetuado com sucesso!",
								Toast.LENGTH_SHORT).show();
						Intent itent = new Intent(Cadastro.this, Login.class);
						startActivity(itent);

					} else {

						Toast.makeText(Cadastro.this,
								"Erro! Senhas diferentes. Refaça o cadastro.",
								Toast.LENGTH_SHORT).show();
					}

				}

			}

		});

	}

}
