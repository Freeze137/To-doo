-- Criar banco de dados
CREATE DATABASE sistema_escolar_basico;
USE sistema_escolar_basico;

-- Tabela DISCIPLINA
CREATE TABLE disciplina (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    professor VARCHAR(100) NOT NULL,
    dia_da_aula DATE NOT NULL
);

-- Tabela TAREFA
CREATE TABLE tarefa (
    id INT AUTO_INCREMENT PRIMARY KEY,
    titulo VARCHAR(150) NOT NULL,
    descricao TEXT,
    status BOOLEAN DEFAULT FALSE,
    data_entrega DATE,
    disciplina_id INT NOT NULL,
    FOREIGN KEY (disciplina_id) REFERENCES disciplina(id)
);

-- Inserindo alguns dados de exemplo
INSERT INTO disciplina (nome, professor, dia_da_aula) VALUES
('Estrutura de Dados', 'Maria Souza', '2025-09-25'),
('Banco de Dados', 'Carlos Lima', '2025-09-26');

INSERT INTO tarefa (titulo, descricao, status, data_entrega, disciplina_id) VALUES
('Implementar lista encadeada', 'Fazer em C usando ponteiros', FALSE, '2025-10-01', 1),
('Criar DER', 'Modelo de entidades e relacionamentos', TRUE, '2025-09-20', 2);
