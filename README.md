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
O producer é implementado em Python. Este programa efetua a leitura do arquivo 'python-producer/app/201901_BolsaFamilia_Pagamentos.csv' e publica os registros encontrados no cluster Kafka.
As libs utilizadas são:
- csv: para a leitura do arquivo csv;
- kafka-python: para publicar as mensagens no cluster Kafka.

Para executar este programa, basta acessar a pasta 'producer-python' e executar o scrip 'run.sh':
> bash run.sh

Em alguns instantes o container com a o producer inicializará e as mensagens passarão a ser publicadas no tópico do cluster Kafka.
