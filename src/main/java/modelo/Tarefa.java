package modelo;

public class Tarefa {
    private Long id;
    private String titulo;
    private String descricao;
    private boolean completa;

    public Tarefa(Long contadorId, String titulo, String descricao) {
        this.id = contadorId;
        this.titulo = titulo;
        this.descricao = descricao;
        this.completa = false;
    }

    public Tarefa(String titulo, String descricao) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.completa = false;
    }

    public Long getId() { return id; }
    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }

    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }

    public boolean isCompleta() { return completa; }
    public void setCompleta(boolean completa) { this.completa = completa; }

    @Override
    public String toString() {
        return "ID: " + id + " | " + titulo + " - " + descricao +
                " | Status: " + (completa ? "Concluída" : "Pendente");
    }
}

