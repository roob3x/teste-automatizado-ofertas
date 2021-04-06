package Support;

import ReuseOrder.StorageOrderReuse;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.HttpCommandExecutor;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.SessionId;

import java.io.IOException;
import java.net.URL;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import static Constants.Constant.CHROME_DRIVER_PATH;

public class DriverWeb {

    static WebDriver driver;
    static RemoteWebDriver driverReuse;
    public static WebDriver getDriver() throws IOException {
        if (driver == null) {
            System.setProperty("webdriver.chrome.driver", CHROME_DRIVER_PATH);
            System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
            ChromeOptions options = new ChromeOptions();
            options.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
            options.setExperimentalOption("useAutomationExtension", false);
            options.addArguments("--disable-blink-features");
            options.addArguments("--disable-blink-features=AutomationControlled");
            Map<String, Object> params = new HashMap<String, Object>();
            params.put("source", "Object.defineProperty(navigator, 'webdriver', { get: () => undefined })");
            //WebDriver browser = new ChromeDriver(options);
            ChromeDriver driver = new ChromeDriver(options);

            HttpCommandExecutor executor = (HttpCommandExecutor) driver.getCommandExecutor();
            URL url = executor.getAddressOfRemoteServer();
            SessionId sessionId = driver.getSessionId();
            StorageOrderReuse.criarArquivoURL(url);
            StorageOrderReuse.criarArquivoSessionId(sessionId);
            // browser.executeCdpCommand("Page.addScriptToEvaluateOnNewDocument", params);
            driver.manage().window().maximize();
        }
        return driver;
    }
    public static RemoteWebDriver getDriverReuser() throws IOException {
        URL url=null;
        SessionId sessionId=null;
        url = StorageOrderReuse.lerArquivoUrl(url);
        sessionId = StorageOrderReuse.lerArquivoSessao(sessionId);

            driverReuse = ReuseBrowser.createDriverFromSession(sessionId,url);

        return driverReuse;
    }



}
