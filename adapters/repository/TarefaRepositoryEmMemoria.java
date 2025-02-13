package adapters.repository;

import ports.TarefaRepository;

public class TarefaRepositoryEmMemoria extends TarefaRepository {

    @Override
    public void salvar(String id, String descricao) {
        gerarTarefa(id, descricao);
        tarefas.put(tarefa.getId(), tarefa);
    }
}