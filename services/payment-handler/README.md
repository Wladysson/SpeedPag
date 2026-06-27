# Gateway de Pagamentos Assíncrono

Este projeto simula um sistema de pagamentos instantâneos, com foco em **alta performance**, **resiliência** e **consistência eventual**. A solução foi construída com **arquitetura orientada a eventos (EDA)** e separada em dois microserviços principais: um serviço responsável por receber requisições de pagamento e outro encarregado do processamento financeiro assíncrono.

O sistema utiliza **Apache Kafka** como backbone de eventos, **Quarkus** com programação reativa para alta concorrência, **PostgreSQL** como banco transacional, **Kubernetes** para orquestração e **Prometheus** para observabilidade e acompanhamento de métricas de latência, como P99.

## Objetivos

- Receber requisições de pagamento com baixa latência.
- Processar débito e crédito de forma assíncrona.
- Garantir integridade transacional e consistência eventual.
- Permitir recuperação de falhas com SAGA baseada em coreografia.
- Escalar horizontalmente com Kubernetes.
- Monitorar saúde, throughput, lag e latência operacional.



## Guias Relacionais

- Flyway ([guide](https://quarkus.io/guides/flyway)): Handle your database schema migrations
- Micrometer Registry Prometheus ([guide](https://quarkus.io/guides/micrometer)): Enable Prometheus support for Micrometer
- SmallRye OpenAPI ([guide](https://quarkus.io/guides/openapi-swaggerui)): Document your REST APIs with OpenAPI - comes with Swagger UI
- Apache Kafka Client ([guide](https://quarkus.io/guides/kafka)): Connect to Apache Kafka with its native API
- REST Jackson ([guide](https://quarkus.io/guides/rest#json-serialisation)): Jackson serialization support for Quarkus REST. This extension is not compatible with the quarkus-resteasy extension, or any of the extensions that depend on it
- Messaging - Kafka Connector ([guide](https://quarkus.io/guides/kafka-getting-started)): Connect to Kafka with Reactive Messaging
- Scheduler ([guide](https://quarkus.io/guides/scheduler)): Schedule jobs and tasks
- Apache Kafka Streams ([guide](https://quarkus.io/guides/kafka-streams)): Implement stream processing applications based on Apache Kafka
- SmallRye Health ([guide](https://quarkus.io/guides/smallrye-health)): Monitor service health
- Redis Cache ([guide](https://quarkus.io/guides/cache-redis-reference)): Use Redis as the caching backend
- JDBC Driver - PostgreSQL ([guide](https://quarkus.io/guides/datasource)): Connect to the PostgreSQL database via JDBC

## Módulos principais

| Módulo | Responsabilidade |
|---|---|
| `payment-handler` | Recebe a requisição HTTP, valida os dados, registra o pagamento e publica o evento inicial.
| `payment-processor` | Consome eventos do Kafka, executa débito/crédito, emite eventos de sucesso/falha e trata compensações. 
| `shared` | Centraliza contratos de eventos, bibliotecas internas e artefatos compartilhados entre os serviços. 
| `infra` | Reúne Docker, Kubernetes e Terraform para empacotamento e provisionamento da plataforma.
| `observability` | Contém dashboards, regras de alerta e artefatos para análise operacional.

## Arquitetura

A arquitetura segue o estilo de **microserviços desacoplados por eventos**, no qual cada serviço pode evoluir e ser implantado de forma independente. Em vez de uma chamada síncrona encadeando todas as etapas do pagamento, o sistema publica eventos e permite que os consumidores reajam de forma assíncrona, reduzindo acoplamento e melhorando escalabilidade. 

O fluxo distribuído de pagamento utiliza o padrão **SAGA com coreografia**, no qual cada etapa do processamento reage ao evento anterior e emite um novo evento ao concluir sua responsabilidade. Esse modelo é adequado para cenários em que múltiplos serviços precisam manter consistência eventual sem depender de uma transação distribuída tradicional.

## Fluxo de pagamento

1. O cliente envia uma requisição de pagamento para o `payment-handler`.
2. O `payment-handler` valida os dados, persiste o estado inicial da transação e publica um `PaymentRequestedEvent` no Kafka.
3. O `payment-processor` consome esse evento e inicia o fluxo de processamento financeiro. 
4. O débito é executado na conta de origem; se bem-sucedido, o serviço segue para o crédito da conta de destino.
5. Se todas as etapas forem concluídas, um evento final de sucesso é publicado.
6. Se alguma etapa falhar após uma operação parcial, eventos de compensação são disparados para restaurar consistência.
7. As métricas operacionais e de latência são expostas para observabilidade e acompanhamento contínuo.

## Estrutura do repositório

```text
speedpag/
├── README.md                         # Visão geral do projeto, arquitetura e instruções de uso
├── docs/                            # Documentação técnica e arquitetural
│   ├── architecture/                # Diagramas e descrições da arquitetura
│   │   ├── system-design.md         # Visão macro da solução
│   │   ├── event-flow.md            # Fluxo de eventos entre os serviços
│   │   ├── saga-choreography.md     # Estratégia de consistência com SAGA
│   │   └── sequence-diagrams/       # Diagramas de sequência
│   ├── api/                         # Contratos e documentação de API
│   │   ├── payment-handler-openapi.yaml # Especificação OpenAPI do handler
│   │   └── payment-contracts.md     # Contratos síncronos e assíncronos
│   ├── adr/                         # Architecture Decision Records
│   │   ├── 001-use-kafka.md
│   │   ├── 002-use-saga-choreography.md
│   │   └── 003-use-quarkus-reactive.md
│   └── runbooks/                    # Procedimentos operacionais e resposta a incidentes
│       ├── incident-kafka-lag.md
│       ├── incident-payment-stuck.md
│       └── rollback.md
│
├── services/                        # Microserviços da aplicação
│   ├── payment-handler/             # Serviço de entrada dos pagamentos
│   │   ├── pom.xml                  # Dependências e build do módulo
│   │   └── src/
│   │       ├── main/
│   │       │   ├── java/com/speedpag/pix/handler/
│   │       │   │   ├── api/         # Endpoints REST, DTOs e mapeadores
│   │       │   │   ├── application/ # Casos de uso e serviços de aplicação
│   │       │   │   ├── domain/      # Entidades, eventos e regras de negócio
│   │       │   │   ├── infrastructure/ # Kafka, persistência, configs, métricas
│   │       │   │   └── shared/      # Utilitários internos do serviço
│   │       │   └── resources/
│   │       │       ├── application.properties # Configuração do Quarkus
│   │       │       └── db/migration/ # Migrações SQL
│   │       └── test/
│   │           ├── java/com/speedpag/pix/handler/
│   │           │   ├── unit/        # Testes unitários
│   │           │   ├── integration/ # Testes de integração
│   │           │   └── contract/    # Testes de contrato
│   │           └── resources/
│   │
│   └── payment-processor/           # Serviço de processamento assíncrono
│       ├── pom.xml                  # Dependências e build do módulo
│       └── src/
│           ├── main/
│           │   ├── java/com/speedpag/pix/processor/
│           │   │   ├── consumer/    # Consumidores Kafka
│           │   │   ├── application/ # Casos de uso e orquestração do fluxo
│           │   │   ├── domain/      # Entidades, eventos e regras de negócio
│           │   │   ├── infrastructure/ # Persistência, locks, mensageria, métricas
│           │   │   └── shared/      # Utilitários internos
│           │   └── resources/
│           │       ├── application.properties
│           │       └── db/migration/
│           └── test/
│               ├── java/com/speedpag/pix/processor/
│               │   ├── unit/
│               │   ├── integration/
│               │   └── e2e/
│               └── resources/
│
├── shared/                          # Artefatos compartilhados entre os módulos
│   ├── contracts/                   # Contratos e schemas de eventos
│   │   ├── events/                  # Avro/JSON Schemas dos eventos Kafka
│   │   ├── dto/                     # DTOs compartilháveis
│   │   └── headers/                 # Cabeçalhos padronizados para mensageria
│   ├── libs/                        # Bibliotecas internas reutilizáveis
│   │   ├── idempotency-lib/
│   │   ├── tracing-lib/
│   │   └── exception-lib/
│   └── test-fixtures/               # Massa de testes e utilitários
│
├── infra/                           # Infraestrutura do projeto
│   ├── docker/                      # Dockerfiles dos microserviços
│   ├── kubernetes/                  # Manifests K8s e overlays por ambiente
│   │   ├── base/
│   │   └── overlays/
│   └── terraform/                   # Provisionamento da infraestrutura
│       ├── modules/
│       ├── envs/
│       └── versions.tf
│
├── deploy/                          # Scripts de build, deploy e rollback
│   ├── scripts/
│   └── helm/
│
├── observability/                   # Observabilidade e testes de carga
│   ├── dashboards/                  # Dashboards operacionais
│   ├── alerts/                      # Alertas e regras Prometheus
│   └── load-test/                   # Cenários de performance (k6/Gatling)
│
├── .github/
│   └── workflows/                   # Pipelines CI/CD
│
├── pom.xml                          # POM agregador do monorepo
└── .gitignore
```

## Organização interna dos serviços

Cada microserviço segue uma separação por camadas para manter o código mais claro e mais fácil de evoluir. Essa organização ajuda a isolar a lógica do domínio da tecnologia usada para expor APIs, persistir dados e publicar eventos. 

- `api/`: endpoints, requests, responses e mapeadores.
- `application/`: casos de uso e serviços que coordenam o fluxo.
- `domain/`: entidades, eventos e regras de negócio.
- `infrastructure/`: integração com Kafka, banco, métricas e configurações.
- `test/`: testes unitários, integração, contrato e ponta a ponta.

## Como executar localmente

### Pré-requisitos

- Java 17+
- Maven 3.9+
- Docker e Docker Compose
- Kubernetes local opcional, como Kind ou Minikube
- PostgreSQL
- Apache Kafka

### Passos

1. Suba os serviços de infraestrutura, como PostgreSQL e Kafka, com Docker Compose.
2. Compile o projeto raiz ou os módulos individualmente com Maven.
3. Execute o `payment-handler` e o `payment-processor` em modo de desenvolvimento do Quarkus. 
4. Envie uma requisição HTTP para o endpoint de pagamentos.
5. Acompanhe o fluxo pelos logs, tópicos Kafka e métricas exportadas.

### Exemplo de build

```bash
mvn clean install
```

### Exemplo de execução do handler

```bash
cd services/payment-handler
mvn quarkus:dev
```

### Exemplo de execução do processor

```bash
cd services/payment-processor
mvn quarkus:dev
```

## Observabilidade

O projeto foi pensado para permitir análise operacional ponta a ponta. As métricas expostas pelos serviços podem ser coletadas pelo Prometheus, enquanto dashboards podem consolidar indicadores como taxa de sucesso, tempo de processamento, throughput, lag dos consumidores e latência P99.

Indicadores recomendados:

- Tempo total de processamento por pagamento.
- Latência P50, P95 e P99.
- Taxa de sucesso e taxa de falha.
- Tamanho de filas e lag dos consumidores Kafka.
- Quantidade de compensações executadas.
- Volume de pagamentos por segundo.

## Testes

A estratégia de testes pode ser dividida em diferentes níveis para dar segurança à evolução do sistema. Em arquiteturas de microserviços orientadas a eventos, é especialmente útil combinar testes unitários, integração entre aplicação e mensageria, além de testes de contrato e fluxos ponta a ponta.

- **Unitários** para regras de negócio isoladas.
- **Integração** para banco, Kafka e persistência.
- **Contrato** para validar compatibilidade dos eventos e da API.
- **E2E** para o fluxo completo de pagamento e compensação.

