package br.com.dobackaofront.controle;

import br.com.dobackaofront.modelo.Tarefa;
import java.sql.*;
import java.util.ArrayList;

public class TarefaServico {

    public void criar(String titulo, String descricao) {
        String sql = "INSERT INTO tarefa (titulo, descricao, status, data_entrega, disciplina_id) VALUES (?, ?, false, datetime('now'), 1)";
        try (Connection con = Conexao.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, titulo);
            ps.setString(2, descricao);
            ps.executeUpdate();
            System.out.println("✅ Tarefa criada com sucesso!");
        } catch (SQLException e) {
            System.out.println("❌ Erro ao criar tarefa: " + e.getMessage());
        }
    }

    public void listar() {
        String sql = "SELECT id, titulo, descricao, status FROM tarefa";
        try (Connection con = Conexao.getConnection();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            boolean tem = false;
            while (rs.next()) {
                tem = true;
                Long id = rs.getLong("id");
                String titulo = rs.getString("titulo");
                String descricao = rs.getString("descricao");
                boolean status = rs.getBoolean("status");

                System.out.println("ID: " + id + " | " + titulo + " - " + descricao +
                        " | Status: " + (status ? "Concluída" : "Pendente"));
            }
            if (!tem) System.out.println("⚠️ Nenhuma tarefa cadastrada!");

        } catch (SQLException e) {
            System.out.println("❌ Erro ao listar tarefas: " + e.getMessage());
        }
    }

    public void editar(Long id, String novoTitulo, String novaDescricao) {
        String sql = "UPDATE tarefa SET titulo = ?, descricao = ? WHERE id = ?";
        try (Connection con = Conexao.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, novoTitulo);
            ps.setString(2, novaDescricao);
            ps.setLong(3, id);

            int atualizado = ps.executeUpdate();
            if (atualizado > 0)
                System.out.println("✅ Tarefa atualizada com sucesso!");
            else
                System.out.println("⚠️ Tarefa não encontrada!");

        } catch (SQLException e) {
            System.out.println("❌ Erro ao atualizar tarefa: " + e.getMessage());
        }
    }

    public void concluir(Long id) {
        String sql = "UPDATE tarefa SET status = true WHERE id = ?";
        try (Connection con = Conexao.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setLong(1, id);
            int atualizado = ps.executeUpdate();
            if (atualizado > 0)
                System.out.println("✅ Tarefa marcada como concluída!");
            else
                System.out.println("⚠️ Tarefa não encontrada!");

        } catch (SQLException e) {
            System.out.println("❌ Erro ao concluir tarefa: " + e.getMessage());
        }
    }

    public void remover(Long id) {
        String sql = "DELETE FROM tarefa WHERE id = ?";
        try (Connection con = Conexao.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setLong(1, id);
            int removido = ps.executeUpdate();
            if (removido > 0)
                System.out.println("✅ Tarefa removida com sucesso!");
            else
                System.out.println("⚠️ Tarefa não encontrada!");

        } catch (SQLException e) {
            System.out.println("❌ Erro ao remover tarefa: " + e.getMessage());
        }
    }

    public ArrayList<Tarefa> buscarPorTitulo(String palavraChave) {
        ArrayList<Tarefa> resultado = new ArrayList<>();
        String sql = "SELECT id, titulo, descricao, status FROM tarefa WHERE titulo LIKE ?";

        try (Connection con = Conexao.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, "%" + palavraChave + "%");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Long id = rs.getLong("id");
                String titulo = rs.getString("titulo");
                String descricao = rs.getString("descricao");
                boolean status = rs.getBoolean("status");

                Tarefa t = new Tarefa(id, titulo, descricao);
                t.setCompleta(status);
                resultado.add(t);
            }

        } catch (SQLException e) {
            System.out.println("❌ Erro ao buscar tarefas: " + e.getMessage());
        }

        return resultado;
    }
}
