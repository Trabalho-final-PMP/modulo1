# Módulo1 - CRUD de pessoas

Este projeto é uma aplicação backend construída com **Spring Boot**, que integra **MongoDB** para persistência de dados, **Graylog** para centralização de logs e **OpenSearch** para busca e análise.

O sistema possui rotas de consulta (GET), cadastro (POST), update (PUT) e deleção (DELETE) de pessoas, que possuem os seguintes atributos:

- nome
- dataNascimento (no banco, é dt_nascimento)
- ativo

## Tecnologias Utilizadas

O projeto utiliza as seguintes tecnologias e ferramentas:

## Tecnologias Utilizadas

O projeto utiliza as seguintes tecnologias e ferramentas:

- ![Java](https://img.shields.io/badge/Java-17-blue?logo=java&logoColor=white) **Java 17**
- ![Spring Boot](https://img.shields.io/badge/Spring%20Boot-4.0-brightgreen?logo=spring&logoColor=white) **Spring Boot 4**
- ![MongoDB](https://img.shields.io/badge/MongoDB-6.0-green?logo=mongodb&logoColor=white) **MongoDB 6**
- ![Graylog](https://img.shields.io/badge/Graylog-5.2-orange?logo=graylog&logoColor=white) **Graylog 5.2**
- ![OpenSearch](https://img.shields.io/badge/OpenSearch-2.4-red?logo=opensearch&logoColor=white) **OpenSearch 2.4**
- ![Docker](https://img.shields.io/badge/Docker-20.10-blue?logo=docker&logoColor=white) **Docker & Docker Compose**
- ![Logback](https://img.shields.io/badge/Logback-GELF-purple) **Logback GELF Appender**
- ![SonarQube](https://img.shields.io/badge/SonarQube-latest-4E9BCD?logo=sonarqube&logoColor=white) **SonarQube**

## Pré-requisitos

Antes de executar o projeto, certifique-se de ter o seguinte instalado e configurado no seu sistema:

- **Docker** – Para criar e rodar os contêineres.
    - [Instalação do Docker](https://docs.docker.com/get-docker/)
- **Docker Compose** – Para orquestrar múltiplos contêineres.
    - [Instalação do Docker Compose](https://docs.docker.com/compose/install/)
- **Java 17** – Necessário para compilar e rodar a aplicação Spring Boot.
    - [Instalação do Java 17](https://adoptium.net/)
- **Maven 3.9+** – Para gerenciamento de dependências e build do projeto.
    - [Instalação do Maven](https://maven.apache.org/install.html)
- **Conta no Docker Hub** – Para enviar a imagem do Docker.
    - [Cadastro Docker Hub](https://hub.docker.com/)
- **SonarQube** (opcional) – Para análise de qualidade de código.
    - Pode ser rodado localmente via Docker ou acessado via servidor corporativo.
- **Git** – Para clonar o repositório e versionamento de código.
    - [Instalação do Git](https://git-scm.com/book/en/v2/Getting-Started-Installing-Git)

## Como Executar o Projeto Localmente

Siga os passos abaixo para rodar a aplicação e todos os serviços dependentes.

### 1. Clonar o Repositório
```bash
git clone https://github.com/Trabalho-final-PMP/modulo1.git
cd modulo1
```

### 2. Rodar o docker-compose
Para rodar todos os container da aplicação, rode `docker-compose up --build`

>Se for necessário, você pode inspecionar os logs do container do app no aplicativo do Docker, ou rodando o comando `docker-compose logs -f app`

### Acessando as rotas da aplicação
Com um HTTP Client de sua preferência (Insomnia, Postman, e outros), consulte as seguintes rotas da aplicação:

- `GET http://localhost:8080/modulo1/v1/pessoa`
- `POST http://localhost:8080/modulo1/v1/pessoa`
  - Body necessario:
    ```JSON
        {
            "nome": "John Doe",
            "dataNascimento": "11/11/2025",
            "ativo": true
        }
     ```
- `PUT http://localhost:8080/modulo1/v1/pessoa/{id}`
  - Body necessario:
    ```JSON
        {
            "nome": "John Doe",
            "dataNascimento": "11/11/2025",
            "ativo": true
        }
    ```
- `DELETE http://localhost:8080/modulo1/v1/pessoa/{id}`

## Status

![Build Status](https://github.com/Trabalho-final-PMP/modulo1/actions/workflows/build.yml/badge.svg?branch=main)

![Docker Image](https://img.shields.io/docker/pulls/gabrielmendes21/modulo1-app)

[![Quality Gate Status](https://sonarcloud.io/api/project_badges/measure?project=Trabalho-final-PMP_modulo1&metric=alert_status)](https://sonarcloud.io/dashboard?id=Trabalho-final-PMP_modulo1)


