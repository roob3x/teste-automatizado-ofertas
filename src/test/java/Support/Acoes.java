package Support;

import Order.Order;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.sql.Driver;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import static Pages.Extra.HomePageExtra.TEXT_PRICE_PRODUCT;

public interface Acoes {


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

    default void validarPrecoPorcetagem(By elemento,int porcetagem) throws IOException {
        double DELTA = 1e-15;
        String nome = DriverWeb.getDriverReuser().findElement(elemento).getText();
        nome = Convert.convertDoublePrice(nome);
        double valor1 = Double.parseDouble(nome);
        nome = GerenciaArquivoTxt.lerArquivoUrlPrecoTotal(nome);
        nome = Convert.convertDoublePrice(nome);
        double valordesconto = Double.parseDouble(nome);
        valordesconto = valordesconto*porcetagem/100;
        double valorfinal = Double.parseDouble(nome)-valordesconto;
        Assert.assertEquals("valor correto com desconto"+porcetagem+"%",valorfinal,valor1,DELTA);
    }

    default void moverParaElemento(By elemento) throws IOException {
        Actions action = new Actions(DriverWeb.getDriverReuser());
        WebElement we = DriverWeb.getDriverReuser().findElement(elemento);
        action.moveToElement(we).build().perform();
    }

    default void vertificaProdutoMenorValorDaListeSeleciona(By elemento, Double price) throws IOException {
        double menorpeco = 0,maiorpreco = 0,numero = 0;
        String locator= null,precostring,precostring2 = null;

        List<WebElement> listaelemento = DriverWeb.getDriverReuser().findElements(elemento);
        List<String> listapreco = new ArrayList<String>();
        for (WebElement element : listaelemento) {
           // System.out.println(element.getText());
            String nome = element.getText();
            listapreco.add(nome);
        }

        precostring = listapreco.get(0).toString();
        precostring = Convert.convertDoublePrice(precostring);
        menorpeco = Double.parseDouble(precostring);
        for (int i = 1; i < listapreco.size(); i++) {
            precostring = listapreco.get(i).toString();
            precostring = Convert.convertDoublePrice(precostring);
            numero = Double.parseDouble(precostring);
            if (numero > menorpeco && maiorpreco ==0 || numero > maiorpreco){
                maiorpreco = numero;
            }
            if(numero < menorpeco || numero == menorpeco){
                menorpeco = numero;
                precostring2 = listapreco.get(i).toString();

            }
            i++;
        }
        precostring = String.valueOf(menorpeco);
        String nome = TEXT_PRICE_PRODUCT.toString().replace("[2]","[contains(text(),'"+precostring2.toString()+"')]")
                .replace("By.xpath: ","");
        By locator1 = By.xpath(nome);
        WebDriverWait wait = new WebDriverWait(DriverWeb.getDriverReuser(),10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator1));
        DriverWeb.getDriverReuser().findElement(locator1).click();

        System.out.println("menor preco =" + menorpeco);
        System.out.println("maior preco =" + maiorpreco);
        precostring2 = GerenciaArquivoTxt.criarArquivoPrecoTotal(precostring2);
    }
}
