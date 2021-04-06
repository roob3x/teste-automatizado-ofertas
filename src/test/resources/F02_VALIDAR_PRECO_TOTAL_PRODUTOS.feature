#language en
@Rob2
Feature: F02_VALIDAR_PRECO_TOTAL_PRODUTOS

  Scenario: valida que o valor total de compra esta equivalente a quantida de produto
    Given usuario acessa home aplicacao "extra"
    And procura pelo produto "iphone 12 verde 64gb"
    When seleciona o produto com valor mais barato 4700.00
    And Seleciona botao comprar
    And Selecionar botao continuar
    And Seleciona comprar mais produtos
    And procura pelo produto "airpods pro"
    When seleciona o produto com valor mais barato 2300.00
    And Seleciona botao comprar
    Then validar que a soma do produto corresponde ao valor subtotalprodutos


