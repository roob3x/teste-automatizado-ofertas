#language en
@Rob
Feature: F02_VALIDAR_PRECO_TOTAL_PRODUTOS

  Scenario: valida que o valor total de compra esta equivalente a quantidade de produto
    Given usuario acessa home aplicacao "extra"
    And procura pelo produto "macbook pro 256gb"
    When seleciona o produto com valor mais barato 13000.0
    And Seleciona botao comprar
    And Selecionar botao continuar
    And Seleciona comprar mais produtos
    And procura pelo produto "iphone 12 pro max 256gb"
    When seleciona o produto com valor mais barato 9000.0
    And Seleciona botao comprar
    And seleciona valor total de produtos em tela
    Then validar que a soma do produto corresponde ao valor subtotalprodutos


