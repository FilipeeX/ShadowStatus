package filip.filipeex.karab.util;

import filip.filipeex.karab.shadovstatus.ShadovStatusGet;
import me.clip.placeholderapi.expansion.PlaceholderExpansion;
import org.bukkit.OfflinePlayer;

public class Papi extends PlaceholderExpansion {

    @Override
    public String getIdentifier() {
        return "shadovstatus";
    }

    @Override
    public String getAuthor() {
        return "filipeex";
    }

    @Override
    public String getVersion() {
        return "1.0";
    }

    @Override
    public String onRequest(OfflinePlayer hrac, String parametre) {
        return ShadovStatusGet.getStatus(parametre);
    }

}
