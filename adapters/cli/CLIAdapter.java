package adapters.cli;

import core.GerenciadorTarefas;
import core.Tarefa;
import java.util.List;
import java.util.Scanner;

public class CLIAdapter {
    private final GerenciadorTarefas gerenciador;

    public CLIAdapter(GerenciadorTarefas gerenciador) {
        this.gerenciador = gerenciador;
    }

    public void iniciar() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("1. Criar Tarefa");
            System.out.println("2. Listar Tarefas");
            System.out.println("3. Marcar Tarefa como Concluida");
            System.out.println("4. Sair");
            System.out.print("Escolha: ");
            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.print("ID da Tarefa: ");
                    String id = scanner.nextLine();
                    System.out.print("Nome: ");
                    String descricao = scanner.nextLine();
                    boolean tarefaCriada = gerenciador.criarTarefa(id, descricao);
                    if (tarefaCriada) {
                        System.out.println("Tarefa criada com sucesso!");
                    } else {
                        System.out.println("Erro: Ja existe uma tarefa com o ID " + id + ".");
                    }
                    break;
                case 2:
                    List<Tarefa> tarefas = gerenciador.listarTarefas();
                    tarefas.forEach(t -> System.out.println(t.getDescricao() + " - " + (t.isConcluida() ? "Concluida" : "Pendente")));
                    break;
                case 3:
                    System.out.print("ID da Tarefa: ");
                    String idConcluir = scanner.nextLine();
                    gerenciador.marcarTarefaComoConcluida(idConcluir);
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Entrada invalida, tente novamente!");
            }
        }
    }
}