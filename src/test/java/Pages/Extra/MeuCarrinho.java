package Pages.Extra;

import org.openqa.selenium.By;

public class MeuCarrinho {
    public static By LABEL_VALOR_TOTAL_PRODUTO = By.id("precoTotal");
    public static By LABEL_VALOR_SUBTOTAL_PRODUTO = By.id("precoTotal");
    public static By BTN_CONTINUAR_COMPRANDO = By.xpath("//button[contains(text(), 'Continuar comprando')]");
    public static By BTN_FINALIZAR_COMPRA = By.xpath("//div[contains(text(), 'Finalizar compra')]");
}
