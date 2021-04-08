#language en
@Rob3
Feature: F00_VALIDAR_CADASTRO_SUCESSO_CLIENTE

  Scenario: validar cadastro do cliente apos preencher todos os campos obrigatorios
    Given usuario acessa home aplicacao "extra"
    And seleciona para cadastrar cliente
    And responder pergunta possui um cadastro com nao