package Support;

import Order.Order;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public interface Acoes {

    //default void escrever(By elemento, String texto){
    //    DriverWeb.getDriver().findElement(elemento).sendKeys(texto);
    //  }

    default void esperarElementoExistirNaTela(By elemento, int timeout) throws IOException {
        WebDriverWait wait = new WebDriverWait(DriverWeb.getDriverReuser(), timeout);
        wait.until(ExpectedConditions.visibilityOfElementLocated(elemento));
    }

    default void retornaListaDoelemento(By elemento) throws IOException {
        List<WebElement> all = DriverWeb.getDriverReuser().findElements(elemento);

    }

    default void validarQueContemTextoEsperado(By elemento, String texto) throws IOException {
        String nome = DriverWeb.getDriverReuser().findElement(elemento).getAttribute("placeholder");
        Assert.assertEquals(texto, nome);
    }

    default void moverParaElemento(By elemento) throws IOException {
        Actions action = new Actions(DriverWeb.getDriverReuser());
        WebElement we = DriverWeb.getDriverReuser().findElement(elemento);
        action.moveToElement(we).build().perform();
    }

    default void vertificaProdutoMenorValorDaListeSeleciona(By elemento, Double price) throws IOException {
        List<WebElement> listaelemento = DriverWeb.getDriverReuser().findElements(elemento);
        List<String> listapreco = new ArrayList<String>();
        for (WebElement element : listaelemento) {
            System.out.println(element.getText());
            String nome = element.getText();
            listapreco.add(nome);

        }
        double menorpeco = 0;
        double maiorpreco = 0;
        double numero = 0;
        String locator= null;
        String precostring;
        String precostring2 = null;
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
        locator = DriverWeb.getDriverReuser().findElement(elemento).toString();
        System.out.println("preco string2 = "+precostring2);
        locator = locator.replaceAll("[2]","[contains(text(),'"+precostring2.toString()+"'"+"])");
        System.out.println(locator);
        //precostring = String.valueOf(menorpeco);



        System.out.println("menor preco =" + menorpeco);
        System.out.println("maior preco =" + maiorpreco);
    }
}
