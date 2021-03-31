package Support;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.util.List;

public interface Acoes {

    //default void escrever(By elemento, String texto){
    //    DriverWeb.getDriver().findElement(elemento).sendKeys(texto);
  //  }

    default void esperarElementoExistirNaTela(By elemento,int timeout) throws IOException {
        WebDriverWait wait = new WebDriverWait(DriverWeb.getDriverReuser(),timeout);
        wait.until(ExpectedConditions.visibilityOfElementLocated(elemento));
    }

    default void retornaListaDoelemento(By elemento) throws IOException {
        List<WebElement> all = DriverWeb.getDriverReuser().findElements(elemento);

    }

    default void validarQueContemTextoEsperado(By elemento,String texto) throws IOException {
        String nome = DriverWeb.getDriverReuser().findElement(elemento).getAttribute("placeholder");
        Assert.assertEquals(texto,nome);
    }

    default void moverParaElemento(By elemento) throws IOException {
        Actions action = new Actions(DriverWeb.getDriverReuser());
        WebElement we = DriverWeb.getDriverReuser().findElement(elemento);
        action.moveToElement(we).build().perform();
    }
    default void vertificaProdutoMenorValorDaList(By elemento,Double price) throws IOException {
        List<WebElement> lista = DriverWeb.getDriverReuser().findElements(elemento);
        List<String> lista1 = null;
        for(WebElement element : lista){
            System.out.println(element.getText());
            String nome = element.getText();
            lista1.add(nome);

        }
        double menorPreco,maiorPreco;
//        for (int i=0; i<= lista1.size(); i++){
    //        System.out.println(lista.get(i).toString());
   //     }
    }
}
