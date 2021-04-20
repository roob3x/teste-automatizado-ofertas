package Pages.Extra;

import org.openqa.selenium.By;

public class IdentificacaoCadastro {
    public static By INPUT_NOME_COMPLETO = By.id("NomeCompleto");
    public static By INPUT_CPF = By.id("Cpf");
    public static By INPUT_TELEFONE_1_DDD = By.xpath("//p[@class=\"grp fMulti fTel fTel\"]//input[@class=\"ddd\"]");
    public static By INPUT_TELEFONE_1_NUMERO = By.id("Telefone1PF");
    public static By INPUT_DATANASC_DIA = By.id("DataNascimentoDia");
    public static By INPUT_DATANASC_MES = By.id("DataNascimentoMes");
    public static By INPUT_DATANASC_ANO = By.xpath("//input[@name=\"DataNascimentoAno\"]");
    public static By RADIO_GENERO_MASCULINO = By.xpath("//input[@value=\"M\"]");
    public static By RADIO_GENERO_FEMININO = By.xpath("//input[@value=\"F\"]");
    public static By INPUT_EMAIL = By.id("Email");
    public static By INPUT_SENHA = By.id("Senha");
    public static By CHECK_ACEITAR_TDS_OCPES = By.id("chkSelecionarTodos");
    public static By BTN_CONTINUAR = By.id("btnClienteSalvarComCaptcha");
    public static By LABEL_RECAPTCHA = By.xpath("//div[contains( text(), 'Selecione tod')]");
}
