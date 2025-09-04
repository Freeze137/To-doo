package controle;

import modelo.Tarefa;
import java.util.ArrayList;

public class TarefaServico {
    private ArrayList<Tarefa> tarefas;
    private Long contadorId;

    public TarefaServico() {
        tarefas = new ArrayList<>();
        contadorId = 1L;
    }

    public void criar(String titulo, String descricao) {
        Tarefa t = new Tarefa(contadorId, titulo, descricao);
        tarefas.add(t);
        contadorId++;
        System.out.println("Tarefa criada com sucesso!");
    }

    public void listar() {
        if (tarefas.isEmpty()) {
            System.out.println("Nenhuma tarefa cadastrada!");
        } else {
            for (Tarefa t : tarefas) {
                System.out.println(t);
            }
        }
    }

    public void editar(Long id, String novoTitulo, String novaDescricao) {
        Tarefa t = buscarPorId(id);
        if (t != null) {
            t.setTitulo(novoTitulo);
            t.setDescricao(novaDescricao);
            System.out.println("Tarefa atualizada com sucesso!");
        } else {
            System.out.println("Tarefa não encontrada!");
        }
    }

    public void concluir(Long id) {
        Tarefa t = buscarPorId(id);
        if (t != null) {
            t.setCompleta(true);
            System.out.println("Tarefa marcada como concluída!");
        } else {
            System.out.println("Tarefa não encontrada!");
        }
    }

    public void remover(Long id) {
        Tarefa t = buscarPorId(id);
        if (t != null) {
            tarefas.remove(t);
            System.out.println("Tarefa removida com sucesso!");
        } else {
            System.out.println("Tarefa não encontrada!");
        }
    }

    public Tarefa buscarPorId(Long id) {
        for (Tarefa t : tarefas) {
            if (t.getId().equals(id)) {
                return t;
            }
        }
        return null;
    }

    public ArrayList<Tarefa> buscarPorTitulo(String palavraChave) {
        ArrayList<Tarefa> resultado = new ArrayList<>();
        for (Tarefa t : tarefas) {
            if (t.getTitulo().toLowerCase().contains(palavraChave.toLowerCase())) {
                resultado.add(t);
            }
        }
        return resultado;
    }

    public ArrayList<Tarefa> filtrarPorStatus(boolean concluida) {
        ArrayList<Tarefa> resultado = new ArrayList<>();
        for (Tarefa t : tarefas) {
            if (t.isCompleta() == concluida) {
                resultado.add(t);
            }
        }
        return resultado;
    }

    public ArrayList<Tarefa> getTarefas() {
        return tarefas;
    }
}

