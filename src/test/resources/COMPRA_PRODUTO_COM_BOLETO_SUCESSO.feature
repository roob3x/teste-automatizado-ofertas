#language en
@Rob
Feature: COMPRA_PRODUTO_COM_BOLETO_SUCESSO

  Scenario: realizar a compra do produto e pagar com boleto
    Given usuario acessa home aplicacao "extra"
    And procura pelo produto "macbook pro 256gb"
    And seleciona o produto com valor mais barato
    And Seleciona botao comprar
    And Selecionar botao continuar
    And seleciona valor total de produtos em tela
    When o valor do produto estiver menor igual a 13000.09
    And finalizar compra em meu carrinho
    And preencher campo login
    And preencher campo senha
    And clicar no botao continuar tela idetificacao login
    And selecionar ir para pagamento
    And selecionar boleto como forma de pagamento
    When valor total de compra na tela de pagamento for menor ou igual a 13000.00
    Then finalizar compra
