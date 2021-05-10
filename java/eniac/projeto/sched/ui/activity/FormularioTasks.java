package eniac.projeto.sched.ui.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import eniac.projeto.sched.R;
import eniac.projeto.sched.dao.FormularioDao;
import eniac.projeto.sched.model.Tarefa;

public class FormularioTasks extends AppCompatActivity {

    private FormularioDao dao;
    private EditText tarefa;
    private Button botao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario_tasks);

        instanciaVariaveis();

        botao.setBackgroundColor(Color.rgb(0,204,102));
        botao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NovaTarefa();
            }
        });

    }

    private void instanciaVariaveis() {
        dao = new FormularioDao();
        tarefa = findViewById(R.id.activity_formulario_tarefa);
        botao = findViewById(R.id.activity_formulario_botao);
    }

    private void NovaTarefa() {
        String textoDaTarefa = tarefa.getText().toString();
        Tarefa task = new Tarefa(textoDaTarefa);
        dao.salva(task);
        finish();
    }
}