#language en
@Rob
Feature: F00_VALIDAR_CADASTRO_SUCESSO_CLIENTE

  Scenario: validar cadastro do cliente apos preencher todos os campos obrigatorios e
    exibir recaptcha


    Given usuario acessa home aplicacao "extra"
    And seleciona para cadastrar cliente
    And responder pergunta possui um cadastro com nao
    And preencher nome completo com "fulano de tal"
    And preencher cpf
    And preencher telefone "81987777777""
    And preencher data de nascimento "26/04/1986"
    And preencher genero "Masculino"
    And preencher email "@hotmail.com"
    And preencher senha "biscoito123"
    And selecionar check aceitar todas as opcoes abaixo
    When selecionar botao continuar tela de identificacao
    Then validar que foi para tela inicial e exibe popup salvar senha para fechar