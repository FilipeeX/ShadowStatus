package filip.filipeex.karab;

import filip.filipeex.karab.util.ChatFarby;
import filip.filipeex.karab.util.Log;
import filip.filipeex.karab.util.Placeholdery;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    public static Main i;
    public String prefix = ChatFarby.dekoduj("&8[&#9f43fb&lS&#a743fb&lH&#af43fb&lA&#b843fc&lD&#c043fc&lO&#c843fc&lW&#d044fc&lS&#d844fc&lT&#e044fc&lA&#e944fd&lT&#f144fd&lU&#f944fd&lS&8]&r");

    @Override
    public void onLoad() {

        definujInstanciu();

        Log.konzola("The plugin was successfully loaded.");

    }

    @Override
    public void onEnable() {

        registrujPlaceholdery();
        registrujPrikazy();

        Log.konzola("The plugin was successfully enabled.");

    }

    public void definujInstanciu() {
        i = this;
    }

    private void registrujPlaceholdery() {
        new Placeholdery().register();
    }

    private void registrujPrikazy() {
    }

    public String getPrefix() {
        return prefix;
    }

}
