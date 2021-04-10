package Steps;

import Constants.URL_PAGE;
import Interacao.IinteracaoSeleniumJavaWeb;
import Pages.Extra.*;
import Pages.Search.MainPageSearch;
import Support.Convert;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import Tdm.TDM;

import java.io.IOException;


public class ExtraSteps {
    IinteracaoSeleniumJavaWeb i = new IinteracaoSeleniumJavaWeb();


    @Given("user enjoy on extra e-comerce with {string}")
    public void userEnjoyOnExtraEComerceWith(String texto) throws IOException {
        i.abrirURL(URL_PAGE.MAIN_PAGE_SEARCH);
        i.esperarElementoExistirNaTela(MainPageSearch.INPUT_MAIN_SEARCH, 10);
        i.escreverRobot(texto);
        i.enter();
        i.esperarElementoExistirNaTela(MainPageSearch.LABEL_TEXT_EXTRA, 5);
        i.click(MainPageSearch.LABEL_TEXT_EXTRA);
    }


    @Given("search for the {string}")
    public void searchForThe(String produto) throws InterruptedException, IOException {
        i.esperarElementoExistirNaTela(HomePageExtra.INPUT_HOME_BUSCA_EXTRA, 10);
        i.escrever(HomePageExtra.INPUT_HOME_BUSCA_EXTRA, produto);
        i.esperar1Segundo();
        i.enter();
    }

    @When("product is on sale less than {double}")
    public void productIsOnSaleLessThan(Double price) throws IOException {
        i.esperarElementoExistirNaTela(HomePageExtra.TEXT_PRICE_PRODUCT, 30);
        i.vertificaProdutoMenorValorDaListeSeleciona(HomePageExtra.TEXT_PRICE_PRODUCT, price);
        // Write code here that turns the phrase above into concrete actions

    }

    @Given("usuario acessa home aplicacao {string}")
    public void usuarioAcessaHomeAplicacao(String texto) throws IOException {
        // Write code here that turns the phrase above into concrete actions
        i.abrirURL(URL_PAGE.MAIN_PAGE_SEARCH);
        i.esperarElementoExistirNaTela(MainPageSearch.INPUT_MAIN_SEARCH, 10);
        i.escreverRobot(texto);
        i.enter();
        i.esperarElementoExistirNaTela(MainPageSearch.LABEL_TEXT_EXTRA, 5);
        i.click(MainPageSearch.LABEL_TEXT_EXTRA);

    }

    @Given("seleciona para cadastrar cliente")
    public void selecionaParaCadastrarCliente() throws IOException, InterruptedException {
        // Write code here that turns the phrase above into concrete actions
        i.esperarElementoExistirNaTela(HomePageExtra.LABEL_ENTRE_OU_CADASTRE, 10);
        i.esperar1Segundo();
        i.moverParaElemento(HomePageExtra.LABEL_ENTRE_OU_CADASTRE);
        i.click(HomePageExtra.LABEL_CADASTRE_AQUI);
    }

    @Given("responder pergunta possui um cadastro com nao")
    public void responderPerguntaPossuiUmCadastroComNao() throws IOException, InterruptedException {
        // Write code here that turns the phrase above into concrete actions
        i.esperarElementoExistirNaTela(Cadastro.RADIO_PRIMEIRA_COMPRA, 10);
        i.click(Cadastro.RADIO_PRIMEIRA_COMPRA);
        i.esperar1Segundo();
        i.click(Cadastro.BTN_CONTINUAR);
    }

    @Given("preencher nome completo com {string}")
    public void preencherNomeCompletoCom(String texto) throws IOException {
        // Write code here that turns the phrase above into concrete actions
        i.esperarElementoExistirNaTela(Identificacao.INPUT_NOME_COMPLETO, 10);
        i.escrever(Identificacao.INPUT_NOME_COMPLETO, texto);
        i.tab();
    }

    @Given("preencher cpf")
    public void preencherCpf() throws IOException {
        // Write code here that turns the phrase above into concrete actions
        i.esperarElementoExistirNaTela(Identificacao.INPUT_CPF, 10);
        i.escrever(Identificacao.INPUT_CPF, i.geradorCPF());
        i.tab();


    }

    @Given("preencher telefone {string}\"")
    public void preencherTelefone(String texto) throws IOException, InterruptedException {
        String ddd = texto.substring(0, 2);
        String telefone = texto.substring(2, 11);
        i.esperarElementoExistirNaTela(Identificacao.INPUT_TELEFONE_1_DDD, 10);
        i.escrever(Identificacao.INPUT_TELEFONE_1_DDD, ddd);
        i.esperar1Segundo();
        i.escrever(Identificacao.INPUT_TELEFONE_1_NUMERO, telefone);

    }

    @Given("preencher data de nascimento {string}")
    public void preencherDataDeNascimento(String texto) throws IOException, InterruptedException {
        // Write code here that turns the phrase above into concrete actions
        String dia = texto.substring(0, 2);
        String mes = texto.substring(3, 5);
        String ano = texto.substring(6, 10);
        i.esperarElementoExistirNaTela(Identificacao.INPUT_DATANASC_DIA, 10);
        i.escrever(Identificacao.INPUT_DATANASC_DIA, dia);
        i.esperar1Segundo();
        i.escrever(Identificacao.INPUT_DATANASC_MES, mes);
        i.esperar1Segundo();
        i.escrever(Identificacao.INPUT_DATANASC_ANO, ano);
        i.tab();

    }


    @Given("preencher genero {string}")
    public void preencherGenero(String texto) throws IOException, InterruptedException {
        // Write code here that turns the phrase above into concrete actions
        i.esperar1Segundo();
        if (texto.equals("Masculino")) {
            i.click(Identificacao.RADIO_GENERO_MASCULINO);
        } else {
            i.click(Identificacao.RADIO_GENERO_FEMININO);
        }

    }

    @Given("preencher email {string}")
    public void preencherEmail(String texto) throws IOException {
        // Write code here that turns the phrase above into concrete actions
        i.esperarElementoExistirNaTela(Identificacao.INPUT_EMAIL, 10);
        i.escrever(Identificacao.INPUT_EMAIL, i.geradorCPF()+texto);
        String nome = i.retornarValueDoElemento(Identificacao.INPUT_EMAIL);
        i.tab();
        i.escreverRobot(nome);
        System.out.println("nome = "+nome);
        i.tab();
    }

    @Given("preencher senha {string}")
    public void preencherSenha(String texto) throws IOException {
        // Write code here that turns the phrase above into concrete actions
        i.esperarElementoExistirNaTela(Identificacao.INPUT_SENHA, 10);
        i.escrever(Identificacao.INPUT_SENHA, texto);
        i.tab();
        i.escreverRobot(texto);
        i.tab();
    }

    @Given("selecionar check aceitar todas as opcoes abaixo")
    public void selecionarCheckAceitarTodasAsOpcoesAbaixo() throws IOException {
        // Write code here that turns the phrase above into concrete actions
        i.esperarElementoExistirNaTela(Identificacao.CHECK_ACEITAR_TDS_OCPES, 10);
        i.click(Identificacao.CHECK_ACEITAR_TDS_OCPES);
    }

    @When("selecionar botao continuar tela de identificacao")
    public void selecionarBotaoContinuarTelaDeIdentificacao() throws InterruptedException, IOException {
        // Write code here that turns the phrase above into concrete actions
        i.esperar1Segundo();
        i.descerFimDaPagina();
        i.esperar1Segundo();
        i.click(Identificacao.BTN_CONTINUAR);


    }

    @Then("validar que foi exibido recaptcha")
    public void validarQueFoiExibidoRecaptcha() throws IOException {
        // Write code here that turns the phrase above into concrete actions
        i.esperarElementoExistirNaTela(Identificacao.LABEL_RECAPTCHA,10);
    }
    @Then("validar que foi para tela inicial e exibe popup salvar senha para fechar")
    public void validarQueFoiParaTelaInicialEExibePopupSalvarSenhaParaFechar() throws IOException {
        // Write code here that turns the phrase above into concrete actions
        i.esperarElementoExistirNaTela(HomePageExtra.INPUT_HOME_BUSCA_EXTRA,10);
        //i.fecharPopUp();
    }



    @Given("procura pelo produto {string}")
    public void procuraPeloProduto(String produto) throws IOException, InterruptedException {
        // Write code here that turns the phrase above into concrete actions
        i.esperarElementoExistirNaTela(HomePageExtra.INPUT_HOME_BUSCA_EXTRA, 10);
        i.esperar1Segundo();
        i.escrever(HomePageExtra.INPUT_HOME_BUSCA_EXTRA, produto);
        i.esperar1Segundo();
        i.enter();
    }


    @When("seleciona o produto com valor mais barato {double}")
    public void selecionaOProdutoComValorMaisBarato(Double normalpŕice) throws IOException {
        // Write code here that turns the phrase above into concrete actions
        i.esperarElementoExistirNaTela(HomePageExtra.TEXT_PRICE_PRODUCT, 30);
        i.vertificaProdutoMenorValorDaListeSeleciona(HomePageExtra.TEXT_PRICE_PRODUCT, normalpŕice);
    }


    @Then("validar que o valor corresponde a {int}% de desconto do valor total do produto")
    public void validarQueOValorCorrespondeADeDescontoDoValorTotalDoProduto(Integer porcetagem) throws IOException {
        i.esperarElementoExistirNaTela(ProductDetail.LABEL_PRICE_1X_CARTAO, 20);
        i.validarPrecoPorcetagem(ProductDetail.LABEL_PRICE_1X_CARTAO, porcetagem);
        i.validarPrecoPorcetagem(ProductDetail.LABEL_PRICE_CARTAO_EXTRA, porcetagem);


    }

    @Given("Seleciona botao comprar")
    public void selecionaBotaoComprar() throws IOException {
        // Write code here that turns the phrase above into concrete actions
        i.esperarElementoExistirNaTela(ProductDetail.BTN_COMPRAR, 20);
        i.click(ProductDetail.BTN_COMPRAR);

    }

    @When("seleciona valor total de produtos em tela")
    public void selecionaValorTotalDeProdutosEmTela() throws IOException {
        // Write code here that turns the phrase above into concrete actions
        String nome = null;
        try {
            i.esperarElementoExistirNaTela(MeuCarrinho.LABEL_VALOR_SUBTOTAL_PRODUTO_1, 10);
            nome = i.retornarTextoDoElemento(MeuCarrinho.LABEL_VALOR_SUBTOTAL_PRODUTO_1);
        } catch (Exception e) {
            e.printStackTrace();
            try {
                nome = i.retornarTextoDoElemento(MeuCarrinho.LABEL_VALOR_SUBTOTAL_PRODUTO_2);

            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        nome = Convert.convertDoublePrice(nome);
        TDM.valortotalprodutos.setValortotal(Double.parseDouble(nome));
        //System.out.println("valor total = "+TDM.valortotalprodutos.getValortotal());
    }

    @Given("Selecionar botao continuar")
    public void selecionarBotaoContinuar() throws IOException {
        // Write code here that turns the phrase above into concrete actions
        i.esperarElementoExistirNaTela(Origem.BTN_CONTINUAR, 20);
        i.click(Origem.BTN_CONTINUAR);
    }

    @Given("Seleciona comprar mais produtos")
    public void selecionaComprarMaisProdutos() throws IOException {
        // Write code here that turns the phrase above into concrete actions
        try {
            i.esperarElementoExistirNaTela(MeuCarrinho.BTN_CONTINUAR_COMPRANDO_1, 5);
            i.click(MeuCarrinho.BTN_CONTINUAR_COMPRANDO_1);
        } catch (Exception e) {
            try {
                i.click(MeuCarrinho.BTN_CONTINUAR_COMPRANDO_2);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    @Then("validar que a soma do produto corresponde ao valor subtotalprodutos")
    public void validarQueASomaDoProdutoCorrespondeAoValorSubtotalprodutos() throws IOException {
        // Write code here that turns the phrase above into concrete action
        try {
            i.esperarElementoExistirNaTela(MeuCarrinho.LABEL_VALOR_TOTAL_PRODUTO_LAYOUT_1, 5);
            i.validarValorTotalProdutos(MeuCarrinho.LABEL_VALOR_TOTAL_PRODUTO_LAYOUT_1);
        } catch (Exception e) {
            try {
                i.validarValorTotalProdutos(MeuCarrinho.LABEL_VALOR_TOTAL_PRODUTO_LAYOUT_2);
            } catch (Exception ex) {

            }
        }

    }


}
