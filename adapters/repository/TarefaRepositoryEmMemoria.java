package adapters.repository;

import core.Tarefa;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import ports.TarefaRepository;

public class TarefaRepositoryEmMemoria implements TarefaRepository {
    private final Map<String, Tarefa> tarefas = new HashMap<>();

    @Override
    public void salvar(Tarefa tarefa) {
        tarefas.put(tarefa.getId(), tarefa);
    }

    @Override
    public Tarefa buscarPorId(String id) {
        return tarefas.get(id);
    }

    @Override
    public List<Tarefa> listarTodas() {
        return new ArrayList<>(tarefas.values());
    }
}