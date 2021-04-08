package Pages.Extra;

import org.openqa.selenium.By;

public class HomePageExtra {
    public static By INPUT_HOME_BUSCA_EXTRA = By.id("strBusca");
    public static By TEXT_PRICE_PRODUCT = By.xpath("//ul[@class=\"ProductsGrid__ProductsGridWrapper-yqpqna-0 joXYON\"]//div[@class=\"ProductPrice__Price-sc-1tzw2we-4 dujeXd\"]//span[2]");
    public static By LABEL_ENTRE_OU_CADASTRE = By.xpath("//*[contains(text(), 'Entre ou Cadastre-se')]");
    public static By LABEL_CADASTRE_AQUI = By.xpath("//*[contains( text(), 'Cadastre-se aqui')]");
}
