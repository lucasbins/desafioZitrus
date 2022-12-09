# desafioZitrus
## Requisitos para o sistema

* <a href="https://www.enterprisedb.com/downloads/postgres-postgresql-downloads">Postgresql - ^15.1</a>
* <a href="https://www.jetbrains.com/pt-br/idea/download">Intellij IDEA </a>

**************************

## Procedimentos para instalação do sistema

* Após instalação do Postgresql, crie um banco de dados - <a href="https://hcode.com.br/blog/o-que-e-o-postgresql-instalando-e-criando-primeiro-banco-de-dados">Link do passo a passo</a>
* Altere os dados do banco de dados nos arquivos liquibase.propries e ConnectionFactory.

### liquibase.properties
````
url=jdbc:postgresql://localhost:5432/SEU_BANCO
username=SEU_USUARIO
password=SUA_SENHA
````
### ConnectioFactory
````
 return DriverManager.getConnection("jdbc:postgresql://localhost:5432/SEU_BANCO", "SEU_USUARIO", "SUA_SENHA");
````

* Após Instale as dependecias com o Maven.

````mvn install````

ou na aba Maven do Intellij

<img src="https://media.discordapp.net/attachments/897996889495076938/1050632756461326397/image.png"/>

* Instalado as dependencias atualize liquibase, selecionando na aba do maven o plugin.
>liquibase:update

<img src="https://cdn.discordapp.com/attachments/897996889495076938/1050633518583119992/image.png"/>

* Depois das tabelas criadas, rode o servidor da aplicação selecionando o plugin 
> Jetty:run

<img src="https://cdn.discordapp.com/attachments/897996889495076938/1050634344642904134/image.png"/>

* Com isso a aplicação ja estará funcionando.
* Agora acesse
>localhost:8080/zitrusWeb

*****************************************

