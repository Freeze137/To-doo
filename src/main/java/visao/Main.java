package visao;

import java.util.ArrayList;
import java.util.Scanner;

import controle.TarefaServico;
import modelo.Tarefa;

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
            System.out.println("6 - Buscar tarefa por título"); // removido e  atualizado para o 6 q ja faz a verificacao de status da tarefa
            System.out.println("7 - Sair");
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
                    Long idE = sc.nextLong(); sc.nextLine();
                    System.out.print("Novo título: ");
                    String nt = sc.nextLine();
                    System.out.print("Nova descrição: ");
                    String nd = sc.nextLine();
                    servico.editar(idE, nt, nd);
                    break;
                case 4:
                    System.out.print("ID da tarefa: ");
                    Long idC = sc.nextLong(); sc.nextLine();
                    servico.concluir(idC);
                    break;
                case 5:
                    System.out.print("ID da tarefa: ");
                    Long idR = sc.nextLong(); sc.nextLine();
                    servico.remover(idR);
                    break;
                case 6: 
                    System.out.print("Digite palavra-chave: ");
                    String palavra = sc.nextLine();
                    ArrayList<Tarefa> buscadas = servico.buscarPorTitulo(palavra);
                    if (buscadas.isEmpty()) {
                        System.out.println("Nenhuma tarefa encontrada!");
                    } else {
                        //  o método toString() mostra o status
                        for (Tarefa t : buscadas) System.out.println(t);
                    }
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