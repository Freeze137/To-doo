package controle;

import java.sql.*;
import java.util.Scanner;
import modelo.Aluno;

public class AlunoServico {

    public void cadastrarAluno(String nome, String cpf, int idade, String serie, String turno, String telefone) {
        String sql = "INSERT INTO aluno (nome, cpf, idade, serie, turno, telefone) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, nome);
            stmt.setString(2, cpf);
            stmt.setInt(3, idade);
            stmt.setString(4, serie);
            stmt.setString(5, turno);
            stmt.setString(6, telefone);
            stmt.executeUpdate();
            System.out.println("Aluno cadastrado com sucesso!");

        } catch (SQLException e) {
            System.out.println("Erro ao cadastrar aluno: " + e.getMessage());
        }
    }

    public void listarAlunos() {
        String sql = "SELECT * FROM aluno";
        try (Connection conn = Conexao.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                System.out.println(
                        "ID: " + rs.getLong("id") +
                        " | Nome: " + rs.getString("nome") +
                        " | CPF: " + rs.getString("cpf") +
                        " | Idade: " + rs.getInt("idade") +
                        " | Série: " + rs.getString("serie") +
                        " | Turno: " + rs.getString("turno") +
                        " | Telefone: " + rs.getString("telefone")
                );
            }

        } catch (SQLException e) {
            System.out.println("Erro ao listar alunos: " + e.getMessage());
        }
    }

    public void buscarAlunoPorCPF(String cpf) {
        String sql = "SELECT * FROM aluno WHERE cpf = ?";
        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, cpf);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                System.out.println(
                        "ID: " + rs.getLong("id") +
                        " | Nome: " + rs.getString("nome") +
                        " | CPF: " + rs.getString("cpf") +
                        " | Idade: " + rs.getInt("idade") +
                        " | Série: " + rs.getString("serie") +
                        " | Turno: " + rs.getString("turno") +
                        " | Telefone: " + rs.getString("telefone")
                );
            } else {
                System.out.println("Aluno não encontrado!");
            }

        } catch (SQLException e) {
            System.out.println("Erro ao buscar aluno: " + e.getMessage());
        }
    }

    public void editarAluno(String cpf, Scanner sc) {
        String sqlBusca = "SELECT * FROM aluno WHERE cpf = ?";
        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmtBusca = conn.prepareStatement(sqlBusca)) {

            stmtBusca.setString(1, cpf);
            ResultSet rs = stmtBusca.executeQuery();

            if (!rs.next()) {
                System.out.println("Aluno não encontrado!");
                return;
            }

            System.out.print("Novo nome: ");
            String novoNome = sc.nextLine();
            System.out.print("Nova idade: ");
            int novaIdade = sc.nextInt(); sc.nextLine();
            System.out.print("Nova série: ");
            String novaSerie = sc.nextLine();
            System.out.print("Novo turno: ");
            String novoTurno = sc.nextLine();
            System.out.print("Novo telefone: ");
            String novoTel = sc.nextLine();

            String sqlEdita = "UPDATE aluno SET nome=?, idade=?, serie=?, turno=?, telefone=? WHERE cpf=?";
            try (PreparedStatement stmtEdita = conn.prepareStatement(sqlEdita)) {
                stmtEdita.setString(1, novoNome);
                stmtEdita.setInt(2, novaIdade);
                stmtEdita.setString(3, novaSerie);
                stmtEdita.setString(4, novoTurno);
                stmtEdita.setString(5, novoTel);
                stmtEdita.setString(6, cpf);
                stmtEdita.executeUpdate();
                System.out.println("Aluno atualizado com sucesso!");
            }

        } catch (SQLException e) {
            System.out.println("Erro ao editar aluno: " + e.getMessage());
        }
    }

    public void removerAluno(String cpf) {
        String sql = "DELETE FROM aluno WHERE cpf = ?";
        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, cpf);
            int affected = stmt.executeUpdate();
            if (affected > 0) {
                System.out.println("Aluno removido com sucesso!");
            } else {
                System.out.println("Aluno não encontrado!");
            }

        } catch (SQLException e) {
            System.out.println("Erro ao remover aluno: " + e.getMessage());
        }
    }
}
