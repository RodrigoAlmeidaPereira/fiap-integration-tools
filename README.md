# Projeto de conclusão - Fiap - Integration Tools 

Este projeto exemplifica a utilização do Apache Kafka como broker de mensagens entre duas aplicações.

Este repositório está dividido em três partes:
- Servidor Apache Kafka
- Producer (Python)
- Consumer (Java)

## Apache Kafka:
Para facilitar a implantação do ambiente, o cluster Kafka e o Zookeeper são utilizados a partir de imagens Docker. Para implantar o cluster, basta acessar o terminal, navegar até a pasta 'kafka-server' e executar o script 'run.sh':
 > bash run.sh
 
Em alguns minutos o servidor Kafka estára disponível para utilização. 

Ps: O script run.sh executa todos os pré-requisitos e por último executa o comando 'docker-compose up' para disponibilizar o container.

## Producer Python:
O producer é implementado em Python. Este programa efetua a leitura do arquivo 'python-producer/app/201901_BolsaFamilia_Pagamentos.csv' e publica os registros de Bolsa Família no cluster Kafka.
As libs utilizadas são:
- csv: para a leitura do arquivo csv;
- kafka-python: para publicar as mensagens no cluster Kafka.

Para executar este programa, basta acessar a pasta 'producer-python' e executar o scrip 'run.sh':
> bash run.sh

Em alguns instantes o container com a o producer inicializará e as mensagens passarão a ser publicadas no tópico do cluster Kafka.


## Consumer Java:
Os consumers é implemntado em Java. Este aplicativo possui três consumers:
- Consumer para contar os registros recebidos;
- Consumer para encontrar o beneficiário com maior parcela;
- Consumer para calcular todos os valores por UF.

As libs e frameworks utilizados são:
- Spring Boot: para fornecer as funcionalidades básicas do programa;
- Spring Cloud Stream: para fazer a integração com o cluster Kafka;
- Maven: para gerenciar as dependências e o build.


## Executando todo o ecossistema:
Para facilitar o deploy de todos os programas necessários (Kkafka-server, python-producer e java-consumer), foi desenvolvido um script que efetua todo o build das aplicações e, em seguida, executa todos os container necessários.
Basta acessar a pasta raiz do projeto e executar o script:
> bash runall.sh

Em alguns minutos todo o ambiente estará em execução com a troca de mensagens entre o producer e os consumers.
