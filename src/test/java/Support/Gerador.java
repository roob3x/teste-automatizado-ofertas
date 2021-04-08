package Support;

import java.util.ArrayList;

public interface Gerador {

    default String geradorCPF() {
        ArrayList<String> alternativa = new ArrayList<String>();
        alternativa.add("13184674622");
        alternativa.add("19185506036");
        alternativa.add("85603853042");
        alternativa.add("63522214080");
        alternativa.add("35173981016");
        alternativa.add("58562644013");
        alternativa.add("74744974090");
        alternativa.add("15326445077");
        alternativa.add("92694780091");
        alternativa.add("08239317065");
        alternativa.add("35025783038");
        alternativa.add("72652088033");
        String iniciais = "";
        Integer numero;
        for (int i = 0; i < 9; i++) {
            numero = new Integer((int) (Math.random() * 10));
            iniciais += numero.toString();
        }
        String cpf = iniciais + calcDigVerif(iniciais);
        if (alternativa.contains(cpf)) {
            geradorCPF();
        } else {
            return cpf;
        }
        return cpf;

    }

    static String calcDigVerif(String num) {
        Integer primDig, segDig;
        int soma = 0, peso = 10;
        for (int i = 0; i < num.length(); i++)
            soma += Integer.parseInt(num.substring(i, i + 1)) * peso--;
        if (soma % 11 == 0 || soma % 11 == 1)
            primDig = 0;
        else
            primDig = 11 - (soma % 11);
        soma = 0;
        peso = 11;
        for (int i = 0; i < num.length(); i++)
            soma += Integer.parseInt(num.substring(i, i + 1)) * peso--;
        soma += primDig.intValue() * 2;
        if (soma % 11 == 0 || soma % 11 == 1)
            segDig = 0;
        else
            segDig = 11 - (soma % 11);
        return primDig.toString() + segDig.toString();
    }
}
