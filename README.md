Sistema de Agendamento - Spring Boot API
Este projeto é uma API REST robusta desenvolvida para o gerenciamento de agendamentos de serviços. A aplicação foi construída utilizando o ecossistema Spring Boot, focando em escalabilidade, organização em camadas e regras de negócio consistentes.

🚀 Tecnologias e Conceitos Aplicados
Java 24 e Spring Boot 4.0.3: Utilização das versões mais recentes para alta performance e suporte a novos recursos da linguagem.

Spring Data JPA: Abstração da camada de persistência para facilitar operações de CRUD e consultas customizadas.

Banco de Dados H2: Banco de dados em memória configurado para agilidade no ambiente de desenvolvimento e testes.

Lombok: Utilizado para reduzir o código boilerplate (Getters, Setters, Construtores) e manter o código limpo.

Arquitetura em Camadas: Divisão clara entre Controller (Exposição da API), Service (Regras de Negócio), Infrastructure/Entity (Modelo de Dados) e Repository (Acesso aos Dados).

Validação de Conflitos: Lógica implementada para impedir agendamentos duplicados no mesmo horário e serviço.

🏗️ Estrutura do Projeto
AgendamentoController: Gerencia os endpoints REST (GET, POST, PUT, DELETE) e a comunicação com o cliente.

AgendamentoService: Contém a inteligência da aplicação, como a lógica de verificação de disponibilidade e cálculos de horários.

AgendamentoRepository: Interface que utiliza o Query Methods do Spring Data para buscas complexas por períodos de data e hora.

Agendamento (Entity): Representação da tabela no banco de dados, incluindo campos como cliente, profissional, serviço e data de inserção automática.

🛠️ Como Executar a Aplicação
Pré-requisitos: Possuir o JDK (versão 17 ou superior) e o Maven instalados.

Clonar o repositório:
git clone https://github.com/seu-usuario/seu-repositorio.git

Compilar e rodar:
mvn spring-boot:run

🛣️ Endpoints Principais
Método,Endpoint,Descrição
POST,/agendamentos,Cadastra um novo agendamento (Valida se o horário está vago).
GET,/agendamentos,Lista todos os agendamentos de um dia específico.
PUT,/agendamentos,Altera os dados de um agendamento existente.
DELETE,/agendamentos,Remove um agendamento através do nome do cliente e data/hora.

Destaque Técnico: A aplicação faz uso de tipos modernos de data (LocalDateTime) e trata retornos de listas de forma eficiente, garantindo que o cliente da API receba informações precisas sobre os compromissos diários.
