package Pages.Extra;

import org.openqa.selenium.By;

public class Checkout {
    public static By BTN_IR_PAGAMENTO = By.xpath("//*[contains( text(), 'Ir para pagamento')]");
    public static By RADIO_BOLETO_BANCARIO = By.xpath("//div[@data-qa=\"checkout-payment-boleto\"]//label[@data-id=\"radio-input-label\"]");
    public static By BTN_FINALIZAR_COMPRA = By.xpath("//div[contains( text(), 'Finalizar compra')]");
    public static By LABEL_VALOR_TOTAL_PRODUTO = By.xpath("//ul[@class=\"summary-prices__SummaryPrices-sc-1lb17p7-0 ywagP styledcontainer__Container-j1fp4m-0 hkvyVu\"]//li[3]//strong");
}
