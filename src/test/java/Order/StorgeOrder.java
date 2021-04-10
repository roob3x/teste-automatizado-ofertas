package Order;

import Support.DriverWeb;
import org.openqa.selenium.By;
import org.sikuli.hotkey.Keys;
import org.sikuli.script.Screen;

import java.io.IOException;

public class StorgeOrder extends Order {
    Screen screen = new Screen();

    @Override
    public void abrirURL(String url) throws IOException {
        DriverWeb.getDriverReuser().get(url);
    }

    @Override
    public void escrever(By elemento, String texto) throws IOException {
        DriverWeb.getDriverReuser().findElement(elemento).sendKeys(texto);
    }

    @Override
    public void click(By elemento) throws IOException {
        DriverWeb.getDriverReuser().findElement(elemento).click();
    }

    @Override
    public void apagarCamṕo(By elemento) throws IOException {
        DriverWeb.getDriverReuser().findElement(elemento).clear();
    }

    @Override
    public void apagarComBackSpace(By elemento) throws IOException {
        DriverWeb.getDriverReuser().findElement(elemento).sendKeys(Keys.BACKSPACE);
    }

    @Override
    public void descerFimDaPagina() {
        screen.type(Keys.END);
    }

    @Override
    public void tab() {
        screen.type(Keys.TAB);
    }

    @Override
    public void topoDaPagina() {
        screen.type(Keys.HOME);
    }

    @Override
    public void enter() {
        screen.type(Keys.ENTER);
    }

    @Override
    public void esperar1Segundo() throws InterruptedException {
        Thread.sleep(1000);
    }

    @Override
    public void escreverRobot(String texto) {
        screen.type(texto);
    }

    @Override
    public void fecharPopUp() throws IOException {
        DriverWeb.getDriverReuser().switchTo().alert().dismiss();
    }


}
