<p align="center">
  <strong>Gateway para Pagamentos Assíncrono</strong>
</p>

<p align="center">
  Sistema de pagamentos instantâneos, cloud-native,
  projetado com foco em baixa latência, alta performance, resiliência,
  consistência eventual e processamento financeiro assíncrono.
</p><br>

<p align="center">
  <!-- Linguagens -->
  <img src="docs/images/home/Java.png" width="55" alt="Java"/>
  <img src="docs/images/home/JavaScript.png" width="55" alt="JavaScript"/>
  <img src="docs/images/home/Go.png" width="55" alt="Go"/>
  <img src="docs/images/home/Python.png" width="55" alt="Python"/>
  <img src="docs/images/home/PHP.png" width="55" alt="PHP"/>
  <img src="docs/images/home/NET%20core.png" width="55" alt=".NET Core"/>
  <img src="docs/images/home/Node.js.png" width="55" alt="Node.js"/>
  <img src="docs/images/home/HashiCorp%20Terraform.png" width="55" alt="Node.js"/>

  <!-- Cloud -->
  <img src="docs/images/home/AWS.png" width="55" alt="AWS"/>
  <img src="docs/images/home/Azure.png" width="55" alt="Azure"/>
  <img src="docs/images/home/Google%20Cloud.png" width="55" alt="Google Cloud"/>

  <!-- DevOps / Infraestrutura -->
  <img src="docs/images/home/Docker.png" width="55" alt="Docker"/>
  <img src="docs/images/home/Kubernetes.png" width="55" alt="Kubernetes"/>
  <img src="docs/images/home/Ansible.png" width="55" alt="Ansible"/>
  <img src="docs/images/home/Jenkins.png" width="55" alt="Jenkins"/>
  <img src="docs/images/home/Red%20Hat.png" width="55" alt="Red Hat"/>

  <!-- Mensageria / Streaming -->
  <img src="docs/images/home/icon-kafka-white-trans.png" width="55" alt="Apache Kafka"/>
  <img src="docs/images/home/RabbitMQ.png" width="55" alt="RabbitMQ"/>
  <img src="docs/images/home/amazon_kinesis_logo_icon_169609.webp" width="55" alt="Amazon Kinesis"/>

  <!-- Observabilidade -->
  <img src="docs/images/home/Prometheus.png" width="55" alt="Prometheus"/>
  <img src="docs/images/home/Grafana.png" width="55" alt="Grafana"/>
  <img src="docs/images/home/download.png" width="55" alt="Datadog"/>

  <!-- Frontend -->
  <img src="docs/images/home/Jamstack.png" width="55" alt="Jamstack"/>

  <!-- Bancos de Dados -->
  <img src="docs/images/home/PostgresSQL.png" width="55" alt="PostgreSQL"/>
  <img src="docs/images/home/MySQL.png" width="55" alt="MySQL"/>
  <img src="docs/images/home/MongoDB.png" width="55" alt="MongoDB"/>
  <img src="docs/images/home/Microsoft%20SQL%20Server.png" width="55" alt="Microsoft SQL Server"/>
  <img src="docs/images/home/Oracle.png" width="55" alt="Oracle"/>
</p><br>

<p align="center">
  <img src="https://img.shields.io/badge/System%20Design-Architecture-purple.svg" alt="System Design"/>
  <img src="https://img.shields.io/badge/Microservices-Architecture-blue.svg" alt="Microservices"/>
  <img src="https://img.shields.io/badge/Event%20Driven-Architecture-green.svg" alt="Event Driven Architecture"/>
  <img src="https://img.shields.io/badge/Async-Processing-orange.svg" alt="Asynchronous Processing"/>
  <img src="https://img.shields.io/badge/Resilience-SAGA-red.svg" alt="SAGA"/>
  <img src="https://img.shields.io/badge/Consistency-Eventual-yellow.svg" alt="Eventual Consistency"/>
  <img src="https://img.shields.io/badge/License-Proprietary-blue.svg" alt="License"/>
</p>

---

# 📖 Visão Geral
Este projeto se destaca por sua forma de pagamentos instantâneos, com foco em **alta performance**, **resiliência** e **consistência eventual**.

Este gateway de pagamento online funciona basicamente como uma ponte entre o aplicativo que hospeda a etapa de finalização da compra e os sistemas responsáveis pelo processamento dos pagamentos, permitindo a transferência rápida e segura das informações pessoais e financeiras do cliente. Ele recebe os dados da transação, realiza as validações necessárias, criptografa as informações sensíveis e as encaminha para os processadores de pagamento de forma segura e em conformidade com os requisitos aplicáveis.

Após a autorização e o processamento da transação, o gateway comunica automaticamente o resultado do pagamento, informando se a operação foi aprovada ou recusada. Essa arquitetura permite que diferentes meios e provedores de pagamento sejam integrados de forma desacoplada, mantendo o fluxo de pagamento seguro, confiável e eficiente.

Além do processamento das transações, o gateway pode integrar-se a sistemas de contabilidade e plataformas de análise de dados, permitindo a sincronização de informações sobre pagamentos, cobranças recorrentes, fluxo de caixa e comportamento dos clientes. Dessa forma, a solução atua como um componente central da infraestrutura financeira da aplicação.

> **Documentação viva:** esta documentação encontra-se em evolução contínua e pode sofrer alterações conforme novos serviços, componentes, arquiteturas e capacidades são implementados.

---

## 🏗️ Princípios Arquiteturais

| Princípio | Descrição                                                                                                   |
|-----------|-------------------------------------------------------------------------------------------------------------|
| **Domain-Driven Design** | Decomposição de serviços orientada a domínios de negócio.                                                   |
| **Independent Deployment** | Cada serviço pode ser implantado independentemente.                                                         |
| **Event-Driven Communication** | Comunicação assíncrona baseada em eventos.                                                                  |
| **Distributed Transaction Coordination** | Coordenação de transações distribuídas com padrões como Saga Coreografada e Orquestrada com Outbox.         |
| **Resilience & Fault Isolation** | Isolamento de falhas e padrões de resiliência (Circuit Breaker, Retry, Bulkhead).                           |
| **Secure Service-to-Service** | Comunicação segura entre serviços com mTLS e autenticação mútua.                                            |
| **Centralized Observability** | Observabilidade centralizada com logs, métricas e traces distribuídos.                                      |
| **Infrastructure as Code** | Infraestrutura versionada e automatizada com Terraform.                                                     |
| **Automated CI/CD** | Pipelines de integração e entrega contínua automatizadas com verificação de imagens dos containers.         |
| **Cloud-Native Deployment** | Implantação em Kubernetes com escalabilidade automática juntamente com terraform em ambientes AWS e Google. |
| **Continuous Evolution** | Evolução contínua de capacidades de negócio.                                                                |

---

<h2>💳 Integrações de Pagamento e seus Setores</h2>

<p>
  O SpeedPag esta sendo projetado para oferecer uma camada bastante ampla de integração com soluções de pagamento, permitindo que aplicações utilizem varias formas para trabalhar com múltiplos parceiros nacionais e internacionais.
</p>

<h3 style="text-align: center;">🇧🇷 Instituições Nacionais</h3>

<p>
  Integrações voltadas para o ecossistema brasileiro, incluindo Pix,
  cartões e demais meios de pagamento que estao sendo trabalhadas nestas instituiçoes:
</p>

<p align="left">
  <img src="docs/images/home/mercado.png" width="80" alt="Mercado Pago"/>
  <img src="docs/images/home/stone.png" width="80" alt="Stone"/>
  <img src="docs/images/home/pag.png" width="80" alt="PagBank"/>
  <img src="docs/images/home/cielo.png" width="80" alt="Cielo"/>
  <img src="docs/images/home/itau.png" width="80" alt="Itaú"/>
  <img src="docs/images/home/bradesco.png" width="80" alt="Bradesco"/>
  <img src="docs/images/home/Santander_Logo.jpg" width="80" alt="Santander"/>
  <img src="docs/images/home/brasil.jpg" width="80" alt="Banco do Brasil"/>
  <img src="docs/images/home/bnb.png" width="80" alt="Banco do Brasil"/>
  <img src="docs/images/home/c6.png" width="80" alt="Banco do Brasil"/>
</p>

---

<h3 style="text-align: center;">🌎 Instituições Internacionais</h3>

<p>
  Integrações para o ecossistema internacional, incluindo transaçoes,
  cartões e demais tipos de pagamento que esta sendo trabalhado nestas instituiçoes:
</p>

<p align="center">
  <img src="docs/images/home/flow/Citibank-Logo-2000.jpg" width="90" alt="Mercado Pago"/>
  <img src="docs/images/home/flow/jp.jpg" width="90" alt="Stone"/>
  <img src="docs/images/home/flow/nomad.png" width="90" alt="PagBank"/>
  <img src="docs/images/home/flow/revolut.png" width="90" alt="Cielo"/>
  <img src="docs/images/home/flow/Scotiabank-Emblema.jpg" width="90" alt="Banco do Brasil"/>
</p>

---

# 🧭 Arquitetura, Fluxos e Diagramas da Plataforma

Esta seção apresenta os principais fluxos, componentes e decisões arquiteturais implementados na plataforma até o momento.
As imagens abaixo representam diferentes estágios de desenvolvimento e teste e destinam-se a fornecer evidência visual da plataforma operando com sucesso.

Os diagramas têm como objetivo facilitar a compreensão das interações entre serviços, infraestrutura e componentes da plataforma, servindo também como referência durante o desenvolvimento e evolução da arquitetura.

> A documentação é viva e pode ser atualizada continuamente a qualquer momento conforme novos serviços, integrações e componentes são implementados.

> Os screenshots são intencionalmente apresentados como evidência de implementação em vez de estarem atrelados a uma categoria específica de documentação. No entanto,
cada serviço tem suas imagens e explicaçao em suas devidas configurações.

> Nota: Os padrões apresentados nesta seção representam apenas os principais conceitos arquiteturais utilizados na plataforma. A documentação completa de cada domínio pode conter outros padrões e estratégias específicas. Para conhecer as demais implementações, consulte os links disponíveis nas respectivas seções e documentações dos serviços.

<p align="center">
em desenvolvimento.
</p>