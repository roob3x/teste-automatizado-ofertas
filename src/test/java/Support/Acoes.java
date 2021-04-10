package Support;

import Interacao.IinteracaoSeleniumJavaWeb;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import Tdm.TDM;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static Pages.Extra.HomePageExtra.TEXT_PRICE_PRODUCT;

public interface Acoes {
    IinteracaoSeleniumJavaWeb i = new IinteracaoSeleniumJavaWeb();
    Log Logger = LogFactory.getLog(Acoes.class);

    default void esperarElementoExistirNaTela(By elemento, int timeout) throws IOException {
        WebDriverWait wait = new WebDriverWait(DriverWeb.getDriverReuser(), timeout);
        wait.until(ExpectedConditions.visibilityOfElementLocated(elemento));
    }

    default void retornaListaDoelemento(By elemento) throws IOException {
        List<WebElement> all = DriverWeb.getDriverReuser().findElements(elemento);

    }

    default void validarQueContemAtributoEsperado(By elemento, String texto) throws IOException {
        String nome = DriverWeb.getDriverReuser().findElement(elemento).getAttribute("placeholder");
        Assert.assertEquals(texto, nome);
    }

    default String retornarTextoDoElemento(By elemento) throws IOException {
        String nome = DriverWeb.getDriverReuser().findElement(elemento).getText();
        return nome;
    }

    default String retornarValueDoElemento(By elemento) throws IOException {
        String nome = DriverWeb.getDriverReuser().findElement(elemento).getAttribute("value");
        return nome;
    }

    default void validarPrecoPorcetagem(By elemento, int porcetagem) throws IOException {
        double DELTA = 1e-15;
        String nome = DriverWeb.getDriverReuser().findElement(elemento).getText();
        nome = Convert.convertDoublePrice(nome);
        double valor1 = Double.parseDouble(nome);
        nome = GerenciaArquivoTxt.lerArquivoUrlPrecoTotal(nome);
        nome = Convert.convertDoublePrice(nome);
        double valordesconto = Double.parseDouble(nome);
        valordesconto = valordesconto * porcetagem / 100;
        double valorfinal = Double.parseDouble(nome) - valordesconto;
        Assert.assertEquals("valor correto com desconto" + porcetagem + "%", valorfinal, valor1, DELTA);
    }

    default void moverParaElemento(By elemento) throws IOException {
        Actions action = new Actions(DriverWeb.getDriverReuser());
        WebElement we = DriverWeb.getDriverReuser().findElement(elemento);
        action.moveToElement(we).build().perform();
    }

    default void vertificaProdutoMenorValorDaListeSeleciona(By elemento, Double price) throws IOException {
        double menorpeco = 0, maiorpreco = 0, numero = 0;
        String locator = null, precostring, precostring2 = null;

        List<WebElement> listaelemento = DriverWeb.getDriverReuser().findElements(elemento);
        List<String> listapreco = new ArrayList<String>();
        for (WebElement element : listaelemento) {
            String nome = element.getText();
            listapreco.add(nome);
        }

        precostring = listapreco.get(0).toString();
        precostring = Convert.convertDoublePrice(precostring);
        menorpeco = Double.parseDouble(precostring);
        for (int i = 0; i < listapreco.size(); i++) {
            precostring = listapreco.get(i).toString();
            precostring = Convert.convertDoublePrice(precostring);
            numero = Double.parseDouble(precostring);
            if (numero > menorpeco && maiorpreco == 0 || numero > maiorpreco) {
                maiorpreco = numero;
            }
            if (numero < menorpeco || numero == menorpeco) {
                menorpeco = numero;
                precostring2 = listapreco.get(i).toString();

            }

            i++;
        }
        precostring = String.valueOf(menorpeco);
        System.out.println("TEXT_PRICE_PRODUCT" + TEXT_PRICE_PRODUCT.toString());
        String nome = TEXT_PRICE_PRODUCT.toString().replace("[2]", "[contains(text(),'" + precostring2.toString() + "')]")
                .replace("By.xpath: ", "");
        By locator1 = By.xpath(nome);
        WebDriverWait wait = new WebDriverWait(DriverWeb.getDriverReuser(), 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator1));
        DriverWeb.getDriverReuser().findElement(locator1).click();

        System.out.println("menor preco =" + menorpeco);
        System.out.println("maior preco =" + maiorpreco);
        precostring2 = GerenciaArquivoTxt.criarArquivoPrecoTotal(precostring2);
    }

    default void validarValorTotalProdutos(By elemento) throws IOException {
        double somaproduto = 0;
        double DELTA = 1e-15;
        String numerostring;
        List<WebElement> listaelemento = DriverWeb.getDriverReuser().findElements(elemento);
        List<String> listapreco = new ArrayList<String>();
        for (WebElement element : listaelemento) {
            if (element.getText().contains("R$")) {
                String nome = element.getText();
                listapreco.add(nome);
            }
        }
        for (int i = 0; i < listapreco.size(); i++) {
            if (listapreco.get(i).toString() != null) {
                numerostring = listapreco.get(i).toString();
                numerostring = Convert.convertDoublePrice(listapreco.get(i).toString());
                somaproduto = somaproduto + Double.parseDouble(numerostring);
            }
        }
        Assert.assertEquals("valor total nao corresponde", somaproduto, TDM.valortotalprodutos.getValortotal(), DELTA);
    }
}
