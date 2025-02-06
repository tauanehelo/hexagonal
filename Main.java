import adapters.cli.CLIAdapter;
import adapters.repository.TarefaRepositoryEmMemoria;
public class Main {
    public static void main(String[] args) {
        // Configuração do repositório (adaptador)
        TarefaRepositoryEmMemoria repository = new TarefaRepositoryEmMemoria();

        // Configuração do adaptador (CLI)
        CLIAdapter cli = new CLIAdapter(repository);

        // Iniciar sistema
        cli.iniciar();
    }
}