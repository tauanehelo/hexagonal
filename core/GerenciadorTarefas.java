package core;

import ports.TarefaRepository;
import java.util.List;

public class GerenciadorTarefas {
    private final TarefaRepository repository;

    public GerenciadorTarefas(TarefaRepository repository) {
        this.repository = repository;
    }

    public boolean criarTarefa(String id, String descricao) {
        if (repository.buscarPorId(id) != null) {
            return false;
        }
        Tarefa tarefa = new Tarefa(id, descricao);
        repository.salvar(tarefa);
        return true;
    }

    public List<Tarefa> listarTarefas() {
        return repository.listarTodas();
    }

    public void marcarTarefaComoConcluida(String id) {
        Tarefa tarefa = repository.buscarPorId(id);
        if (tarefa != null) {
            tarefa.marcarComoConcluida();
            repository.salvar(tarefa);
        }
    }
}