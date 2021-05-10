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

    private FormularioDao dao;
    private FloatingActionButton botao_criar;
    private ListView lista;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("New Task");

        instanciaVariaveis();

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
        instanciaVariaveis();
        EventosDaListaDeTarefas();
    }

    private void EventosDaListaDeTarefas() {
        List<Tarefa> tarefas = dao.todos();
        lista.setAdapter(new ArrayAdapter<>(
                this,android.R.layout.simple_list_item_1,
                tarefas));
        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ExbiMensagem(position, tarefas);
            }
        });
    }

    private void ExbiMensagem(int position, List<Tarefa> tarefas) {
        String mensagem = tarefas.get(position).getTextoDaTarefa();
        Toast.makeText(ListaTasks.this,mensagem, Toast.LENGTH_SHORT).show();
    }
    private void instanciaVariaveis() {
        dao = new FormularioDao();
        botao_criar = findViewById(R.id.activity_botao_criar);
        lista = findViewById(R.id.activity_main_lista_de_tarefas);
    }
}



