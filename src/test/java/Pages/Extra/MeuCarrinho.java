package Pages.Extra;

import org.openqa.selenium.By;

public class MeuCarrinho {
    public static By LABEL_VALOR_TOTAL_PRODUTO_1 = By.xpath("//td[@data-id=\"precoTotal\"]");
    public static By LABEL_VALOR_SUBTOTAL_PRODUTO = By.id("precoTotal");
    public static By BTN_CONTINUAR_COMPRANDO_1 = By.xpath("//*[contains(text(), 'Continuar comprando')]");
    public static By BTN_CONTINUAR_COMPRANDO_2 = By.xpath("//*[contains(text(), 'Comprar mais produtos')]");
    public static By BTN_FINALIZAR_COMPRA = By.xpath("//div[contains(text(), 'Finalizar compra')]");
}
