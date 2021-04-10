package Steps;

import Interacao.IinteracaoSeleniumJavaWeb;
import ReuseOrder.StorageOrderReuse;
import Support.DriverWeb;
import Support.GerenciaArquivoTxt;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import org.junit.After;

import java.io.IOException;

public class ServiceHooks {
    public static Scenario scenario;
    @Before
    public void setUp(Scenario scenario) throws IOException {
        ServiceHooks.scenario = scenario;
        StorageOrderReuse.apagarArquivoSessionId();
        StorageOrderReuse.apagarArquivoURL();
        GerenciaArquivoTxt.apagarArquivoPrecoTotal();
        DriverWeb.getDriver();
        DriverWeb.getDriverReuser();
    }

    @After
    public void tearDown(){
        //System.out.println("fechou aplicacao");
        DriverWeb.endSession();
    }

}
