package filip.filipeex.karab.util;

import org.bukkit.ChatColor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ChatFarby {


    /* public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String vstup = in.readLine();

        System.out.println(dekodujHex(vstup));

    } */


    public static String dekoduj(String sprava) {

        String prvaVrstva = ChatColor.translateAlternateColorCodes('&', sprava);
        String druhaVrstva = dekodujHex(prvaVrstva);
        String tretiaVrstva = ChatColor.translateAlternateColorCodes('&', druhaVrstva);

        return tretiaVrstva;
    }


    private static String dekodujHex(String retazec) {

        if (!jeVhodnyHexRetazec(retazec))
            return retazec;

        ArrayList<Integer> listPozicii = najdiPozicie(retazec);
        HashMap<String, String> hexyNaVymenu = enkodujHexPozicie(retazec, listPozicii);
        String dokoncenyRetazec = nahradHexy(retazec, hexyNaVymenu);

        return dokoncenyRetazec;
    }


    private static String nahradHexy(String retazec, HashMap<String, String> hexyNaVymenu) {
        String vysledok = retazec;

        for (Map.Entry entry : hexyNaVymenu.entrySet()) {
            String stary = entry.getKey().toString();
            String novy = entry.getValue().toString();
            vysledok = vysledok.replace(stary, novy);
        }

        return vysledok;
    }


    private static HashMap<String, String> enkodujHexPozicie(String retazec, ArrayList<Integer> pozicie) {
        HashMap<String, String> vysledok = new HashMap<String, String>();

        for (int pozicia : pozicie) {

            String starySubstring = retazec.substring(pozicia, pozicia + 8);
            StringBuilder novySubstring = new StringBuilder("&x");

            // 2, 3, 4, 5, 6, 7
            for (int relativnaPoziciaZnaku = 2; relativnaPoziciaZnaku < 8; relativnaPoziciaZnaku++)
                novySubstring.append("&").append(retazec.charAt(pozicia + relativnaPoziciaZnaku));

            vysledok.put(starySubstring, novySubstring.toString());
        }

        return vysledok;
    }


    private static ArrayList<Integer> najdiPozicie(String retazec) {
        ArrayList<Integer> vysledok = new ArrayList<Integer>();

        for (int pozicia = 0; pozicia < (retazec.length() - 6); pozicia++)
            if (retazec.charAt(pozicia) == '&' && retazec.charAt(pozicia + 1) == '#')
                vysledok.add(pozicia);

        return vysledok;
    }


    private static boolean jeVhodnyHexRetazec(String retazec) {
        return retazec.length() >= 8;
    }

}
