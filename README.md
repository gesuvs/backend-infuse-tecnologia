# Projeto API de Consulta de Créditos

Esta é uma API RESTful desenvolvida com **Spring Boot** utilizando **arquitetura limpa**, que permite consultar créditos constituídos com base no número da NFS-e ou no número do crédito.

## Tecnologias Utilizadas

- Java 17
- Spring Boot 3+
- Spring Data JPA
- PostgreSQL
- Apache Kafka (modo KRaft - sem Zookeeper)
- Kafka UI
- Docker e Docker Compose
- Testes com JUnit 5 e Spring Kafka Test
- Arquitetura Limpa

---

## Arquitetura do Projeto

O projeto segue os princípios da **Arquitetura Limpa**, separando responsabilidades em camadas bem definidas:

```
├── application           # Casos de uso (UseCases)
├── domain               # Entidades e interfaces
├── infrastructure       # Implementação de repositórios e mensageria
├── interfaces           # Controllers REST
├── config               # Configurações gerais (CORS, Kafka, Web)
```

### Principais Pacotes:
- `application.usecases`: Contém a lógica de negócio para listagem de créditos.
- `infrastructure.persistence`: Implementa os repositórios com JPA.
- `infrastructure.messaging`: Publica eventos Kafka.
- `interfaces.controller`: Exposição de endpoints REST.
- `config.kafka`: Configuração de produtores Kafka.

---

## Banco de Dados
- Banco utilizado: **PostgreSQL 16**
- Criado via Docker Compose com volume persistente.

### Exemplo de configuração:
```yaml
spring:
  datasource:
    url: jdbc:postgresql://postgres:5432/creditos_db
    username: postgres
    password: postgres
```

---

## Kafka (Modo Kraft)

- Kafka executando **sem Zookeeper**, usando **Bitnami Kafka** com KRaft habilitado.
- Tópico utilizado: `consulta.credito`
- Kafka UI em http://localhost:8080

---

## Testes

### Testes de Integração com Kafka

- Utiliza `@EmbeddedKafka` para simular ambiente Kafka real.
- Testa se o evento é publicado corretamente ao consultar dados.

```java
@EmbeddedKafka(partitions = 1, topics = {"consulta.credito"})
```

---

## Como Rodar o Projeto

### 1. Clonar o projeto
```bash
git clone https://github.com/seuusuario/creditos-api.git
cd creditos-api
```

### 2. Subir os containers com Docker Compose
```bash
docker-compose up --build
```

A aplicação ficará disponível em: `http://localhost:3000`

Kafka UI: `http://localhost:8080`

---

## Endpoints Disponíveis

### Consulta por Número da NFS-e
```
GET /api/creditos/{numeroNfse}
```
**Exemplo:**
```bash
curl http://localhost:3000/api/creditos/7891011
```

### Consulta por Número do Crédito
```
GET /api/creditos/credito/{numeroCredito}
```
**Exemplo:**
```bash
curl http://localhost:3000/api/creditos/credito/789012
```

---

## WebConfig (CORS)

O `WebConfig` está localizado em `config.WebConfig` e habilita o CORS para o front-end Angular:

```java
registry.addMapping("/**")
        .allowedOrigins("http://localhost:4200")
        .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS");
```

---

## Melhorias Futuras

- Paginação e ordenação nas consultas
- Cache de consultas recentes
- Autenticação via OAuth2 ou JWT
- Monitoramento com Spring Boot Actuator
- Logs estruturados com ELK ou Loki/Grafana

---

## Desenvolvido por
**Guilherme Jesus (gesuvs)**

