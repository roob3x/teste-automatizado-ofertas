package Constants;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class NamePc {
    public static String nomePC;

    static {
        try {
            nomePC = InetAddress.getLocalHost().getHostName();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}
