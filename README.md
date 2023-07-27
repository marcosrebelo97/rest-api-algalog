<h2 align="center"><br/> Aplicação Algalog</h2>
    
![Badge em Desenvolvimento](http://img.shields.io/static/v1?label=STATUS&message=EM%20DESENVOLVIMENTO&color=GREEN&style=for-the-badge)

  - ### Descrição:
    O projeto consiste em um sistema básico de logística, criado para gerenciamento de entregas (delivery), através do cadastro de dados de uma entrega, registro dos relacionamentos com o respectivo Cliente e Destinatário, e o controle do fluxo da entrega, por meio do status, com possibilidades de registrar o histórico de possíveis ocorrências relacionadas as entregas.

  - ### Tabela de Conteúdos:
    - [Modelo de Domínio](#modelo-de-domínio)
    - [Arquitetura](#arquitetura)
    - [Endpoints](#endpoints)
    - [Instruções para Executar](instruções-para-executar)
    - [Tecnologias Utilizadas](#tecnologias-utilizadas)

  - ### Modelo de Domínio
  Este é o modelo de domínio definido para o projeto, foi construído utilizando a ferramenta de modelagem Astah, na versão gratuíta Community, nele é possível visualizar as tabelas, atributos, relacionamentos, cardinalidades e chaves primárias.

![diagrama-classe](https://github.com/marcosrebelo97/rest-api-algalog/assets/37541973/3d19948b-57e6-4e07-8f58-8516fc9363c5)
  
  - ### Arquitetura
    A arquitetura da aplicação segue o padrão MVC, incluindo camadas de Modelo, Repositório, Serviço e Controlador, além de manipuladores de exceções personalizados para fornecer respostas de erro mais úteis e informativas.

    ![image](https://github.com/marcosrebelo97/rest-api-algalog/assets/37541973/5b070470-f4c7-4f55-a2bd-a8811ea5baf7)


  - ### Endpoints:
    A seguir, estão listados os principais endpoints da API com suas respectivas funcionalidades:

    <details>
    <summary>Visualizar aqui.</summary>
    
    #### Clientes
    
    | Rest  | Request              | Funcionalidade |
    |-------|----------------------| ------- |
    | PUT   | Clientes - Atualizar | Atualiza os dados cadastrados de um Cliente |
    | POST  | Clientes - Cadastrar | Realiza o cadastro de dados de um Cliente |
    | DEL   | Clientes - Excluir   | Exclui o cadastro de um Cliente através do ID |
    | GET   | Clientes - Listar    | Retorna todos os Clientes e seus respectivos dados cadastrados na plataforma |
    | POST  | Clientes - Buscar    | Permite que o usuário pesquise por um Cliente específico através do ID |
    
    #### Entregas
    
    | Rest  | Request              | Funcionalidade |
    |-------|----------------------| ------- |
    | GET   | Entregas - Listar    | Retorna todas as entregas cadastradas, dados de destinatários e taxa de delivery |
    | GET   | Entregas - Obter ID  | Retorna os dados de uma Entrega específica através do ID |
    | POST  | Entregas - Solicitar |  
    
    #### Ocorrências
    
    | Rest  | Request                | Funcionalidade |
    |-------|------------------------| ------- |
    | GET   | Ocorrências - Listar    | Retorna os dados das Entregas que tiveram (ou não) alguma Ocorrência durante o delivery |
    | POST  | Ocorrências - Solicitar | 
    
    </details>

    #### Todos os endpoints estão disponíveis para testes, feedbacks e afins. Clique no botão abaixo para abrir no Postman.
    
    [![Run in Postman](https://run.pstmn.io/button.svg)](https://gold-eclipse-442776.postman.co/collection/19986209-8171bf70-4c4d-4b15-981b-405301adc942?source=rip_markdown)



  ## Tecnologias Utilizadas
  - Java (JDK 17)
  - Spring Boot
  - Spring Data JPA / Hibernate
  - Spring Boot Web
  - Flyway
  - Lombok
  - Maven
  - H2 Datbase
  - PostgreSQL
  - Postman
