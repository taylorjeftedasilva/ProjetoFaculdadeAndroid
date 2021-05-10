package eniac.projeto.sched.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import eniac.projeto.sched.R;
import eniac.projeto.sched.banco.BancoDeDados;
import eniac.projeto.sched.model.Usuario;

public class Login extends AppCompatActivity {

    private Button botao_criar;
    private TextView cadastrar;
    private TextView erro;
    private EditText usuarioTXT;
    private EditText senhaTXT;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        setTitle("Login");

        instanciaVariaveis();

        botao_criar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
            }
        });
        cadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Login.this, Cadastrar.class));
            }
        });
    }

    private void instanciaVariaveis() {
        botao_criar = findViewById(R.id.activity_entrar);
        cadastrar = findViewById(R.id.activity_link_cadastrar);
        erro = findViewById(R.id.activity_login_erro);
        usuarioTXT = findViewById(R.id.activity_usuario);
        senhaTXT = findViewById(R.id.activity_senha);
    }

    private void login() {
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
}
