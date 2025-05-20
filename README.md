# Conversor de Moedas via ExchangeRate-API (IntelliJ IDEA)

Este é um programa Java simples que utiliza a API [ExchangeRate-API](https://www.exchangerate-api.com/) para obter as taxas de câmbio mais recentes do Real Brasileiro (BRL), Dólar Americano (USD), Euro (EUR), Libra Esterlina (GBP), Peso Argentino (ARS) e Peso Chileno (CLP). O programa oferece um menu interativo para que o usuário possa escolher a sigla da moeda base (qualquer moeda) para conversão e a moeda de destino desejada. Este README fornece instruções específicas para executar o projeto utilizando a IDE IntelliJ IDEA.

## Funcionalidades

* Obtém as taxas de câmbio em tempo real.
* Apresenta um menu no console para o usuário selecionar a moeda de conversão desejada.
* Exibe a taxa de câmbio selecionada.
* Estrutura do código em duas classes para melhor organização:
    * `Principal`: Contém a função `main` e a lógica do menu de interação com o usuário.
    * `ConversorMoeda`: Encapsula a lógica de comunicação com a API e o parsing dos dados JSON.

## Pré-requisitos

* **IntelliJ IDEA** instalado no seu sistema.
* **Java Development Kit (JDK)** configurado no IntelliJ IDEA.
* **Uma chave de API válida da [ExchangeRate-API](https://www.exchangerate-api.com/)**. Você precisará se registrar no site para obter sua chave. **Substitua a chave de API placeholder no código pela sua chave real.**
* **Biblioteca Gson:** O programa utiliza a biblioteca Gson para trabalhar com dados JSON. Você precisará adicionar o arquivo JAR do Gson ao seu projeto no IntelliJ IDEA.

## Como Usar no IntelliJ IDEA

1.  **Obtenha sua chave de API:** Registre-se no [ExchangeRate-API](https://www.exchangerate-api.com/) para obter sua chave de API gratuita ou paga, dependendo do seu uso.
2.  **Abra o Projeto no IntelliJ IDEA:**
    * Se você clonou o repositório Git, selecione "Open" na tela de boas-vindas do IntelliJ IDEA e navegue até a pasta do projeto.
    * Se você tem os arquivos localmente, crie um novo projeto "Java" (se necessário) e copie os arquivos `Principal.java` e `ConversorMoeda.java` para a pasta `src` do seu projeto.
3.  **Adicione a Dependência Gson:**
    1.  Baixe o arquivo JAR do Gson (por exemplo, do [Maven Repository](https://mvnrepository.com/artifact/com.google.code.gson/gson)).
    2.  No IntelliJ IDEA, vá em "File" -> "Project Structure".
    3.  Selecione "Modules" na barra lateral.
    4.  Clique na aba "Dependencies".
    5.  Clique no botão "+" e selecione "JARs or directories...".
    6.  Navegue até o arquivo JAR do Gson que você baixou e selecione-o.
    7.  Clique em "OK".
4.  **Atualize a Chave de API:** Abra o arquivo `Principal.java` no editor do IntelliJ IDEA e substitua a chave de API placeholder pela sua chave de API real.
5.  **Execute o Programa:**
    * Abra o arquivo `Principal.java` no editor.
    * Clique com o botão direito em qualquer lugar dentro do arquivo `Principal.java`.
    * No menu de contexto, selecione "Run 'Principal.main()'".

    O IntelliJ IDEA irá compilar e executar o programa. A saída do menu interativo será exibida na janela "Run" na parte inferior da IDE.
6.  **Siga o Menu:** Na janela "Run", digite a sigla de uma moeda base (qualquer moeda) para conversão e no menu aberto digite o número correspondente à moeda para a qual você deseja ver a taxa de câmbio em relação a moeda base escolhida e pressione Enter.
7.  **Veja o Resultado:** A taxa de câmbio para a moeda selecionada será exibida na janela "Run".
8.  **Para Sair:** Digite `7` na janela "Run" e pressione Enter.

## Estrutura do Projeto no IntelliJ IDEA

```
seu-projeto/
├── src/
│   ├── ConversorMoeda.java
│   └── Principal.java
├── .idea/         # Diretório de configurações do IntelliJ IDEA
└── [gson-2.13.1.jar] # Arquivo JAR do Gson adicionado diretamente
└── README.md
```

## Notas para IntelliJ IDEA

* Este guia assume que você não está utilizando um gerenciador de projetos como Maven ou Gradle.
* Certifique-se de que o arquivo JAR do Gson foi adicionado corretamente como uma dependência do seu módulo no IntelliJ IDEA.
* A IDE cuidará da compilação automática do código antes da execução.
* A janela "Run" fornece um ambiente interativo para inserir a opção do menu e visualizar a saída do programa.

## Autor

Marcio Santos

## Licença

Apache License 2.0


