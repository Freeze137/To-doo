Projeto de Cadastro de Alunos (Matrícula Escolar)

Este é um projeto simples de CRUD (Criar, Ler, Atualizar, Deletar) para um sistema de matrícula escolar, desenvolvido em Java e utilizando um banco de dados MySQL para persistência dos dados.

Funcionalidades (CRUD):
Cadastrar Aluno (CREATE): Adiciona um novo registro de aluno ao banco de dados.
Listar Alunos (READ): Consulta e exibe todos os alunos registrados.
Buscar Aluno por CPF (READ): Busca um aluno específico para consulta.
Editar Aluno (UPDATE): Modifica os dados de um aluno existente (ex: turno, telefone).
Remover Aluno (DELETE): Remove permanentemente um aluno do banco de dados.

Estrutura do Projeto (Pacotes):
Classe Aluno (Pacote `modelo`):
 Serve como o molde para criar objetos que representam um aluno.
 Atributos: id (PK), nome, cpf , idade, serie, turno, telefone.
 Métodos: Possui *getters* e *setters* para manipular os atributos.

Classe AlunoServico (Pacote controle):
É o "cérebro" da aplicação.]Implementa toda a lógica CRUD.
   Responsabilidade: Recebe os dados da interface e interage com o banco de dados (via Conexao) para executar comandos SQL.

Classe Conexao (Pacote controle):
 Classe utilitária responsável por estabelecer e retornar a conexão com o banco de dados MySQL.

Classe Main (Pacote visao):
 É o ponto de entrada do programa e a interface de terminal (CLI).
  Responsabilidade: Exibe o menu, lê a entrada do usuário, e chama os métodos do AlunoServico.
