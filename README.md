# 📝 Sistema de Gerenciamento de Tarefas (To-Do List)

Este é um projeto simples de gerenciamento de tarefas (To-Do List) desenvolvido em **Java** utilizando a **Arquitetura Hexagonal** (Ports and Adapters). O sistema permite criar, listar e marcar tarefas como concluídas.

---

##  Como Executar o Projeto

### Pré-requisitos
- **Java 8** ou superior instalado.
- Git (opcional, para clonar o repositório).

### Passos para Execução
1. Clone o repositório (ou baixe o código-fonte):
   ```bash
   git clone https://github.com/tauanehelo/hexagonal.git
   cd hexagonal
   ```

3. Compile o código:
   ```bash
   javac Main.java
   ```

4. Execute o projeto:
   ```bash
   java Main
   ```

5. Siga as instruções no terminal para interagir com o sistema.

---

## Funcionalidades
- **Criar Tarefa:** Adiciona uma nova tarefa com um ID e uma descrição.
- **Listar Tarefas:** Exibe todas as tarefas cadastradas.
- **Marcar Tarefa como Concluída:** Altera o status de uma tarefa para concluída.

---

## Estrutura do Projeto
O projeto segue a **Arquitetura Hexagonal**, dividido em:
- **Core (Domínio):** Contém a lógica de negócio e as entidades (`Tarefa`, `GerenciadorTarefas`).
- **Ports:** Interfaces que definem como o domínio se comunica com o mundo externo (`TarefaRepository`).
- **Adapters:** Implementações concretas das portas (`TarefaRepositoryEmMemoria`, `CLIAdapter`).

### Diretórios Principais
```
hexagonal/
    ├── core/                  # Lógica de negócio e entidades
    ├── ports/                 # Interfaces (Ports)
    └── adapters/              # Implementações (Adapters)
```

---

## Regras de Negócio
- Não é permitido criar duas tarefas com o mesmo ID. O sistema exibirá uma mensagem de erro, mas **não será interrompido**.

---

## Contribuição
Contribuições são bem-vindas! Siga os passos abaixo:
1. Faça um fork do projeto.
2. Crie uma branch para sua feature (`git checkout -b feature/nova-feature`).
3. Commit suas mudanças (`git commit -m 'Adiciona nova feature'`).
4. Push para a branch (`git push origin feature/nova-feature`).
5. Abra um Pull Request.

---

## Autora
- **Tauane Heloise**  
  - GitHub: [@tauanehelo](https://github.com/tauanehelo)  

---