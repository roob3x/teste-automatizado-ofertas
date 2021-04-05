package Support;

import java.io.*;
import java.net.URL;
import java.util.Scanner;

import static Constants.Constant.PRODUTO_VALOR_PRECO_TOTAL;

public class GerenciaArquivoTxt {

    public static String criarArquivoPrecoTotal(String price) throws IOException {
        File fileURL = new File(PRODUTO_VALOR_PRECO_TOTAL);
        fileURL.createNewFile();
        FileWriter arq = new FileWriter(PRODUTO_VALOR_PRECO_TOTAL);
        PrintWriter GravarArq = new PrintWriter(arq);
        GravarArq.printf(String.valueOf(price));
        GravarArq.flush();
        GravarArq.close();
        return price;
    }

    public static String lerArquivoUrlPrecoTotal(String price) throws IOException {
        Scanner ler = new Scanner(PRODUTO_VALOR_PRECO_TOTAL);
        String nome1 = ler.nextLine();
        FileReader arq = new FileReader(nome1);
        BufferedReader LerArquivo = new BufferedReader(arq);
        price = LerArquivo.readLine();
        arq.close();
        return price;
    }
}
