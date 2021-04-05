#language en
@Rob1
Feature: F01_VALIDAR_PRECO_PRODUTO

  Scenario Outline: valida que o valor do produto está com o valor correto e  7% de desconto
    Given usuario acessa home aplicacao "extra"
    And procura pelo produto <product>
    When seleciona o produto com valor mais barato <normalprice>
    Then validar que o valor corresponde a 7% de desconto do valor total do produto
    #And seleciona comprar
    #And seleciona continuar
    #And validar que o valor corresponde a 7% de desconto do valor total do produto
    #And seleciona concluir compra
    #And preencher login
    #And preencher senha


    Examples:
      | product | normalprice |
      | "iphone 12 pro max 128gb"| 8500.0 |