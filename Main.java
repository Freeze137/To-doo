package visao;

import service.TarefaServico;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TarefaServico servico = new TarefaServico();
        int opcao;

        do {
            System.out.println("\n===== MENU =====");
            System.out.println("1 - Criar tarefa");
            System.out.println("2 - Listar tarefas");
            System.out.println("3 - Editar tarefa");
            System.out.println("4 - Concluir tarefa");
            System.out.println("5 - Remover tarefa");
            System.out.println("0 - Sair");
            System.out.print("Escolha: ");
            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1:
                    System.out.print("Título: ");
                    String titulo = sc.nextLine();
                    System.out.print("Descrição: ");
                    String desc = sc.nextLine();
                    servico.criar(titulo, desc);
                    break;
                case 2:
                    servico.listar();
                    break;
                case 3:
                    System.out.print("ID da tarefa: ");
                    int idE = sc.nextInt(); sc.nextLine();
                    System.out.print("Novo título: ");
                    String nt = sc.nextLine();
                    System.out.print("Nova descrição: ");
                    String nd = sc.nextLine();
                    servico.editar(idE, nt, nd);
                    break;
                case 4:
                    System.out.print("ID da tarefa: ");
                    int idC = sc.nextInt();
                    servico.concluir(idC);
                    break;
                case 5:
                    System.out.print("ID da tarefa: ");
                    int idR = sc.nextInt();
                    servico.remover(idR);
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 0);

        sc.close();
    }
}
