#language en
  @Rob
  Feature: BUSCAR_OFERTA_EXTRA
    Dado que o usuario entra no e-comerce
    E realiza busca promocao
    E produto esteja abaixo do limite desejado
    Entao realizar compra do produto
Scenario Outline: Scenario: Buscar por ofertas
  Given user enjoy on extra e-comerce with "extra"
  And search for the <product>
  When product is on sale less than <normalprice>
  #Then do purchase
  Examples:
  | product | normalprice |
  | "iphone 11 64gb"| 3700.0  |
