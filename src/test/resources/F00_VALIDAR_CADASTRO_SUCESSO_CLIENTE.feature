#language en
@Rob3
Feature: F00_VALIDAR_CADASTRO_SUCESSO_CLIENTE

  Scenario: validar cadastro do cliente apos preencher todos os campos obrigatorios
    Given usuario acessa home aplicacao "extra"
    And seleciona para cadastrar cliente
    And responder pergunta possui um cadastro com nao
    And preencher nome completo com "fulano de tal"
    And preencher cpf
    And preencher telefone "55987777777""
    And preencher data de nascimento"26/04/1986"
    And preencher genero "Masculino"
    And preencher email "fulanodeltal@hotmail.com"
    And preencher senha "biscoitorecheado123"
    And selecionar check aceitar todas as opcoes abaixo
    When selecionar botao continuar tela de identificacao
    Then validar que o pop salvar senha foi exibido