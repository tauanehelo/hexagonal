package ports;

import java.util.List;
import java.util.Map;

public interface TarefaService {
    void criarTarefa(String id, String descricao);
    List<Map<String, String>> listarTarefas();
    List<Map<String, String>> listarTarefasPorStatus(boolean concluida);
    void marcarTarefaComoConcluida(String id);
}