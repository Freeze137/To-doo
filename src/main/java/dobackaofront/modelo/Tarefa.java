package br.com.dobackaofront.modelo;

import java.time.LocalDateTime;

public class Tarefa {
    private Long id;
    private String titulo;
    private String descricao;
    private boolean completa;
    private LocalDateTime dataHora;

    public Tarefa(Long id, String titulo, String descricao) {
        this.id = id;
        this.titulo = titulo;
        this.descricao = descricao;
        this.completa = false;
        this.dataHora = LocalDateTime.now();
    }

    public Long getId() { return id; }
    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }

    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }

    public boolean isCompleta() { return completa; }
    public void setCompleta(boolean completa) { this.completa = completa; }

    public LocalDateTime getDataHora() { return dataHora; }

    @Override
    public String toString() {
        return "ID: " + id + " | " + titulo + " - " + descricao +
               " | Status: " + (completa ? "Concluída" : "Pendente");
    }
}
