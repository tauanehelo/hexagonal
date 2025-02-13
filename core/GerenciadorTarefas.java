package core;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import ports.TarefaRepository;

public abstract class GerenciadorTarefas {
    private final TarefaRepository repository;

    public GerenciadorTarefas(TarefaRepository repository) {
        this.repository = repository;
    }

    public void criarTarefa(String id, String descricao) {
        if (repository.buscarPorId(id) != null) {
            throw new IllegalArgumentException("Ja existe uma tarefa com o ID: " + id);
        }
        repository.salvar(id, descricao);
    }

    public List<Map<String, String>> listarTarefas() {
        return repository.listarTodas().stream()
                .map(tarefa -> {
                    Map<String, String> dadosTarefa = new HashMap<>();
                    dadosTarefa.put("id", tarefa.getId());
                    dadosTarefa.put("descricao", tarefa.getDescricao());
                    dadosTarefa.put("concluida", Boolean.toString(tarefa.isConcluida()));
                    return dadosTarefa;
                })
                .collect(Collectors.toList());
    }
    
    public List<Map<String, String>> listarTarefasPorStatus(boolean concluida) {
        return repository.listarTodas().stream()
                .filter(tarefa -> tarefa.isConcluida() == concluida) // Filtra por status
                .map(tarefa -> {
                    Map<String, String> dadosTarefa = new HashMap<>();
                    dadosTarefa.put("id", tarefa.getId());
                    dadosTarefa.put("descricao", tarefa.getDescricao());
                    dadosTarefa.put("concluida", Boolean.toString(tarefa.isConcluida()));
                    return dadosTarefa;
                })
                .collect(Collectors.toList());
    }

    public void marcarTarefaComoConcluida(String id) {
        Tarefa tarefa = repository.buscarPorId(id);
        if (tarefa != null) {
            repository.marcarComoConcluida(tarefa);
        }
    }
}