package filip.filipeex.karab.util;

import filip.filipeex.karab.Main;
import org.bukkit.Bukkit;

public class Log {

    public static void konzola(String log) {
        Bukkit.getConsoleSender().sendMessage(Main.i.getPrefix() + " " + ChatFarby.dekoduj(log));
    }

}
