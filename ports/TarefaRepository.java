package ports;

import core.Tarefa;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public abstract class TarefaRepository {
    public final Map<String, Tarefa> tarefas = new HashMap<>();
    public Tarefa tarefa;

    public void gerarTarefa(String id, String descricao){
        this.tarefa = new Tarefa(id, descricao);
    }
    public void salvar(String id, String descricao) {}

    public Tarefa buscarPorId(String id) {
        return this.tarefas.get(id);
    }
    public void marcarComoConcluida(Tarefa tarefa){
        tarefa.marcarComoConcluida();
        this.tarefas.put(tarefa.getId(), tarefa);
    }
    public List<Tarefa> listarTodas() {
        return new ArrayList<>(tarefas.values());
    }
}