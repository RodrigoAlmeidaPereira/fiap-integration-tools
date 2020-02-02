# Projeto de conclusão - Fiap - Integration Tools.

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

Em alguns instantes o container com o producer inicializará e as mensagens passarão a ser publicadas no tópico do cluster Kafka.


## Consumer Java:
Os consumers é implementado em Java. Este aplicativo possui três consumers:
- Consumer para contar os registros recebidos;
- Consumer para encontrar o beneficiário com maior parcela;
- Consumer para calcular todos os valores por UF.

As libs e frameworks utilizados são:
- Spring Boot: para fornecer as funcionalidades básicas do programa;
- Spring Cloud Stream: para fazer a integração com o cluster Kafka;
- Maven: para gerenciar as dependências e o build.


## Executando todo o ecossistema:
Para facilitar o deploy de todos os programas necessários (kafka-server, python-producer e java-consumer), foi desenvolvido um script que efetua todo o build das aplicações e, em seguida, executa todos os container necessários.
Basta acessar a pasta raiz do projeto e executar o script:
> bash runall.sh

Em alguns minutos todo o ambiente estará em execução com a troca de mensagens entre o producer e os consumers.

## Atividades Trello:
Segue abaixo uma screenshot com as atividades necessárias para o desenvolvimento deste projeto:

![alt image](https://github.com/RodrigoAlmeidaPereira/fiap-integration-tools/blob/master/trello-in-progress.png)

# Resultado deste Trabalho:

Após processamento do arquivo 201901_BolsaFamilia_Pagamentos.csv, deste csv extraimos uma amostragem de 5.000.000 do final do arquivo, gerado o  resultado abaixo.

### Resultado Esperado Producer:

![alt image](https://github.com/RodrigoAlmeidaPereira/fiap-integration-tools/blob/master/producer.png)

#### Log:

Foram processadas 13.301.189 linhas, gerando um log.

#### Ultimas 20 linhas do log gerado pelo producer:
```
integration-tools-python-producer-ms    | SENT TO recipient_topic - PARTITION 0 - OFFSET 13301156
integration-tools-python-producer-ms    | SENT TO recipient_topic - PARTITION 0 - OFFSET 13301157
integration-tools-python-producer-ms    | SENT TO recipient_topic - PARTITION 0 - OFFSET 13301158
integration-tools-python-producer-ms    | SENT TO recipient_topic - PARTITION 0 - OFFSET 13301159
integration-tools-python-producer-ms    | SENT TO recipient_topic - PARTITION 0 - OFFSET 13301160
integration-tools-python-producer-ms    | SENT TO recipient_topic - PARTITION 0 - OFFSET 13301161
integration-tools-python-producer-ms    | SENT TO recipient_topic - PARTITION 0 - OFFSET 13301162
integration-tools-python-producer-ms    | SENT TO recipient_topic - PARTITION 0 - OFFSET 13301163
integration-tools-python-producer-ms    | SENT TO recipient_topic - PARTITION 0 - OFFSET 13301164
integration-tools-python-producer-ms    | SENT TO recipient_topic - PARTITION 0 - OFFSET 13301165
integration-tools-python-producer-ms    | SENT TO recipient_topic - PARTITION 0 - OFFSET 13301166
integration-tools-python-producer-ms    | SENT TO recipient_topic - PARTITION 0 - OFFSET 13301167
integration-tools-python-producer-ms    | SENT TO recipient_topic - PARTITION 0 - OFFSET 13301168
integration-tools-python-producer-ms    | SENT TO recipient_topic - PARTITION 0 - OFFSET 13301169
integration-tools-python-producer-ms    | SENT TO recipient_topic - PARTITION 0 - OFFSET 13301170
integration-tools-python-producer-ms    | SENT TO recipient_topic - PARTITION 0 - OFFSET 13301171
integration-tools-python-producer-ms    | SENT TO recipient_topic - PARTITION 0 - OFFSET 13301172
integration-tools-python-producer-ms    | SENT TO recipient_topic - PARTITION 0 - OFFSET 13301173
integration-tools-python-producer-ms    | SENT TO recipient_topic - PARTITION 0 - OFFSET 13301174
integration-tools-python-producer-ms    | SENT TO recipient_topic - PARTITION 0 - OFFSET 13301175
```

### Resultado Consumer -  Contador de Beneficiários:

![alt image](https://github.com/RodrigoAlmeidaPereira/fiap-integration-tools/blob/master/consumer-beneficiarios.png)

Ultimo beneficiário contabilizado:

```
--
************ Início - Contador de beneficiários ************
Quantidade de beneficiários atual: 13301167
************ Fim - Contador de beneficiários ************
```

### Resultado Consumer - Resumo por UF:

![alt image](https://github.com/RodrigoAlmeidaPereira/fiap-integration-tools/blob/master/consumer-resumo-uf.png)

Ultima contabilização por UF.
```
***************Início - Resumo por UF***************
RR - Valor total parcelas: 9834124.0, Beneficiários: 47497
RS - Valor total parcelas: 6.0279755E7, Beneficiários: 354490
PR - Valor total parcelas: 5.8999954E7, Beneficiários: 365991
DF - Valor total parcelas: 1.2013474E7, Beneficiários: 69504
SC - Valor total parcelas: 2.0459175E7, Beneficiários: 117985
SE - Valor total parcelas: 4.8884806E7, Beneficiários: 288139
MA - Valor total parcelas: 2.07647756E8, Beneficiários: 972903
MG - Valor total parcelas: 1.83706287E8, Beneficiários: 1029564
SP - Valor total parcelas: 1.84960016E8, Beneficiários: 1070976
CE - Valor total parcelas: 1.96867247E8, Beneficiários: 1055270
AC - Valor total parcelas: 2.3694601E7, Beneficiários: 89161
MS - Valor total parcelas: 2.2151085E7, Beneficiários: 124838
MT - Valor total parcelas: 2.5909348E7, Beneficiários: 156319
GO - Valor total parcelas: 4.6587782E7, Beneficiários: 298106
AL - Valor total parcelas: 7.8066841E7, Beneficiários: 406587
AM - Valor total parcelas: 9.2300219E7, Beneficiários: 403149
ES - Valor total parcelas: 3.0538232E7, Beneficiários: 177185
AP - Valor total parcelas: 1.6851337E7, Beneficiários: 76075
PA - Valor total parcelas: 1.92441296E8, Beneficiários: 961231
PB - Valor total parcelas: 1.0371451E8, Beneficiários: 517771
PE - Valor total parcelas: 2.11486438E8, Beneficiários: 1161552
RJ - Valor total parcelas: 1.54621541E8, Beneficiários: 852098
PI - Valor total parcelas: 9.3796821E7, Beneficiários: 449697
TO - Valor total parcelas: 117670.0, Beneficiários: 790
RN - Valor total parcelas: 6.5341029E7, Beneficiários: 353736
RO - Valor total parcelas: 1.2118141E7, Beneficiários: 79434
BA - Valor total parcelas: 3.38579562E8, Beneficiários: 1821119

***************Fim - Resumo por UF***************
```
### Resultado Esperado Consumer - Beneficiário com a Maior Parcela:

![alt image](https://github.com/RodrigoAlmeidaPereira/fiap-integration-tools/blob/master/consumer-maior-parcela.png)

Ultimos 6 resultados de beneficiários do log:
```
----------------------------------------------
--
************ Beneficiário com a maior parcela ************
NIS_Favorecido: 23692693288
NOME_FAVORECIDO: ANGELINA MEME MONTEZA YINE
VALOR_PARCELA: 1070.0
NOME_MUNICIPIO: ASSIS BRASIL
UF: AC
----------------------------------------------
--
************ Beneficiário com a maior parcela ************
NIS_Favorecido: 23654268710
NOME_FAVORECIDO: JOSE CLARO SANTIAGO
VALOR_PARCELA: 1158.0
NOME_MUNICIPIO: CAPIXABA
UF: AC
----------------------------------------------
--
************ Beneficiário com a maior parcela ************
NIS_Favorecido: 21201695084
NOME_FAVORECIDO: ANTONIA LOBATO MARTINS
VALOR_PARCELA: 1292.0
NOME_MUNICIPIO: CRUZEIRO DO SUL
UF: AC
----------------------------------------------
--
************ Beneficiário com a maior parcela ************
NIS_Favorecido: 16223162562
NOME_FAVORECIDO: GADIE PEREIRA DE ARAUJO
VALOR_PARCELA: 1426.0
NOME_MUNICIPIO: CRUZEIRO DO SUL
UF: AC
----------------------------------------------
--
************ Beneficiário com a maior parcela ************
NIS_Favorecido: 12445306797
NOME_FAVORECIDO: CEZANILDO ABREU DE SOUSA
VALOR_PARCELA: 1447.0
NOME_MUNICIPIO: AQUIRAZ
UF: CE
----------------------------------------------
--
************ Beneficiário com a maior parcela ************
NIS_Favorecido: 13495158897
NOME_FAVORECIDO: ROMAX LEITE TEIXEIRA
VALOR_PARCELA: 1782.0
NOME_MUNICIPIO: PERITORO
UF: MA
----------------------------------------------
```

## Integrantes do Grupo:

> Flavio Alves Ferreira da Silva - RM 333565

> Pedro Madi Della Coletta - RM 334109

> Rafael Miranda de Almeida - RM 333829

> Rodrigo de Almeida Pereira - RM 333241

> Wellington Moreira Bastos - RM 333878