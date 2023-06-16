# desafio_5_etapa_api

- MySQL instalado no seu sistema. Se você ainda não possui o MySQL instalado, você pode baixá-lo no [site oficial do MySQL](https://www.mysql.com/downloads/).

## Passo 1: Abrir o MySQL

Abra o terminal ou prompt de comando e acesse o servidor MySQL. Utilize o seguinte comando: mysql -u root -p

Insira a senha do usuário root do MySQL quando solicitado.

## Passo 2: Criar o banco de dados

Uma vez conectado ao servidor MySQL, crie o banco de dados "meudb" com o seguinte comando SQL: CREATE DATABASE meudb;

Isso irá criar um banco de dados chamado "meudb".

## Passo 3: Configurar a API

No documento src/main/resources/application.properties altere os valores de:

spring.datasource.username=root
spring.datasource.password=admin

para os valores que foi utilizado para criar o seu database
