package Steps;

import Constants.URL_PAGE;
import Interacao.IinteracaoSeleniumJavaWeb;
import Pages.Extra.HomePageExtra;
import Pages.Extra.MeuCarrinho;
import Pages.Extra.Origem;
import Pages.Extra.ProductDetail;
import Pages.Search.MainPageSearch;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.io.IOException;

import static Constants.URL_PAGE.MAIN_PAGE_SEARCH;
import static Pages.Extra.HomePageExtra.INPUT_HOME_BUSCA_EXTRA;
import static Pages.Extra.HomePageExtra.TEXT_PRICE_PRODUCT;
import static Pages.Search.MainPageSearch.INPUT_MAIN_SEARCH;
import static Pages.Search.MainPageSearch.LABEL_TEXT_EXTRA;

public class ExtraSteps{
IinteracaoSeleniumJavaWeb i
        = new IinteracaoSeleniumJavaWeb();

    @Given("user enjoy on extra e-comerce with {string}")
    public void userEnjoyOnExtraEComerceWith(String texto) throws IOException {
        // Write code here that turns the phrase above into concrete actions
        i.abrirURL(URL_PAGE.MAIN_PAGE_SEARCH);
        i.esperarElementoExistirNaTela(MainPageSearch.INPUT_MAIN_SEARCH,10);
        i.escreverRobot(texto);
        i.enter();
        i.esperarElementoExistirNaTela(MainPageSearch.LABEL_TEXT_EXTRA,5);
        i.click(MainPageSearch.LABEL_TEXT_EXTRA);
    }


    @Given("search for the {string}")
    public void searchForThe(String produto) throws InterruptedException, IOException {
        i.esperarElementoExistirNaTela(INPUT_HOME_BUSCA_EXTRA,10);
        i.escrever(INPUT_HOME_BUSCA_EXTRA,produto);
        i.esperar1Segundo();
        i.enter();
    }

    @When("product is on sale less than {double}")
    public void productIsOnSaleLessThan(Double price) throws IOException {
        i.esperarElementoExistirNaTela(TEXT_PRICE_PRODUCT,30);
        i.vertificaProdutoMenorValorDaListeSeleciona(TEXT_PRICE_PRODUCT,price);
        // Write code here that turns the phrase above into concrete actions

    }

    @Given("usuario acessa home aplicacao {string}")
    public void usuarioAcessaHomeAplicacao(String texto) throws IOException {
        // Write code here that turns the phrase above into concrete actions
        i.abrirURL(MAIN_PAGE_SEARCH);
        i.esperarElementoExistirNaTela(INPUT_MAIN_SEARCH,10);
        i.escreverRobot(texto);
        i.enter();
        i.esperarElementoExistirNaTela(LABEL_TEXT_EXTRA,5);
        i.click(LABEL_TEXT_EXTRA);

    }

    @Given("procura pelo produto {string}")
    public void procuraPeloProduto(String produto) throws IOException, InterruptedException {
        // Write code here that turns the phrase above into concrete actions
        i.esperarElementoExistirNaTela(HomePageExtra.INPUT_HOME_BUSCA_EXTRA,10);
        i.esperar1Segundo();
        i.escrever(HomePageExtra.INPUT_HOME_BUSCA_EXTRA,produto);
        i.esperar1Segundo();
        i.enter();
    }


    @When("seleciona o produto com valor mais barato {double}")
    public void selecionaOProdutoComValorMaisBarato(Double normalpŕice) throws IOException {
        // Write code here that turns the phrase above into concrete actions
        i.esperarElementoExistirNaTela(HomePageExtra.TEXT_PRICE_PRODUCT,30);
        i.vertificaProdutoMenorValorDaListeSeleciona(HomePageExtra.TEXT_PRICE_PRODUCT,normalpŕice);
    }


    @Then("validar que o valor corresponde a {int}% de desconto do valor total do produto")
    public void validarQueOValorCorrespondeADeDescontoDoValorTotalDoProduto(Integer porcetagem) throws IOException {
        i.esperarElementoExistirNaTela(ProductDetail.LABEL_PRICE_1X_CARTAO,20);
        i.validarPrecoPorcetagem(ProductDetail.LABEL_PRICE_1X_CARTAO,porcetagem);
        i.validarPrecoPorcetagem(ProductDetail.LABEL_PRICE_CARTAO_EXTRA,porcetagem);


    }

    @Given("Seleciona botao comprar")
    public void selecionaBotaoComprar() throws IOException {
        // Write code here that turns the phrase above into concrete actions
        i.esperarElementoExistirNaTela(ProductDetail.BTN_COMPRAR,20);
        i.click(ProductDetail.BTN_COMPRAR);

    }

    @Given("Selecionar botao continuar")
    public void selecionarBotaoContinuar() throws IOException {
        // Write code here that turns the phrase above into concrete actions
        i.esperarElementoExistirNaTela(Origem.BTN_CONTINUAR,20);
        i.click(Origem.BTN_CONTINUAR);
    }

    @Given("Seleciona comprar mais produtos")
    public void selecionaComprarMaisProdutos() throws IOException {
        // Write code here that turns the phrase above into concrete actions
        i.esperarElementoExistirNaTela(MeuCarrinho.BTN_CONTINUAR_COMPRANDO,20);
        i.click(MeuCarrinho.BTN_CONTINUAR_COMPRANDO);
    }

    @Then("validar que a soma do produto corresponde ao valor subtotalprodutos")
    public void validarQueASomaDoProdutoCorrespondeAoValorSubtotalprodutos() {
        // Write code here that turns the phrase above into concrete actions

    }




}
