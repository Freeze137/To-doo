Projeto: Sistema de Matrícula Escolar:

Visão Geral
Este é um projeto de um sistema de Matrícula Escolar desenvolvido para gerenciar o ciclo de vida completo do dado do aluno, utilizando o CRUD (Create, Read, Update, Delete). O sistema foi feito em pacotes (modelo, controle e visao) para separar as responsabilidades e implementar a lógica de negócio e a interação com o banco de dados MySQL.

Público-Alvo
O público-alvo é qualquer instituição que necessita realizar as operações administrativas de cadastro e gerenciamento de alunos como escolas, uninversidades ou academias.

O Problema a Ser Resolvido
O sistema resolve o problema da gestão manual ou ineficiente dos dados de alunos. Ele padroniza as operações essenciais para o ciclo de vida de um registro, garantindo que as informações dos alunos possam ser criadas, consultadas, modificadas e excluídas de forma organizada e persistente em um banco de dados.

Objetivo do Sistema
O objetivo principal é oferecer uma aplicação que demonstre a capacidade de realizar as quatro operações essenciais (CRUD) sobre a entidade `Aluno`. Isso é alcançado por meio de uma interface de terminal que interage com uma camada de serviço (`AlunoServico`) para persistir os dados no banco.

 Funcionalidades do Sistema (CRUD)
O sistema oferece as seguintes funcionalidades básicas, apresentadas ao usuário via menu (classe `Main`):

CREATE(Criar) = Opção 1: Cadastrar Aluno -> Adiciona um novo registro de aluno ao banco de dados. 
READ (Ler) = Opção 2: Listar Alunos -> Consulta e exibe todos os dados dos alunos existentes no banco. 
READ (Ler) = Opção 3: Buscar por CPF -> Busca e retorna os dados de um aluno específico, utilizando o CPF como critério de busca. 
UPDATE (Atualizar) = Opção 4: Editar Aluno -> Permite modificar um registro de aluno já existente no banco de dados (ex: alterar turno ou telefone).
DELETE (Deletar) = Opção 5: Remover Aluno -> Remove permanentemente um registro de aluno do banco de dados.

6. Ferramentas e Tecnologias
   Linguagem de Programação: Java

   IDE (Ambiente de Desenvolvimento): Visual Studio Code (VSCode)

   Banco de Dados: SQL

   Controle de Versão: Git (usando GitHub e GitHub Desktop)
