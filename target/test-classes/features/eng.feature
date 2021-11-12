Feature: Criando conta Facebook 

Scenario: Criando conta Facebook 

Given que esteja na pagina de cadastro do Facebook 
When preencho "nome" e  "sobrenome"
And preencho "e-mail" e "Repetir e-mail" 
And preencho "senha" e data de nascimento
And clico no genero "Masculino"
Then aparece mensagem de cadastro  

