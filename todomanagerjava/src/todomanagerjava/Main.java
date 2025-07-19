package todomanagerjava;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ITarefaManager manager = new TarefaManager();
        int opcao;

        do {
            System.out.println("\n=== MENU ===");
            System.out.println("1 - Adicionar tarefa");
            System.out.println("2 - Listar tarefas");
            System.out.println("3 - Marcar como concluída");
            System.out.println("4 - Remover tarefa");
            System.out.println("0 - Sair");
            System.out.print("Escolha: ");
            opcao = sc.nextInt();
            sc.nextLine(); // consumir linha

            switch (opcao) {
                case 1:
                    System.out.print("Descrição: ");
                    String desc = sc.nextLine();
                    manager.adicionar(desc);
                    break;
                case 2:
                    manager.listar();
                    break;
                case 3:
                    System.out.print("ID da tarefa: ");
                    int idConcluir = sc.nextInt();
                    manager.concluir(idConcluir);
                    break;
                case 4:
                    System.out.print("ID da tarefa: ");
                    int idRemover = sc.nextInt();
                    manager.remover(idRemover);
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }

        } while (opcao != 0);

        sc.close();
    }
}
