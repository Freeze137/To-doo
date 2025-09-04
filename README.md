# To-doo

Projeto de lista de afazeres (To-do List) desenvolvido em Java, utilizando conceitos de POO e CRUD, com armazenamento em memória através de⁠ ArrayList.

Funcionalidades
•⁠  Cadastrar tarefas  
•⁠  Listar tarefas  
•⁠  ⁠Editar tarefas  
•⁠  Excluir tarefas  
•⁠  ⁠Marcar tarefas como concluídas  

Estrutura do Projeto
•⁠  ⁠Classe ⁠ Tarefa ⁠  
  - Atributos: ⁠ id ⁠, ⁠ titulo ⁠, ⁠ descricao ⁠, ⁠ completa ⁠, ⁠ dataAgora ⁠  
  - Métodos getters e setters  

•⁠  ⁠Classe ⁠ TarefaServico ⁠ 
  - Responsável pelas operações de criar, listar, atualizar e remover tarefas  
  - Contador de IDs automáticos para identificar cada tarefa  

•⁠  ⁠Classe Principal (CLI)  
  - Exibe menu interativo no console  
  - Integra os métodos de serviço  
  - Permite interação do usuário para gerenciar tarefas  
