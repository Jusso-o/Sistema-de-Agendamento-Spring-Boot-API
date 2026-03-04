# 📅 Sistema de Agendamento – Spring Boot API

**Sistema-de-Agendamento-Spring-Boot-API**

Um serviço REST simples para gerenciar agendamentos de serviços (ex.: corte de cabelo, consultas, etc.)
Construído com Java, Spring Boot, Spring Data JPA e banco de dados em memória H2.

---

## 🚀 Visão geral

Este micro‑serviço expõe endpoints para:

1. Criar um agendamento
2. Alterar um agendamento existente
3. Deletar um agendamento
4. Listar todos os agendamentos de um dia

Cada agendamento contém serviço, profissional, data/hora, cliente e dados de contato.
Regras de negócio incluem restrição de horário ocupado e validação básica.

O código segue a arquitetura típica tri‑camadas (`controller → service → repository → entity`) e utiliza [Lombok](https://projectlombok.org) para reduzir boilerplate.

---

## 🛠 Tecnologias

- Java 17+
- Spring Boot 3.x (Spring Web, Spring Data JPA)
- Banco H2 (in‑memory, console disponível)
- Lombok
- Maven

---

## 📋 Estrutura de pacotes

```
src/
  main/
    java/
      Kauaprojeto.Sistema_agendamento/
        SistemaAgendamentoApplication.java       # classe principal
        controller/                              # AgendamentoController
        services/                                # AgendamentoService
        infrastructure/
          entity/                                # Agendamento.java (JPA @Entity)
          repository/                            # AgendamentoRepository (JpaRepository)
```

---

## ⚙️ Pré‑requisitos

- JDK 17 (ou superior)
- Maven 3.6+
- (Opcional) Cliente HTTP como `curl`, Postman, Insomnia

---

## 🧪 Como executar

1. Abra um terminal e vá para a pasta do projeto:
   ```bash
   cd Sistema-agendamento/Sistema-agendamento
   ```
2. Compile e execute com Maven:
   ```bash
   mvn clean spring-boot:run
   ```
3. A API estará acessível em `http://localhost:8080`.
4. Para inspecionar a base H2, abra o console em `http://localhost:8080/h2-console`:
   - JDBC URL: `jdbc:h2:mem:agendamentos-db`
   - Usuário: `agenda` (senha em branco)

---

## 📡 Endpoints

| Método | URL                   | Descrição                                   | Parâmetros/Corpo |
|--------|-----------------------|---------------------------------------------|------------------|
| POST   | `/agendamentos`       | Cria novo agendamento.                      | JSON `Agendamento` |
| DELETE | `/agendamentos`       | Deleta pelo cliente e data/hora.            | `cliente`, `dataHoraAgendamento` (query) |
| GET    | `/agendamentos`       | Lista agendamentos de um dia.               | `data` (query, yyyy-MM-dd) |
| PUT    | `/agendamentos`       | Atualiza agendamento existente.             | JSON `Agendamento` + `cliente`, `dataHoraAgendamento` (query) |

### 🧩 Exemplo de payload (JSON)

```json
{
  "servico": "Corte de cabelo",
  "profissional": "João",
  "dataHoraAgendamento": "2026-03-10T14:00:00",
  "cliente": "Maria",
  "contatoCliente": "maria@example.com"
}
```

### ❌ Validações e regras

- Não é permitido criar dois horários para o **mesmo serviço** no intervalo de uma hora.
- A atualização verifica se o agendamento informado existe; caso contrário, lança exceção.
- Exclusões são silenciosas (sem retorno de erro se não existir).

> 💡 As exceções atuais são gerais (`RuntimeException`). Em produção, recomenda‑se utilizar `@ControllerAdvice` para tratamento adequado com respostas customizadas.

---

## 🧩 Modelo de dados

```java
@Entity
@Table(name = "agendamento")
public class Agendamento {
    @Id @GeneratedValue
    private Long id;
    private String servico;
    private String profissional;
    private LocalDateTime dataHoraAgendamento;
    private String cliente;
    private String contatoCliente;
    private LocalDateTime dataInsercao = LocalDateTime.now();
}
```

---

## ✅ Testes

Há um teste de contexto Spring (`SistemaAgendamentoApplicationTests`) para garantir que a aplicação inicia corretamente. Recomenda‑se adicionar:

- Testes de unidade para `AgendamentoService`.
- Testes de integração para o controller usando `@WebMvcTest` ou testes com `MockMvc`.

---

## 📁 Observações

- Projeto está pronto para migração a outros bancos apenas alterando `application.properties`.
- Camadas estão desacopladas para facilitar manutenção e evolução.

---

## 🛎️ Contribuindo

1. Faça um fork
2. Crie uma branch (`feature/alguma-coisa`)
3. Abra um Pull Request descrevendo suas melhorias

---

🎯 **Pronto!** Este `README` serve como ponto de partida claro e atrativo para qualquer pessoa que chegar ao repositório. Sinta‑se livre para adicionar badges, capturas de tela ou instruções adicionais conforme desejar.
