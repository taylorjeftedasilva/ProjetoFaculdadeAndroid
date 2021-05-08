package eniac.projeto.sched.ui.activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import eniac.projeto.sched.R;

public class Cadastrar  extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);
        setTitle("Cadastrar Usuário");
        Button botao_cadatrar = findViewById(R.id.activity_efetuar_cadastro);
        TextView retornar_login = findViewById(R.id.activity_link_login);
        botao_cadatrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        retornar_login.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                finish();
            }
        });
    }
}
