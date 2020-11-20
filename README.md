# Bem-vindo ao Mcp Quote API :money_with_wings:

Serviço responsável por consultar informações monetárias, cotações e moedas das APIs de dados abertos do governo.

# Introdução Arquitetura 
Durante o desenvolvimento foram tomadas algumas decisões com relação a tecnologias usadas. O backend foi desenvolvido utilizando o framework 
[Quarkus](https://quarkus.io/) por questões de produtividade e desempenho em relação a outras arquiteturas.

Algumas ferramentas foram adicionadas para monitoração e logs na aplicação, dentre elas: [Prometheus](https://quarkus.io/guides/microprofile-metrics), [Jaeger](https://quarkus.io/guides/opentracing), 
[Elasticsearh](https://quarkus.io/guides/centralized-log-management), [Logstash](https://quarkus.io/guides/centralized-log-management) e [Kibana](https://quarkus.io/guides/centralized-log-management). Utilizando as [integrações](https://quarkus.io/guides/) que o quarkus oferece. 

Aplicação foi pensada para ser resiliente e tolerante a falhas. 

---
**Observação: O projeto foi desenvolvido utilizando o Windows e por isso algumas configurações no docker/docker-compose podem ser diferentes 
para cada sistema operacional. O Docker do Windows não possui suporte ao modo 'host' na criação de rede entre containers e por isso 
foi utilizado em alguns casos a propriedade 'host.docker.internal' para contornar esse problema.** 

---

# Ferramentas complementares

Ferramenta | Descrição
--- | ---
[Prometheus](https://quarkus.io/guides/microprofile-metrics) | Sistema de monitoramento para analise de metricas das aplicações
[Jaeger](https://quarkus.io/guides/opentracing) | Sistema de rastramento para requisições
[ELK](https://quarkus.io/guides/centralized-log-management)| Sistema centralizador de logs. Elasticsearch, Logstash e Kibana
[Quarkus](https://quarkus.io/) | Framework utilizado para criar o backend

# Ambiente de desenvolvimento

Existem alguns passos para execução do projeto em ambiente local, necessário que alguns programas estejam corretamente instalados.

Framework/lib | Versão Recomendada | S.O Utilizado
--- | --- | ---
[Maven](https://maven.apache.org/download.cgi) | 3.6.3 | Windows
[JDK](https://openjdk.java.net/projects/jdk/11/) | 11 | Windows
[Docker](https://docs.docker.com/docker-for-windows/install/) | 19.03.13 | Windows
[Docker Compose](https://docs.docker.com/compose/install/) | 1.27.4 | Windows
[Intellij](https://www.jetbrains.com/pt-br/idea/)| - | Windows

## Execução do projeto 

### Passo 1
Faça o clone do projeto
```shell script
$ git clone http://github.com/Maikoncanuto/mcp-quote-api.git mcp-quote
```

### Passo 2 
Entre na pasta raiz do projeto

```shell script
$ cd mcp-quote
```

### Passo 3
Execute o comando para levantar toda infraestrutura necessária

```shell script
$ docker-compose up 
```

Acompanhar logs: 
```shell script
$ docker-compose logs -f
```

### Passo 4
Execute o comando para instalar as dependências necessárias

```shell script
$ mvn clean package 
```

### Passo 5
Execute o projeto com comando do quarkus

```shell script
$ ./mvnw compile quarkus:dev
```

ou 

```shell script
java -jar target/mcp-quotes-0.0.1-SNAPSHOT-runner.jar
```

# Serviços do mcp-quote-api

Serviço | URL | Status | Descrição
--- | --- | --- | ---
Swagger | http://localhost:8080/swagger-ui/#/ | :white_check_mark: | Informação dos endpoints na aplicação
Health Live | http://localhost:8080/health/live | :white_check_mark: | Responsável por identificar a sáude da aplicação
Health Ready | http://localhost:8080/health/ready | :white_check_mark: | Responsável por identificar se aplicação está pronta para uso
Jaeger | http://localhost:8180 | :white_check_mark: | Rastreamento de requisições
Prometheus | http://localhost:8280 | :white_check_mark: | Analise de Métricas da aplicação
Kibana | http://localhost:8380 | :white_check_mark: | Visualizar Logs e dashboards 


# Exemplo de requisições para os Endpoints

## Buscar informação da cotação por data
**Url de requisição:**
```
http://localhost:8080/api/v1/cotacoes/cotacao-dolar-dia/'11-05-2020'
```
**Parametrôs:**

Parâmetro | Formato | Tipo | Descrição | Exemplo
--- | --- | --- | --- | ---  
dataCotacao | MM-dd-yyyy | string | Data da cotação do dolar | '11-05-2020'

**Curl:**
```shell script
curl -X GET "http://localhost:8080/api/v1/cotacoes/cotacao-dolar-dia/'11-05-2020'" -H  "accept: */*"
```

**Retorno:**
``` json
{
  "code": "200", 
  "data": [ 
    {
      "cotacaoCompra": 5.5618,
      "cotacaoVenda": 5.5624,
      "dataHoraCotacao": "2020-11-05 13:09:31.961"
    }
  ],
  "erro": null 
}
```
---

## Buscar informação da cotação por período
**Url de requisição:**
```
http://localhost:8080/api/v1/cotacoes/cotacao-dolar-periodo?dataFinal=01-01-202&dataInicial='02-01-2020'
```
**Parametrôs Query:**

Parâmetro | Formato | Tipo | Descrição | Exemplo
--- | --- | --- | --- | ---  
dataInicial | MM-dd-yyyy | string | Data inicial da cotação | '01-01-2020'
dataFinal | MM-dd-yyyy | string | Data final da cotação | '02-01-2020'

**Curl:**
```shell script
curl -X GET "http://localhost:8080/api/v1/cotacoes/cotacao-dolar-periodo?dataFinal='01-01-2020'&dataInicial='02-01-2020'" -H  "accept: */*"
```

**Retorno:**
``` json
{
  "code": "200", 
  "data": [ 
    {
          "cotacaoCompra": 4.0207,
          "cotacaoVenda": 4.0213,
          "dataHoraCotacao": "2020-01-02 13:11:10.762"
        },
        {
          "cotacaoCompra": 4.0516,
          "cotacaoVenda": 4.0522,
          "dataHoraCotacao": "2020-01-03 13:06:22.606"
        },
        {
          "cotacaoCompra": 4.0548,
          "cotacaoVenda": 4.0554,
          "dataHoraCotacao": "2020-01-06 13:03:22.271"
        },
        {
          "cotacaoCompra": 4.0835,
          "cotacaoVenda": 4.0841,
          "dataHoraCotacao": "2020-01-07 13:06:14.601"
        },
        {
          "cotacaoCompra": 4.0666,
          "cotacaoVenda": 4.0672,
          "dataHoraCotacao": "2020-01-08 13:03:56.075"
        }
  ],
  "erro": null 
}
```
---
## Buscar informação da abertura de cotação para moeda e data
**Url de requisição:**
```
http://localhost:8080/api/v1/cotacoes/cotacao-moeda-abertura?dataCotacao=%2711-05-2020%27&simboloMoeda=%27AUD%27
```
**Parametrôs Query:**

Parâmetro | Formato | Tipo | Descrição | Exemplo
--- | --- | --- | --- | ---  
dataCotacao | MM-dd-yyyy | string | Data da cotação do dolar | '11-05-2020'
simboloMoeda | XXX | string | Código/Simbolo da moeda | 'AUD'

**Curl:**
```shell script
curl -X GET "http://localhost:8080/api/v1/cotacoes/cotacao-moeda-abertura?dataCotacao=%2711-05-2020%27&simboloMoeda=%27AUD%27" -H  "accept: */*"
```

**Retorno:**
``` json
{
  "code": "200",
  "data": [
    {
      "cotacaoCompra": 4.0381,
      "cotacaoVenda": 4.0413,
      "dataHoraCotacao": "2020-11-05 13:09:31.955",
      "tipoBoletim": "Intermediário"
    }
  ],
  "erro": null
}
```
---

## Buscar informação da cotação dia para moeda por data
**Url de requisição:**
```
http://localhost:8080/api/v1/cotacoes/cotacao-moeda-dia?dataCotacao=%2711-05-2020%27&simboloMoeda=%27AUD%27
```
**Parametrôs Query:**

Parâmetro | Formato | Tipo | Descrição | Exemplo
--- | --- | --- | --- | ---  
dataCotacao | MM-dd-yyyy | string | Data da cotação do dolar | '11-05-2020'
simboloMoeda | XXX | string | Código/Simbolo da moeda | 'AUD'

**Curl:**
```shell script
curl -X GET "http://localhost:8080/api/v1/cotacoes/cotacao-moeda-dia?dataCotacao=%2711-05-2020%27&simboloMoeda=%27AUD%27" -H  "accept: */*"
```

**Retorno:**
``` json
{
  "code": "200",
  "data": [
    {
      "paridadeCompra": 0.7246,
      "paridadeVenda": 0.7247,
      "cotacaoCompra": 4.0371,
      "cotacaoVenda": 4.0381,
      "dataHoraCotacao": "2020-11-05 10:09:48.908",
      "tipoBoletim": "Abertura"
    },
    {
      "paridadeCompra": 0.7247,
      "paridadeVenda": 0.7249,
      "cotacaoCompra": 4.0294,
      "cotacaoVenda": 4.031,
      "dataHoraCotacao": "2020-11-05 11:05:18.088",
      "tipoBoletim": "Intermediário"
    },
    {
      "paridadeCompra": 0.7249,
      "paridadeVenda": 0.7254,
      "cotacaoCompra": 4.0306,
      "cotacaoVenda": 4.0338,
      "dataHoraCotacao": "2020-11-05 12:08:19.051",
      "tipoBoletim": "Intermediário"
    }
  ],
  "erro": null
}
```
---

## Buscar informação da cotação dia por periodo e moeda
**Url de requisição:**
```
http://localhost:8080/api/v1/cotacoes/cotacao-moeda-periodo?dataFinal=%2702-01-2020%27&dataInicial=%2701-01-2020%27&simboloMoeda=%27AUD%27
```
**Parametrôs Query:**

Parâmetro | Formato | Tipo | Descrição | Exemplo
--- | --- | --- | --- | ---  
dataInicial | MM-dd-yyyy | string | Data de inicio da cotação | '01-01-2020'
dataFinal | MM-dd-yyyy | string | Data final da cotação | '02-01-2020'
simboloMoeda | XXX | string | Código/Simbolo da moeda | 'AUD'

**Curl:**
```shell script
curl -X GET "http://localhost:8080/api/v1/cotacoes/cotacao-moeda-periodo?dataFinal=%2702-01-2020%27&dataInicial=%2701-01-2020%27&simboloMoeda=%27AUD%27" -H  "accept: */*"
```

**Retorno:**
``` json
{
  "code": "200",
  "data": [
    {
      "paridadeCompra": 0.6993,
      "paridadeVenda": 0.6994,
      "cotacaoCompra": 2.8043,
      "cotacaoVenda": 2.8051,
      "dataHoraCotacao": "2020-01-02 10:08:18.114",
      "tipoBoletim": "Abertura"
    },
    {
      "paridadeCompra": 0.6996,
      "paridadeVenda": 0.6998,
      "cotacaoCompra": 2.8067,
      "cotacaoVenda": 2.8079,
      "dataHoraCotacao": "2020-01-02 11:03:40.704",
      "tipoBoletim": "Intermediário"
    },
    {
      "paridadeCompra": 0.6991,
      "paridadeVenda": 0.6993,
      "cotacaoCompra": 2.8175,
      "cotacaoVenda": 2.8187,
      "dataHoraCotacao": "2020-01-02 12:10:55.168",
      "tipoBoletim": "Intermediário"
    }
  ],
  "erro": null
}
```
---

## Buscar informação do fechamento da cotação por periodo e data
**Url de requisição:**
```
http://localhost:8080/api/v1/cotacoes/cotacao-moeda-periodo-fechamento?dataFinal=%2702-01-2020%27&dataInicial=%2701-01-2020%27&simboloMoeda=%27AUD%27
```
**Parametrôs Query:**

Parâmetro | Formato | Tipo | Descrição | Exemplo
--- | --- | --- | --- | ---  
dataInicial | MM-dd-yyyy | string | Data de inicio da cotação | '01-01-2020'
dataFinal | MM-dd-yyyy | string | Data final da cotação | '02-01-2020'
simboloMoeda | XXX | string | Código/Simbolo da moeda | 'AUD'

**Curl:**
```shell script
curl -X GET "http://localhost:8080/api/v1/cotacoes/cotacao-moeda-periodo-fechamento?dataFinal=%2702-01-2020%27&dataInicial=%2701-01-2020%27&simboloMoeda=%27AUD%27" -H  "accept: */*"
```

**Retorno:**
``` json
{
  "code": "200",
  "data": [
     {
      "cotacaoCompra": 2.8572,
      "cotacaoVenda": 2.8584,
      "dataHoraCotacao": "2020-01-31 13:10:35.372",
      "tipoBoletim": "Fechamento"
    }
  ],
  "erro": null
}
```
---

## Buscar informação de moedas
**Url de requisição:**
```
http://localhost:8080/api/v1/moedas
```
**Parametrôs Query:**

Parâmetro | Formato | Tipo | Descrição | Exemplo
--- | --- | --- | --- | ---  
Não existe | Não existe | Não existe | Não existe | Não existe


**Curl:**
```shell script
curl -X GET "http://localhost:8080/api/v1/moedas" -H  "accept: */*"
```

**Retorno:**
``` json
{
  "code": "200",
  "data": [
     {
       "simbolo": "AUD",
       "nomeFormatado": "Dólar australiano",
       "tipoMoeda": "B"
     },
     {
       "simbolo": "CAD",
       "nomeFormatado": "Dólar canadense",
       "tipoMoeda": "A"
     },
     {
       "simbolo": "CHF",
       "nomeFormatado": "Franco suíço",
       "tipoMoeda": "A"
     }
  ],
  "erro": null
}
```
---

# Estrutura do projeto
```cmd
mcp-quote:.
├───.github
│   └───workflows
├───.idea
│   └───libraries
├───.mvn
│   └───wrapper
├───pipelines
├───src
│   ├───main
│   │   ├───docker
│   │   ├───java
│   │   │   └───com
│   │   │       └───github
│   │   │           └───maikoncanuto
│   │   │               └───quotes
│   │   │                   ├───core
│   │   │                   │   ├───annotations
│   │   │                   │   ├───config
│   │   │                   │   ├───healthcheck
│   │   │                   │   └───interceptors
│   │   │                   ├───domain
│   │   │                   │   ├───dtos
│   │   │                   │   └───enums
│   │   │                   ├───integrations
│   │   │                   │   └───clients
│   │   │                   ├───resources
│   │   │                   │   ├───config
│   │   │                   │   ├───handlers
│   │   │                   │   └───impl
│   │   │                   └───services
│   │   └───resources
│   └───test
│       ├───java
│       │   └───com
│       │       └───github
│       │           └───maikoncanuto
│       │               └───quotes
│       │                   ├───integrations
│       │                   │   └───clients
│       │                   ├───resources
│       │                   └───services
│       └───resources
└───target
    ├───classes
    │   ├───com
    │   │   └───github
    │   │       └───maikoncanuto
    │   │           └───quotes
    │   │               ├───core
    │   │               │   ├───annotations
    │   │               │   ├───config
    │   │               │   ├───exceptions
    │   │               │   ├───healthcheck
    │   │               │   └───interceptors
    │   │               ├───domain
    │   │               │   ├───dtos
    │   │               │   └───enums
    │   │               ├───integrations
    │   │               │   └───clients
    │   │               ├───resources
    │   │               │   ├───config
    │   │               │   ├───handlers
    │   │               │   └───impl
    │   │               └───services
    │   └───META-INF
    ├───generated-sources
    │   └───annotations
    ├───generated-test-sources
    │   └───test-annotations
    ├───lib
    ├───maven-archiver
    ├───maven-status
    │   └───maven-compiler-plugin
    │       ├───compile
    │       │   └───default-compile
    │       └───testCompile
    │           └───default-testCompile
    ├───quarkus
    │   └───bootstrap
    ├───surefire-reports
    └───test-classes
        ├───com
        │   └───github
        │       └───maikoncanuto
        │           └───quotes
        │               ├───integrations
        │               │   └───clients
        │               ├───resources
        │               └───services
        └───META-INF

```
