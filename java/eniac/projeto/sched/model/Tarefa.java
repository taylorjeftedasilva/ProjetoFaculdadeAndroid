package eniac.projeto.sched.model;

public class Tarefa {
    private final String textoDaTarefa;

    public Tarefa(String textoDaTarefa) {
        this.textoDaTarefa = textoDaTarefa;
    }

    public String getTextoDaTarefa() {
        return textoDaTarefa;
    }

    @Override
    public String toString() {
        return  textoDaTarefa;
    }
}
