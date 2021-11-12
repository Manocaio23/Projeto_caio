# language: pt

Funcionalidade: Formulário Facebook

Cenário: 
Dado que esteja na pagina de cadastro do Facebook 
Quando preencho "nome" e  "sobrenome"
E preencho "e-mail" e "Repetir e-mail" 
E preencho "senha" e data de nascimento
E clico no genero "Masculino"
Então aparece mensagem de cadastro 