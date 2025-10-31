-- 1. Criar o banco de dados
CREATE DATABASE IF NOT EXISTS matricula_escolar;
USE matricula_escolar;

-- 2. Criar tabela Aluno
CREATE TABLE IF NOT EXISTS aluno (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(150) NOT NULL,
    cpf VARCHAR(14) NOT NULL UNIQUE,
    idade INT NOT NULL,
    serie VARCHAR(50) NOT NULL,
    turno VARCHAR(20) NOT NULL,
    telefone VARCHAR(20)
);

-- 3. Inserir alguns alunos de teste
INSERT INTO aluno (nome, cpf, idade, serie, turno, telefone) VALUES
('Pedro Amaral', '123.456.789-00', 10, 'Fundamental 1', 'Matutino', '61999990000'),
('Maria Silva', '987.654.321-00', 14, 'Fundamental 2', 'Vespertino', '61988881111'),
('João Souza', '111.222.333-44', 16, 'Médio', 'Matutino', '61977772222');

-- 4. Consultar todos os alunos
SELECT * FROM aluno;
SHOW DATABASES;
USE matricula_escolar;
