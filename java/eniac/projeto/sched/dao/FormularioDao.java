package eniac.projeto.sched.dao;

import java.util.ArrayList;
import java.util.List;

import eniac.projeto.sched.model.Tarefa;

public class FormularioDao {
    private final static List<Tarefa> tarefa = new ArrayList<>();
    public void salva(Tarefa tar) {
        tarefa.add(tar);
    }

    public List<Tarefa> todos() {
        return new ArrayList<>(tarefa);
    }
}
