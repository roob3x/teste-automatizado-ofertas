package Support;

public class Convert {
    public static String convertDoublePrice(String precostring){
        precostring = precostring.replace("R$", "");
        precostring = precostring.replace(".", "");
        precostring = precostring.replace(",", ".");
        precostring = precostring.replace(" ", "");
        return precostring;
    }
}
