package eniac.projeto.sched.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

import eniac.projeto.sched.R;
import eniac.projeto.sched.dao.FormularioDao;
import eniac.projeto.sched.model.Tarefa;

public class ListaTasks extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("New Task");
        FloatingActionButton botao_criar = findViewById(R.id.activity_botao_criar);
        botao_criar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ListaTasks.this, FormularioTasks.class));
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        FormularioDao dao = new FormularioDao();
        List<Tarefa> tarefas = dao.todos();
        ListView lista = findViewById(R.id.activity_main_lista_de_tarefas);
        lista.setAdapter(new ArrayAdapter<>(
                this,android.R.layout.simple_list_item_1,
                tarefas));
        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String mensagem = tarefas.get(position).getTextoDaTarefa();
                Toast.makeText(ListaTasks.this,mensagem, Toast.LENGTH_SHORT).show();
            }
        });
    }
}



