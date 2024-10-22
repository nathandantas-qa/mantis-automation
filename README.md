## Teste Técnico em Java para Automação do MantisBT 🚀
[![Build and Test](https://github.com/nathandantas-qa/mantis-automation/actions/workflows/ci.yml/badge.svg)](https://github.com/nathandantas-qa/mantis-automation/actions/workflows/ci.yml)

## Objetivo

Este projeto demonstra minhas habilidades em testes automatizados utilizando Java, com foco em cobrir funcionalidades críticas do **MantisBT**, uma ferramenta popular de gerenciamento de bugs. O código foi desenvolvido utilizando as Page Object Model (POM),  priorizando a reutilização e a manutenibilidade. Além disso, o projeto foi concebido com uma arquitetura escalável,  permitindo a execução em diferentes ambientes de teste (embora, neste momento, apenas o ambiente local esteja implementado), e incorpora a capacidade de lidar com diferentes idiomas.

## Tecnologias Utilizadas

* **Linguagem de Programação:** Java 21
* **Framework de Automação Web:** Selenium WebDriver 4.25.0
* **Gerenciador de Dependências:** Maven 
* **Framework de Testes:** TestNG 7.10.2
* **Padrão de Projeto:** Page Objects Model (POM)
* **Relatórios de Teste:** Allure Reports 2.24.0
* **Processamento JSON:** Gson 2.11.0

## Estrutura do Projeto

```
├── src
│   └── test
│       └── java
│           ├── config        // Classes para gerenciar configurações e ler arquivos de propriedades
│           ├── driver        // Classes relacionadas à  configuração e  gerenciamento do  WebDriver
│           ├── enums         // Enumerações (enums) para representar valores constantes
│           ├── helper       // Classes auxiliares com métodos reutilizáveis para os testes
│           ├── page         // Classes Page Object que representam as páginas da aplicação
│           ├── pojo         // POJOs (Plain Old Java Objects) para representar entidades/dados
│           └── test         // Classes de teste organizadas por funcionalidade
└── pom.xml                     // Arquivo de configuração do Maven                    
```

## Cenários de Teste Implementados

**Funcionalidades:**

* **Login:**
    * CT01 - Login com sucesso
    * CT02 - Login com credenciais inválidas 
* **Gerenciamento de Tarefas:**
    * CT03 - Criar uma nova tarefa com informações obrigatórias 

## Estratégia de Testes

O sistema alvo dos testes automatizados é o MantisBT. O foco principal é a priorização dos testes, demonstrando a capacidade de aplicar boas práticas de automação.

**Contexto do Teste Técnico:**

Como este é um projeto de desafio, e não há requisitos específicos de negócio ou acesso a dados de produção para aplicar técnicas de teste como particionamento de equivalência, análise do valor limite e tabela de decisão, os casos de teste a seguir foram gerados por IA. Os valores preenchidos para os itens FC, FUC, AI e AP também foram preenchidos por IA para fins didáticos. Em um projeto real, o ideal é consultar o Product Owner (PO) e os dados de monitoramento da aplicação para obter mais precisão.

**Tipos de Testes:**

- **Testes de UI (End-to-End):** Simulam o comportamento de um usuário real, interagindo com a interface do usuário.

**Casos de Teste (CT):**

| Caso de Teste (CT)                                               | Tipo        | FC | FUC | AI | AP | Prioridade | Status       |
|-------------------------------------------------------------------|-------------|----|-----|----|----|------------|--------------|
| CT01 - Login com sucesso (UI)                                    | UI          | 5  | 5   | 5  | 5  | **125**     | Completo    |
| CT03 - Criar tarefa com campos obrigatórios (UI)                 | UI          | 5  | 5   | 5  | 3  | **75**      | Completo | 
| CT05 - Criar tarefa via API (campos obrigatórios)                | API         | 5  | 5   | 5  | 3  | **75**      | Bloqueado |
| CT02 - Login com credenciais inválidas (UI)                       | UI          | 3  | 4   | 5  | 3  | **52.5**    | Completo     |
| CT15 - Editar usuário via API                                   | API         | 4  | 2   | 4  | 3  | **36**      | Bloqueado     |
| CT06 - Criar tarefa via API (todos os campos)                     | API         | 4  | 4   | 4  | 2  | **32**      | Bloqueado     |
| CT09 - Visualizar tarefas (UI)                                   | UI          | 4  | 4   | 4  | 2  | **32**      | A Fazer     |
| CT10 - Obter lista de tarefas via API                            | API         | 4  | 4   | 4  | 2  | **32**      | Bloqueado   |
| CT08 - Tentar criar tarefa via API (dados inválidos)             | API         | 3  | 2   | 4  | 3  | **30**      | Bloqueado   |
| CT16 - Atualizar privilégios de usuário via API                  | API         | 4  | 1   | 4  | 3  | **30**      | Bloqueado   |
| CT04 - Tentar criar tarefa com campos obrigatórios vazios (UI)   | UI          | 4  | 3   | 4  | 2  | **28**      | A Fazer     |
| CT07 - Tentar criar tarefa via API (campos obrigatórios vazios)  | API         | 4  | 3   | 4  | 2  | **28**      | Bloqueado   |
| CT12 - Editar tarefa (UI)                                       | UI          | 4  | 3   | 4  | 2  | **28**      | A Fazer     | 
| CT13 - Editar tarefa via API                                     | API         | 4  | 3   | 4  | 2  | **28**      | Bloqueado   |
| CT17 - Adicionar perfil (UI)                                    | UI          | 3  | 2   | 3  | 2  | **15**      | A Fazer     | 
| CT18 - Editar perfil (UI)                                       | UI          | 3  | 2   | 3  | 2  | **15**      | A Fazer     | 
| CT11 - Obter tarefa por ID via API                               | API         | 3  | 3   | 3  | 1  | **9**       | Bloqueado   |

**Critérios para Automação:**

- **Funcionalidade Crítica (FC):** Quão essencial é a funcionalidade para o funcionamento do sistema? (1-5, sendo 5 o mais crítico)
- **Fluxo de Usuário Comum (FUC):** Com que frequência os usuários utilizam essa funcionalidade? (1-5, sendo 5 o mais comum)
- **Área de Impacto (AI):** Qual o impacto de um erro nesta funcionalidade no sistema como um todo? (1-5, sendo 5 o maior impacto)
- **Área de Probabilidade (AP):** Qual a probabilidade de erros ocorrerem nesta funcionalidade? (1-5, sendo 5 a maior probabilidade)

**Priorização:**

A prioridade de automação é calculada usando a seguinte fórmula: **(FC + FUC) / 2 * AI * AP**

## Execução dos Testes

**Pré-requisitos:**

* Java Development Kit (JDK) 21 ou superior
* Maven 
* Git

**Passos:**

1. **Clonar o  Repositório:** 
   ```bash
   git clone https://github.com/seu-usuario/mantis-automation.git
   ```
2. **Acessar o  Diretório do  Projeto:**
   ```bash
   cd mantis-automation
   ```
3. **Executar os  Testes:**
   ```bash
   mvn test
   ```

## Relatórios de  Teste com  Allure

**Gerar Relatório Localmente:**

```bash
mvn allure:serve
```

**Acesso:** Um  servidor web será iniciado. Acesse o  relatório no  endereço indicado no  console.

**GitHub Actions:**

* Os testes são  executados automaticamente no  GitHub Actions a  cada push ou  pull request.
* Os relatórios do  Allure são  gerados e  disponibilizados na  aba "Actions" do  repositório.

## Destaques da Arquitetura

**Tratamento de Idiomas:**

O projeto foi preparado para suportar diferentes idiomas, proporcionando uma experiência de  usuário mais amigável para um  público global. A  classe `MessageLoader` carrega mensagens de  erro e  de  sucesso em  diferentes idiomas a  partir de  um  arquivo JSON, permitindo que os  testes sejam executados com  base no  idioma configurado.

**Arquitetura Escalável:**

A  arquitetura do  projeto foi  projetada para escalabilidade e  flexibilidade, permitindo a  execução de  testes em  diferentes ambientes (local,  remoto,  grid) com  facilidade. **Embora, neste momento, apenas o ambiente local esteja implementado**, a estrutura está preparada para ser facilmente estendida para outros ambientes. A  classe `TargetFactory` utiliza o  padrão Factory para criar instâncias do  WebDriver de  acordo com a  configuração, enquanto o  `DriverManager` gerencia o  ciclo de  vida do  WebDriver usando `ThreadLocal`, garantindo a  independência entre os  testes em  execuções paralelas. 
