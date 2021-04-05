package Pages.Extra;

import org.openqa.selenium.By;

public class ProductDetail {
    public static By LABEL_PRICE_1X_CARTAO = By.id("product-price");
    public static By LABEL_PRICE_12X_CARTAO = By.xpath("//div[@id=\"card-conditions\"]//span[1]");
    public static By LABEL_PRICE_CARTAO_EXTRA = By.xpath("//div[@id=\"store-card-conditions\"]//span[1]");

}
