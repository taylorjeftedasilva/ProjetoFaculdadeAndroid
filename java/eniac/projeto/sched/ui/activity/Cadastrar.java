package eniac.projeto.sched.ui.activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import eniac.projeto.sched.R;
import eniac.projeto.sched.banco.BancoDeDados;
import eniac.projeto.sched.model.Usuario;

public class Cadastrar  extends AppCompatActivity {

    private TextView retornar_login;
    private BancoDeDados banco_sched;
    private Button botao_cadatrar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Atrela um layout a classe java.
        setContentView(R.layout.activity_cadastro);
        setTitle("Cadastrar Usuário");
        // end

        instanciaVariaveis();
        //escuta evento de clique no botão de cadastro.
        botao_cadatrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                salvaNovoUsuario(banco_sched);
            }
        });
        //end
        // escuta evento de clique no textview de login
        retornar_login.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                finish();
            }
        });
        //end
    }

    private void instanciaVariaveis() {
        retornar_login = findViewById(R.id.activity_link_login);
        banco_sched = new BancoDeDados(this);
        botao_cadatrar = findViewById(R.id.activity_efetuar_cadastro);
    }

    private void salvaNovoUsuario(BancoDeDados banco_sched) {
        Usuario novoUsuario = criaUsuario();
        banco_sched.adicionarUsuario(novoUsuario);
        Toast.makeText(Cadastrar.this, "Novo usuario salvo com sucesso!", Toast.LENGTH_SHORT).show();
        finish();
    }

    private Usuario criaUsuario() {
        EditText Inome, Isenha, Iusuario;
        Isenha = findViewById(R.id.activity_cadastro_senha);
        Iusuario = findViewById(R.id.activity_cadastro_usuario);
        Inome = findViewById(R.id.activity_cadastro_nome);
        String nome = Inome.getText().toString();
        String senha = Isenha.getText().toString();
        String usuario = Iusuario.getText().toString();

        return new Usuario(nome, senha, usuario);
    }
}
