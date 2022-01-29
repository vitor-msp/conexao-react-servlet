# Conexão React Servlet
###### Repositório criado com o intuito de orientar sobre uma conexão básica de uma aplicação React com um backend em Java usando Servlet.

#### Geral

Nosso frontend será desenvolvido normalmente em React e nosso backend normalmente usando Servlet com conexão ao banco de dados usando JDBC.

A comunicação do front com o back será da seguinte forma:

1. React faz uma requisição para o back (usando a biblioteca Axios)
2. No back, a requisição é capturada e passada para uma classe (filtro) que irá adiconar permissões à requisição
3. A requisição (agora com permissões) será entregue ao Servlet
4. O Servlet cria um array de exemplo, converte para json e devolve a resposta ao front
5. No front, o Axios recebe a resposta e exibe no console

#### Configurações

Será necessário fazer 3 configurações:

1. Adição da classe filtro no Dynamic Web Project
2. Adição do Jar externo para usar json no Dynamic Web Project
3. Adição da biblioteca Axios no React

#### Implementação

1. Crie seu Dynamic Web Project normalmente e configure a conexão com seu banco de dados
2. Servlet e banco de dados se comunicando sem problemas, adicione um pacote chamado 'meusfiltros' em src/main/java, neste pacote adicione a classe 'MeuFiltro'
3. Adicione o jar externo (Gson) no seu projeto (botão direito na pasta do projeto no Eclipse, build path... da mesma forma que adicionou o conector com o banco de dados)  
4. Agora, adicione o jar externo (Gson) na inicialização do seu projeto: botão direito na pasta do seu projeto -> 'Properties' -> 'Deployment Assembly' -> /src/main/webapp -> 'Add' -> 'Java Build Path Entries' -> 'Next' -> selecione o pacote gson -> 'Finish' -> 'Apply and Close'
5. No seu Servlet, será necessário apenas devolver a resposta como json, em vez de chamar um arquivo .jsp. Você pode adicionar como exemplo um pacote chamado 'meusservlets' em src/main/java, e neste pacote adicionar o servlet 'MeuServlet'
6. Execute seu back em Java pelo Tomcat e guarde o link gerado, no meu caso o link foi 'http://localhost:8080/conexao-react-servlet/' (não se preocupe com o erro 404, ele ocorre pois ainda não temos uma 'página inicial')
7. No seu projeto React já criado, adicione o pacote Axios com um dos comandos abaixo:
```
npm install axios

yarn add axios
```
8. Após a instalação do Axios, substitua o arquivo 'App.js' pelo que está neste repositório para ver funcionando, sugiro não apagar o 'App.js' antigo, apenas renomeie, assim evita que você perca alguma configuração que já tenha feito
9. Execute sua aplicação React e abra o console, se tudo deu certo você verá o array configurado lá no back

Assim acaba o exemplo, a partir daqui adeque os códigos ao seu projeto e pesquise mais sobre o assunto ou sobre os possíveis erros gerados para seu site funcionar bem
