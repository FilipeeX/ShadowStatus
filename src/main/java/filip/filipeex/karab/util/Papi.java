package filip.filipeex.karab.util;

import me.clip.placeholderapi.expansion.PlaceholderExpansion;
import org.bukkit.OfflinePlayer;

public class Papi extends PlaceholderExpansion {

    @Override
    public String getIdentifier() {
        return "shadowstatus";
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

        return "status_is_gonna_be_displayed_here";
    }

}
