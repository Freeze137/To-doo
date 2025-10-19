package modelo;

public class Aluno {
    private Long id;
    private String nome;
    private String cpf;
    private int idade;
    private String serie;
    private String turno;
    private String telefone;

    public Aluno() {}

    public Aluno(String nome, String cpf, int idade, String serie, String turno, String telefone) {
        this.nome = nome;
        this.cpf = cpf;
        this.idade = idade;
        this.serie = serie;
        this.turno = turno;
        this.telefone = telefone;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getCpf() { return cpf; }
    public void setCpf(String cpf) { this.cpf = cpf; }

    public int getIdade() { return idade; }
    public void setIdade(int idade) { this.idade = idade; }

    public String getSerie() { return serie; }
    public void setSerie(String serie) { this.serie = serie; }

    public String getTurno() { return turno; }
    public void setTurno(String turno) { this.turno = turno; }

    public String getTelefone() { return telefone; }
    public void setTelefone(String telefone) { this.telefone = telefone; }

    @Override
    public String toString() {
        return "ID: " + id + " | Nome: " + nome + " | CPF: " + cpf + " | Idade: " + idade +
               " | Série: " + serie + " | Turno: " + turno + " | Telefone: " + telefone;
    }
}
