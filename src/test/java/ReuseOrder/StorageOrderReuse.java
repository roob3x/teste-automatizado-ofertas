package ReuseOrder;

import org.openqa.selenium.remote.SessionId;

import java.io.*;
import java.net.URL;
import java.util.Scanner;

import static Constants.Constant.SESSIONID_BROWSER_PATH;
import static Constants.Constant.URL_BROWSER_PATH;

public class StorageOrderReuse {

    public static void criarArquivoURL(URL url) throws IOException {
        File fileURL = new File(URL_BROWSER_PATH);
        fileURL.createNewFile();
        FileWriter arq = new FileWriter(URL_BROWSER_PATH);
        PrintWriter GravarArq = new PrintWriter(arq);
        GravarArq.printf(String.valueOf(url));
        GravarArq.flush();
        GravarArq.close();

    }

    public static void criarArquivoSessionId(SessionId sessionId) throws IOException {
        File filesessionID = new File(SESSIONID_BROWSER_PATH);
        filesessionID.createNewFile();
        FileWriter arq = new FileWriter(SESSIONID_BROWSER_PATH);
        PrintWriter GravarArq = new PrintWriter(arq);
        GravarArq.printf(String.valueOf(sessionId));
        GravarArq.flush();
        GravarArq.close();
    }

    public static void apagarArquivoURL() {
        File file = new File(URL_BROWSER_PATH);
        file.delete();
    }


    public static void apagarArquivoSessionId() {
        File file = new File(SESSIONID_BROWSER_PATH);
        file.delete();
    }

    public static URL lerArquivoUrl(URL url) throws IOException {
        Scanner ler = new Scanner(URL_BROWSER_PATH);
        String nome1 = ler.nextLine();
        FileReader arq = new FileReader(nome1);
        BufferedReader LerArquivo = new BufferedReader(arq);
        String linkurl = LerArquivo.readLine();
        url = new URL(linkurl);
        arq.close();
        return url;
    }
    public static SessionId lerArquivoSessao(SessionId session_id) throws IOException {
        Scanner ler1 = new Scanner(SESSIONID_BROWSER_PATH);
        String nome2 = ler1.nextLine();
        FileReader arq1 = new FileReader(nome2);
        BufferedReader LerArquivo1 = new BufferedReader(arq1);
        String iddasessao = LerArquivo1.readLine();
        session_id = new SessionId(iddasessao);
        arq1.close();
        return session_id;
    }


}
