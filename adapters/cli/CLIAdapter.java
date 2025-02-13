package adapters.cli;

import adapters.repository.TarefaRepositoryEmMemoria;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import ports.TarefaService;

public class CLIAdapter {
    private final TarefaService tarefaService;

    public CLIAdapter() {
        TarefaRepositoryEmMemoria repository = new TarefaRepositoryEmMemoria();
        this.tarefaService = new TarefaService(repository);
    }

    public void iniciar() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("1. Criar Tarefa");
            System.out.println("2. Listar Todas as Tarefas");
            System.out.println("3. Listar Tarefas Concluidas");
            System.out.println("4. Listar Tarefas Pendentes");
            System.out.println("5. Marcar Tarefa como Concluida");
            System.out.println("6. Sair");
            System.out.print("Escolha: ");
            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.println("----------------------------------");
                    System.out.print("ID da Tarefa: ");
                    String id = scanner.nextLine();
                    System.out.print("Nome: ");
                    String descricao = scanner.nextLine();
                    try {
                        tarefaService.criarTarefa(id, descricao);
                        System.out.println(" ");
                        System.out.println("Tarefa criada com sucesso!");
                    } catch (IllegalArgumentException e) {
                        System.out.println(" ");
                        System.out.println("Erro: " + e.getMessage());
                    }
                    System.out.println("----------------------------------");
                    break;
                case 2:
                System.out.println("----------------------------------");
                    List<Map<String, String>> todasTarefas = tarefaService.listarTarefas();
                    todasTarefas.forEach(t -> System.out.println(
                        t.get("descricao") + " - " + (Boolean.parseBoolean(t.get("concluida")) ? "Concluida" : "Pendente")
                    ));
                    System.out.println("----------------------------------");
                    break;
                case 3:
                    System.out.println("----------------------------------");
                    List<Map<String, String>> tarefasConcluidas = tarefaService.listarTarefasPorStatus(true);
                    tarefasConcluidas.forEach(t -> System.out.println(
                        t.get("descricao") + " - Concluida"
                    ));
                    System.out.println("----------------------------------");
                    break;
                case 4:
                    System.out.println("----------------------------------");
                    List<Map<String, String>> tarefas = tarefaService.listarTarefas();
                    tarefas.forEach(t -> System.out.println(
                        t.get("descricao") + " - " + (Boolean.parseBoolean(t.get("concluida")) ? "Concluida" : "Pendente")
                    ));
                    System.out.println("----------------------------------");
                    break;
                case 5:
                    System.out.println("----------------------------------");
                    System.out.print("ID da Tarefa: ");
                    String idConcluir = scanner.nextLine();
                    tarefaService.marcarTarefaComoConcluida(idConcluir);
                    System.out.println("----------------------------------");
                    break;
                case 6:
                    return;
                default:
                    System.out.println("----------------------------------");
                    System.out.println("Entrada invalida, tente novamente!");
                    System.out.println("----------------------------------");
            }
        }
    }
}