package visao;

import java.util.Scanner;
import controle.AlunoServico;
import modelo.Aluno;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        AlunoServico servico = new AlunoServico();
        int opcao;

        do {
            System.out.println("\n===== MENU MATRÍCULA ESCOLAR =====");
            System.out.println("1 - Cadastrar aluno");
            System.out.println("2 - Listar alunos");
            System.out.println("3 - Buscar aluno por CPF");
            System.out.println("4 - Editar aluno");
            System.out.println("5 - Remover aluno");
            System.out.println("6 - Sair");
            System.out.print("Escolha: ");
            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1:
                    System.out.print("Nome completo: ");
                    String nome = sc.nextLine();
                    System.out.print("CPF: ");
                    String cpf = sc.nextLine();
                    System.out.print("Idade: ");
                    int idade = sc.nextInt(); sc.nextLine();
                    System.out.print("Série (Fundamental 1, Fundamental 2, Médio): ");
                    String serie = sc.nextLine();
                    System.out.print("Turno (Matutino/Vespertino): ");
                    String turno = sc.nextLine();
                    System.out.print("Telefone: ");
                    String telefone = sc.nextLine();
                    servico.cadastrarAluno(nome, cpf, idade, serie, turno, telefone);
                    break;
                case 2:
                    servico.listarAlunos();
                    break;
                case 3:
                    System.out.print("Digite o CPF do aluno: ");
                    String cpfBusca = sc.nextLine();
                    servico.buscarAlunoPorCPF(cpfBusca);
                    break;
                case 4:
                    System.out.print("CPF do aluno para editar: ");
                    String cpfEdit = sc.nextLine();
                    servico.editarAluno(cpfEdit, sc);
                    break;
                case 5:
                    System.out.print("CPF do aluno para remover: ");
                    String cpfRemove = sc.nextLine();
                    servico.removerAluno(cpfRemove);
                    break;
                case 6:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }

        } while (opcao != 6);

        sc.close();
    }
}
