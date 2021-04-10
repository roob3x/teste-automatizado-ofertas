package Order;

import org.openqa.selenium.By;

import java.io.IOException;

public abstract class Order {

    public abstract void abrirURL(String url) throws IOException;
    public abstract void escrever(By elemento, String texto) throws IOException;
    public abstract void click(By elemento) throws IOException;
    public abstract void apagarCamṕo(By Elemento) throws IOException;
    public abstract void apagarComBackSpace(By elemento) throws IOException;
    public abstract void descerFimDaPagina();
    public abstract void tab();
    public abstract void topoDaPagina();
    public abstract void enter();
    public abstract void esperar1Segundo() throws InterruptedException;
    public abstract void escreverRobot(String texto);
    public abstract void fecharPopUp() throws IOException;

}
