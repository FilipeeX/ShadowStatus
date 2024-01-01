package filip.filipeex.karab.shadovstatus;

import filip.filipeex.karab.Main;
import filip.filipeex.karab.util.ChatFarby;

import java.util.ArrayList;

public class ShadovStatusGet {


    private static final String invalidServer = ChatFarby.dekoduj("&c&o&n&lINVALID SERVER %s");


    public static String getStatus(String server) {

        if (!isValidServer(server)) {
            return invalidServer
                    .replace("%s", server.toUpperCase());
        }

        int status = getStatusFromConfig(server);
        return getStatusMessage(status);
    }


    private static boolean isValidServer(String server) {
        ArrayList<String> validServers = getValidServers();
        return validServers.contains(server);
    }


    private static ArrayList<String> getValidServers() {
        return new ArrayList<>(Main.i.getConfig().getStringList("servers"));
    }


    private static int getStatusFromConfig(String server) {
        return Main.i.getConfig().getInt(server);
    }


    private static String getStatusMessage(int statusIndex) {
        String statusMessage = Main.i.getConfig().getString(statusIndex + "");
        return ChatFarby.dekoduj(statusMessage);
    }

}
