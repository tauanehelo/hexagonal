import adapters.cli.CLIAdapter;
import adapters.repository.TarefaRepositoryEmMemoria;
import core.GerenciadorTarefas;
import ports.TarefaRepository;

public class Main {
    public static void main(String[] args) {
        TarefaRepository repository = new TarefaRepositoryEmMemoria();
        GerenciadorTarefas gerenciador = new GerenciadorTarefas(repository);
        CLIAdapter cli = new CLIAdapter(gerenciador);

        cli.iniciar();
    }
}