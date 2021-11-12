
Feature: Preencher Formulario 

Scenario: Acessar site da tricentis e prencher todos os formuçários
		Given que estou no site da tricentis
  	When preencher <Marca> <Modelo> <Cilindrada> <Desempenho> <DataFabricacao> <Assentos> <Assentos2> <TipoCom> <Payload> <TotalWheit> <PesoT> <PrecoTabela> <KM> do formulario da aba enteer Vehicle Data e clicar em Next
  	And preencher <PrimeiroNome> <UltimoNome> <Nascimento> <Genero> <Cep> <Pais>  <Ocupacao> <Hobbies> os dados do formulario da aba enter Insurante Data e clicar em Next
    And <DataInicio> <SomaSeguro> <Classificao> <Segurodanos> <Produtos> <Carro> preencher os dados do formulario da aba enter Product Data e clicar em Next
  	And selecionar <Opcao> do formulario da aba Select Prince Option e clicar em Next
    And preencher <Email> <User> <Senha> <ConfirmaSenha>  dados do formulario da aba Send Quote
    When clico em Send
    Then O cadastro deve ser criado com sucesso e clicar em ok 

Examples:
| Marca | Modelo   | Cilindrada | Desempenho | DataFabricacao | Assentos | Assentos2 | TipoCom | Payload | TotalWheit | PesoT    | PrecoTabela | KM      | PrimeiroNome | UltimoNome | Nascimento   | Genero     | Cep    |  Pais   | Ocupacao | Hobbies | DataInicio   | SomaSeguro | Classificao   | Segurodanos   | Produtos         | Carro | Opcao   |  Email                     | User   |    Senha         | ConfirmaSenha   |
| "BMW" |"Moped"   | "123"      | "1"   		 | "05/05/1999"   | "1"      | "2"       | "Gas"   | "800"   | "20500"		|  "5000"  | "10000"		 | "11000" | "Caio"			  | "Augusto" | "05/06/1999" | "Masculino"| "5555"	| "Brazil"| "Farmer" | "Other" | "05/07/2030" | "3000000"  | "Super Bonus" | "No Coverage" | "Euro Protection"| "No"  | "Silver"| "caio18augusto@outlook.com"| "caioo"| "Caioaugusto2312"| "Caioaugusto2312"|