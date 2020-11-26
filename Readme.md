#Desafio de QA da Delivery Much!
Suponha que o time de desenvolvimento recebeu a demanda de criar um serviço web que
converte números decimais em sua versão por extenso. Este sistema obedecerá às
seguintes regras:
1. Servidor HTTP que funcionará apenas para requisições GET;
2. Sistema permitirá utilizar apenas números no intervalo entre [-10000, 10000];
3. Ao se fazer essa requisição, retornará um JSON cuja chave "extenso" terá, em
seu valor, o número inteiro por extenso, que foi inserido no path;
4. Pensando-se na internacionalização deste, o serviço terá suporte, além de
português, para também em inglês;
5. Caso não seja possível converter o valor inserido na path, chave “extenso” terá
valor “Invalid data”;
6. Para estes casos, resposta deve ter status 400;
7. Para os casos válidos, resposta deve ter status 200.
Sendo assim, a equipe de desenvolvimento disponibilizou o serviço web
http://challengeqa.staging.devmuch.io, que permitiu que se visualizasse dois tipos de
resposta (http://challengeqa.staging.devmuch.io/10 ou
http://challengeqa.staging.devmuch.io/en/10).


------------

------------
# Informações do Projeto
Conforme analisado o desafio, os testes devem ser direcionados para testes de API, onde para tal qualquer ferramenta seria utilizável (Postman, JMeter, NightWatch, Robot, C#, Java...).

Optei por utilizar o Java, utilizando o framework [Quimera](https://github.com/NexEngine/Quimera) que eu mesmo criei  e vinha usando para implantas testes de API e Interface, este é integrado com RestAsured.io para testes de API, e utiliza o selenium-webdriver para testes de interface, além de ter um biblioteca com utilitários para banco de dados, asserts e outros.

## Requisitos
Os testes do projeto têm requisitos para serem executados, alguns softwares e configurações terão de estar instalados na máquina, ou os testes não poderão ser executados, os requisitos são:

1. [**Java JDK 11**](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html)
	O java é necessário para a compilação do projeto, o mesmo utiliza o JDK 11, e por isto este terá de estar instalado na máquina, e a variável de ambiente JAVA_HOME deverá estar configurada.
2. [**Maven**](http://maven.apache.org/download.cgi)
	O maven é responsável de puxar as dependências do projeto para a sua máquina, ele também é o responsável por chamar o Java e compilar o projeto, além de executar os testes por ele de maneira fácil.
3. [**Allure Framework**](https://docs.qameta.io/allure/#_windows)
	O Allure é o gerador de relatórios personalizado, a pasta do projeto `allure-results` armazena os dados das execuções, para ser extraído e gerado uma linda página com gráficos e detalhes dos testes.



**Important**
Caso não queira instalar o `Allure Framework`, não preocupe-se, você poderá encontrar os relatórios padrões do TestNG na pasta `test-output`, abrindo o arquivo `index.html`.

## Recomendações
Como o projeto usa o Quimera, e o mesmo utiliza o TestNG além de ser programado na IDE Eclipse. Recomendo que caso não possua faça o [Download do Eclipse](https://www.eclipse.org/downloads/), e ao abrir o mesmo, ir até o marketplace e instalar o plugin do TestNG, conforme recomendado na própria página do [TestNG](https://testng.org/doc/eclipse.html).
**Important**
Muito importante que os requisitos já devem estar atendidos, além disso, não é necessário acrescentar o TestNG ao POM.xml do projeto, apenas instalar a extensão.

## Arquivo de Configuração
O Quimera usa um arquivo de configuração chamado de `TestEnvironmentConfigurationFile`, este é um arquivo Json. Para este projeto não precisaremos preenchê-lo tanto, apenas o que relacionado a API que iremos validar, ou seja, iremos preencher o `Protocol` e o `Host` do node `HttpConfigs`, teremos algo assim:

```
"HttpConfigs" : {
		"protocol" : "http",
		"host" : "challengeqa.staging.devmuch.io",
		"port" : "",
		"patch" : "",
		"version" : "",
		"typeRequest" : ""
	}
```

Com as informações preenchidas o projeto já está pronto para ser executado, mas vale antes comentar sobre as classes de testes criadas e o objetivo de cada uma delas.

Mas antes disto, vale comentar que o projeto foi pensado para ser o mais versátil possível, por isto o mesmo conta com um arquivo de dados, que é utilizado nos testes. Este arquivo é o `NumbersDataSource.csv`, ele contém duas colunas sendo `number` e `StatusCode` que representam basicamente o que o próprio nome fala, onde o Number é o número que será validado, e o StatusCode é o código de retorno da API que será esperada. Mas pera que tem mais, os dados desse arquivo podem ser inseridos de três formas diferentes, e isso muda como os testes irão se comportar, observe:

1. **Radômico**
	- **Objetivo:** O modo randômico, tem como objetivo escolher ele mesmo os números para serem validados as extensões, porém as validações de código de retorno segue a coluna `StatusCode`.
	- **Modo De Uso:** Para definir como randômico, basta informar `§` na linha da coluna `Number`. Assim a automação irá escolher uma quantidade de números aleatória entre -10000 e 10000.
2. **Direcionado**
	- **Objetivo:** Você quer testar valores de 1 a 10 porém não quer criar uma linha para cada? Então este é o modo que procura. Neste modo você insere dois números e a automação se encarrega de contar e validar toda a extensão de número.
	- **Modo De Uso:** Assim como o anterior, o direcionado não é complicado, basta na coluna `Number` preencher com dois números separados por vírgula, por exemplo:
```
Number;StatusCode
1,10;200
```

3. **Único**
	- **Objetivo:** Diferente dos modos anteriores, este é o modo manual. Para cada linha um número e seu StatusCode respectivo.
	- **Modo De Uso:** Como dito, basta informar para cada linha um número na coluna `Number` e um status de retorno na coluna `StatusCode`, por exemplo:
```
Number;StatusCode
1;200
2;200
-2;200
-100001;400
```
Visto os modos de inserção de dados, estamos prontos para a explanação das classes de testes e suas respectivas funções.

## Classes de Teste e Suas Funções
Foram criadas duas classes de testes, uma para cada tipo de validação, no caso uma para cada Linguagem, destaco agora que a validação da palavra está sendo feita por um algoritmo criado, porém não entra no âmbito neste momento, enfim, as classes de testes estão dentro do caminho padrão de classes de testes `src\test\java\` e dentro deste há um pacote, o `deliverymuchbrasil.com.automation_test` que contém nossas queridas classes de testes, estas que são:

- **ValidateExtendNumberENUS**
	- **Objetivo:** Conter as funções de teste para a língua estrangeira.
	- **Funções:**
		- **validateInvalidNumberENUS**
			Valida como a API se comporta com uma informação inválida, como por exemplo -100001.
		- **validateStatusCodeENUS**
			Valida código de status da URL quando informado um número.
		- **validateNumberExtensionENUS**
			Valida a palavra estendida de retorno da API quando informado um número.
- **ValidateExtendNumberPTBR**
	- Objetivo: Conter as funções de teste para a nossa língua.
	- **Funções:**
		- **validateInvalidNumberPTBR**
			Valida como a API se comporta com uma informação inválida, como por exemplo -100001.
		- **validateStatusCodePTBR**
			Valida código de status da URL quando informado um número.
		- **validateNumberExtensionPTBR**
			Valida a palavra estendida de retorno da API quando informado um número.
	

## Execução de Testes Pela Linha de Comando
Vamos para o que interessa, a execução da parada toda. Dito isto vamos no momento nos abster da IDE, e iremos executar os testes pelo CMD via Command Line.

digamos que você ajustou o arquivo `NumbersDataSource.csv` e está coçando a mão para conseguir executar, primeiramente, você deverá abrir a raiz do projeto, onde está o arquivo `TestEnvironmentConfigurationFile.json` e o `POM.xml`. Feito isto abra o prompt de comando (CMD) nesta pasta.

Antes de executar os testes propriamente dito, execute primeiramente os comandos abaixo:
```
mvn clean
mvn compile
```
Feito isso uma tela preta com a descrição `Build Succefull` deverá ser exibida, após isso você pode executar os comandos para os testes maven, por exemplo digamos que queira executar ambas as classes. Para isso basta usar o comando:
```
mvn -Dtest=ValidateExtendNumberPTBR,ValidateExtendNumberENUS -DfailIfNoTests=false test
```

Legal você vai ver altas letrinhas subindo pelo prompt, indicando que os testes estão sendo efetuados.

A princípio a execução por Prompt é isto no momento, podemos acrescentar Tags, Story e outros atributos nos testes para facilitar a busca de testes, além do TestNG permitir criar suites de testes.

## Execução de Testes Pela IDE
Pela IDE a coisa se torna mais simples e rápida até, com a IDE aberta e com a extensão do TestNG instalada na IDE, clique com o botão direito na classe e selecione `Run as>Test NGTest` e pronto, os testes irão ser executados.

## Extração de Relatório (Allure Framework)
Agora que executamos os projetos, podemos extrair os relatórios, vamos primeiro focar no Allure, para usá-lo temos que ter o mesmo instalado conforme os requisitos.

Com ele instalado, você pode abrir o Prompt de Comando (CMD) e colocar o comando abaixo:
```
allure serve "<Pasta allure-results>"
```
Apenas troque o `<Pasta allure-results>` pela pasta `allure-results` que está na raiz do seu projeto, por exemplo:
```
allure serve "D:\Projetos\Provas\Workspace\automation_test\allure-results"
```
Espere o navegador abrir e Voilá, temos um relatório incremental, dinâmico e bonito prontinho.

## Extração de Relatório (Padrão TestNG)
Bom se você não se interessa pelo relatório do Allure, ou não conseguiu instalar o mesmo, não se apavore, ainda temos um relatório criado por padrão pelo TestNG, este que não é tão bonito, porém ainda tem as informações básicas que precisamos, encontra-se na pasta `test-output`, que fica na raiz do seu projeto. 

**Important**
Só um ponto de atenção, este relatório não é acumulativo como o Allure ou outros, se você executar um teste as informações do teste anterior se perdem para dar lugar as novas.
