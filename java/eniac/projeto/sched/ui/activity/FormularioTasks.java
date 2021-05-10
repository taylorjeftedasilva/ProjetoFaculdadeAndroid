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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario_tasks);
        FormularioDao dao = new FormularioDao();
        final EditText tarefa = findViewById(R.id.activity_formulario_tarefa);
        Button botao = findViewById(R.id.activity_formulario_botao);
        botao.setBackgroundColor(Color.rgb(0,204,102));
        botao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NovaTarefa(tarefa, dao);
            }
        });

    }

    private void NovaTarefa(EditText tarefa, FormularioDao dao) {
        String textoDaTarefa = tarefa.getText().toString();
        Tarefa task = new Tarefa(textoDaTarefa);
        dao.salva(task);
        finish();
    }
}