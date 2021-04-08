package Pages.Extra;

import org.openqa.selenium.By;

public class MeuCarrinho {
    public static By LABEL_VALOR_TOTAL_PRODUTO_LAYOUT_1 = By.xpath("//td[@data-id=\"precoTotal\"]");
    public static By LABEL_VALOR_TOTAL_PRODUTO_LAYOUT_2 = By.xpath("//div[@class=\"box__Box-oqpq9y-0 flex__Flex-omp2o9-0 styledprice__Container-cbupkw-0 ljSEkB\"]/p[contains(text(), 'R$')]");
    public static By LABEL_VALOR_SUBTOTAL_PRODUTO_1 = By.xpath("//em[@data-id=\"valorTotal\"]");
    public static By LABEL_VALOR_SUBTOTAL_PRODUTO_2 = By.xpath("//strong[contains( text(), 'R$')]");
    public static By BTN_CONTINUAR_COMPRANDO_1 = By.xpath("//*[contains(text(), 'Continuar comprando')]");
    public static By BTN_CONTINUAR_COMPRANDO_2 = By.xpath("//*[contains(text(), 'Comprar mais produtos')]");
    public static By BTN_FINALIZAR_COMPRA = By.xpath("//div[contains(text(), 'Finalizar compra')]");
}
