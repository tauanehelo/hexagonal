package ports;

import core.Tarefa;
import java.util.List;

public interface TarefaRepository {
    void salvar(Tarefa tarefa);
    Tarefa buscarPorId(String id);
    List<Tarefa> listarTodas();
}