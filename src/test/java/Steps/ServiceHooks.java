package Steps;

import Interacao.IinteracaoSeleniumJavaWeb;
import ReuseOrder.StorageOrderReuse;
import Support.DriverWeb;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import org.junit.After;

import java.io.IOException;

public class ServiceHooks {
    public static Scenario scenario;
    IinteracaoSeleniumJavaWeb i = new IinteracaoSeleniumJavaWeb();
    @Before
    public void setUp(Scenario scenario) throws IOException {
        ServiceHooks.scenario = scenario;
        StorageOrderReuse.apagarArquivoSessionId();
        StorageOrderReuse.apagarArquivoURL();
        DriverWeb.getDriver();
        DriverWeb.getDriverReuser();
    }

}
