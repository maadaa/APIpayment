[![Build Status](https://travis-ci.org/moreiraMD/APIpayment.svg?branch=master)](https://travis-ci.org/moreiraMD/APIpayment)
# APIpayment
Simples serviço para fornecer uma API para pagamento aos nossos clientes e um check-out para quem não deseja integrar-se à nossa API.

# Rodando o projeto

Tenha na sua máquina as seguintes tecnologias:
- Docker
- Java 8
- Maven

Primeiro vamos subir nosso container para o banco de dados, um mysql:
```sh
$ docker run -d -p 3306:3306 --name=docker-mysql --env="MYSQL_ROOT_PASSWORD=root" --env="MYSQL_PASSWORD=root" --env="MYSQL_DATABASE=moip" mysql
```
O segundo passo é dar um build no projeto e criarmos a imagem para o Docker, podemos fazer todos estes passos com o comando:
```sh
$ mvn clean install dockerfile:build
```
Já vamos ter os testes executados, build do projeto com todas suas dependências e nossa imagem para o terceiro passo, vamos rodar nosso container e criar um link com o do mysql:
```sh
$ docker run -d \
    --name api-payment \
    --link docker-mysql:mysql \
    -p 8080:8080 \
    -e DATABASE_HOST=docker-mysql \
    -e DATABASE_PORT=3306 \
    -e DATABASE_NAME=moip \
    -e DATABASE_USER=root \
    -e DATABASE_PASSWORD=root \
    apipayment
```

Com o projeto rodando é só acessar seu [LocalHost:8080](http://localhost:8080/) para inserir um pagamento.

# Arquitetura

Para realizar este teste foram escolhidas as seguintes tecnologias:

- Spring Framework
- MySql

Para o Banco de Dados foi adotado a seguinte estrutura para tabelas que pode ser visualizada nesta imagem: 
![Estrutura do Banco](https://github.com/moreiraMD/APIpayment/blob/master/Untitled%20Diagram.png)

Já na escolha do Spring para desenvolver a aplicação foi simples, ele me forneceria todas ferramentas para realização da API quanto para comunicar com
o banco, realizar os testes unitários e poder consumir a API gerada para simular uma integração.

Durante o desenvolvimento fiz a escolha de utilizar o Pattern Factory para criar o pagamento de acordo com seu tipo, onde ele saberia como se comportar
sem ter a necessidade de alterar o código colocando comportamentos diferentes de acordo com o tipo, deixando a própria classe se resolver.

OBS: No pacote raiz do projeto temos um arquivo para ser importado no Postman, assim pode ter alguns testes para interação com a API
o arquivo é o [APIpayment - MOIP.postman_collection.json]()

