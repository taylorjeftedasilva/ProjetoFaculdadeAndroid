package eniac.projeto.sched.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.ColorRes;
import androidx.annotation.LayoutRes;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;


import eniac.projeto.sched.R;
import eniac.projeto.sched.banco.BancoDeDados;
import eniac.projeto.sched.model.Usuario;

public class Login extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        setTitle("Login");
        Button botao_criar = findViewById(R.id.activity_entrar);
        TextView cadastrar = findViewById(R.id.activity_link_cadastrar);
        TextView erro = findViewById(R.id.activity_login_erro);
        EditText usuarioTXT, senhaTXT;
        usuarioTXT = findViewById(R.id.activity_usuario);
        senhaTXT = findViewById(R.id.activity_senha);
        botao_criar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Usuario usuario = new Usuario(usuarioTXT.getText().toString(), senhaTXT.getText().toString());
                BancoDeDados bd = new BancoDeDados(Login.this);
                try{
                    Usuario usr = bd.selecionar(usuario);
                    erro.setText("");
                    startActivity(new Intent(Login.this, ListaTasks.class));
                    finish();
                }catch (Exception e){
                    erro.setText("Login ou senha inválidos");
                }
            }
        });
        cadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Login.this, Cadastrar.class));
            }
        });
    }
}
