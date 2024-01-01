package filip.filipeex.karab;

import filip.filipeex.karab.cmds.ShadovStatusCmd;
import filip.filipeex.karab.util.ChatFarby;
import filip.filipeex.karab.util.Log;
import filip.filipeex.karab.util.Papi;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {


    public static Main i;
    private final String prefix = ChatFarby.dekoduj("&8[&#9f43fb&lS&#a743fb&lH&#af43fb&lA&#b843fc&lD&#c043fc&lO&#c843fc&lV&#d044fc&lS&#d844fc&lT&#e044fc&lA&#e944fd&lT&#f144fd&lU&#f944fd&lS&8]&r");


    @Override
    public void onLoad() {

        definujInstanciu();

        Log.konzola("The plugin was successfully loaded.");

    }

    @Override
    public void onEnable() {

        registrujPlaceholdery();
        registrujPrikazy();
        nacitajConfig();

        Log.konzola("The plugin was successfully enabled.");

    }


    public void definujInstanciu() {
        i = this;
    }


    private void registrujPlaceholdery() {
        new Papi().register();
    }


    private void registrujPrikazy() {
        getCommand("shadovstatus").setExecutor(new ShadovStatusCmd());
    }


    private void nacitajConfig() {
        getConfig().options().copyDefaults(true);
        saveDefaultConfig();
    }

    public String getPrefix() {
        return prefix;
    }


}
