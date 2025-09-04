package service;

import modelo.Tarefa;
import java.util.ArrayList;

public class TarefaServico {
    private ArrayList<Tarefa> lista = new ArrayList<>();
    private int contadorId = 1;

    public void criar(String titulo, String descricao) {
        Tarefa t = new Tarefa(contadorId++, titulo, descricao);
        lista.add(t);
        System.out.println("Tarefa criada!");
    }

    public void listar() {
        if (lista.isEmpty()) {
            System.out.println("Nenhuma tarefa cadastrada.");
        } else {
            for (Tarefa t : lista) {
                System.out.println(t);
            }
        }
    }

    public void editar(int id, String novoTitulo, String novaDescricao) {
        for (Tarefa t : lista) {
            if (t.getId() == id) {
                t.setTitulo(novoTitulo);
                t.setDescricao(novaDescricao);
                System.out.println("Tarefa atualizada!");
                return;
            }
        }
        System.out.println("Tarefa não encontrada.");
    }

    public void concluir(int id) {
        for (Tarefa t : lista) {
            if (t.getId() == id) {
                t.setCompleta(true);
                System.out.println("Tarefa concluída!");
                return;
            }
        }
        System.out.println("Tarefa não encontrada.");
    }

    public void remover(int id) {
        Tarefa remover = null;
        for (Tarefa t : lista) {
            if (t.getId() == id) {
                remover = t;
            }
        }
        if (remover != null) {
            lista.remove(remover);
            System.out.println("Tarefa removida!");
        } else {
            System.out.println("Tarefa não encontrada.");
        }
    }
}
