# Descrição
O projeto simula uma _fake interface_ para fazer capitação de interessados e decidir se o projeto é iniciado ou não.

## Funcionalidades
O projeto possui:

* Uma tela para cadastro de **nome** e **email**;
* Envio de email cadastrado com o link para um _web-form_;
* Web-form com 3 questões para o possível cliente.

## Pré-requisitos
Para executar esse projeto é necessário:

* Banco de dados MySQL - instalado e configurado;
* Maven 3.* - instalado;
* Java 7 - instalado;
* Uma conta no gmail.

## Tecnologias utilizadas
O projeto está utilizando:

* Framework MVC - vraptor 4;
* Plugin para envio de email - vraptor-simplemail 4;
* Banco de dados - MySQL;
* Servlet Container - Jetty 9;
* Interface - JQuery, JQuery-Validation e Bootstrap;
* Build - maven 3.0.5.

## Setup
Clone o projeto
```
git clone https://github.com/gguiesi/geofusion-technical-test.git
```
e siga os passos a seguir para configurar.

### Banco de dado
Altere o arquivo **persistence.xml** que está em: **splashpage/src/main/resources/META-INF**
```
<property name="javax.persistence.jdbc.user" value="your user" />
<property name="javax.persistence.jdbc.password" value="your password" />
```
Altere as propriedades acima com o usuário e senha do MySQL.

### Email
Para o envio de email eu estou utilizando o gmail.

Para configurar, é necessário alterar o arquivo **production.properties** que está em **splashpage/src/main/resources**
```
vraptor.simplemail.main.from = your.email@gmail.com
vraptor.simplemail.main.username = your.email@gmail.com
vraptor.simplemail.main.password = password
```
Altere as propriedades acima com os dados da sua conta do gmail.

## Build
Basta executar
```
mvn clean install
```

## Execução
Basta executar
```
mvn jetty:run
```

## Utilização
Acesse a url [http://localhost:8080/splashpage/][fbd67b4f] e preencha o formulário.

Preencha o formulário através do link enviado para o email cadastrado.

  [fbd67b4f]: http://localhost:8080/splashpage/ "http://localhost:8080/splashpage/"
