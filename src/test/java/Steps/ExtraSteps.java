package Steps;

import Interacao.IinteracaoSeleniumJavaWeb;
import ReuseOrder.StorageOrderReuse;
import Support.DriverWeb;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;

import java.io.IOException;

import static Constants.URL.MAIN_PAGE;
import static Constants.URL.MAIN_PAGE_SEARCH;
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
        i.abrirURL(MAIN_PAGE_SEARCH);
        i.esperarElementoExistirNaTela(INPUT_MAIN_SEARCH,10);
        i.escreverRobot(texto);
        i.enter();
        i.esperarElementoExistirNaTela(LABEL_TEXT_EXTRA,5);
        i.click(LABEL_TEXT_EXTRA);
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
        i.esperarElementoExistirNaTela(INPUT_HOME_BUSCA_EXTRA,10);
        i.escrever(INPUT_HOME_BUSCA_EXTRA,produto);
        i.esperar1Segundo();
        i.enter();
    }


    @When("seleciona o produto com valor mais barato {double}")
    public void selecionaOProdutoComValorMaisBarato(Double normalpŕice) throws IOException {
        // Write code here that turns the phrase above into concrete actions
        i.esperarElementoExistirNaTela(TEXT_PRICE_PRODUCT,30);
        i.vertificaProdutoMenorValorDaListeSeleciona(TEXT_PRICE_PRODUCT,normalpŕice);
    }


    @Then("validar que o valor corresponde a {int}% de desconto do valor total do produto")
    public void validarQueOValorCorrespondeADeDescontoDoValorTotalDoProduto(Integer price) {


    }






}
