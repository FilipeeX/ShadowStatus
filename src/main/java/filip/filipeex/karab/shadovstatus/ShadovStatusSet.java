package filip.filipeex.karab.shadovstatus;

import filip.filipeex.karab.Main;
import org.bukkit.command.CommandSender;
import filip.filipeex.karab.util.ChatFarby;

import java.util.ArrayList;

public class ShadovStatusSet {


    final CommandSender sender;
    final String server;
    final String status;


    public ShadovStatusSet(CommandSender sender, String server, String status) {
        this.sender = sender;
        this.server = server;
        this.status = status;
    }


    public void setStatus() {

        if (!isValidServer()) {
            sendInvalidServerMessage();
            return;
        }

        int statusIndex = getStatusIndex();
        if (!isValidStatusIndex(statusIndex)) {
            sendInvalidStatusMessage();
            return;
        }

        setStatusInConfig(statusIndex);
        sendSuccessMessage();
    }


    private boolean isValidServer() {
        ArrayList<String> validServers = getValidServers();
        return validServers.contains(server);
    }


    private ArrayList<String> getValidServers() {
        return new ArrayList<>(Main.i.getConfig().getStringList("servers"));
    }


    private void sendInvalidServerMessage() {

        String prefix = Main.i.getPrefix();
        String message = ChatFarby.dekoduj("&c The entered server '%s' is invalid, check the configuration for valid servers, or use the config to add a new one."
                .replace("%s", server));

        sender.sendMessage(prefix + " " + message);
    }


    private int getStatusIndex() {

        if (status.equalsIgnoreCase("offline"))
            return 0;
        else if (status.equalsIgnoreCase("online"))
            return 1;
        else if (status.equalsIgnoreCase("maintenance"))
            return 2;
        else if (status.equalsIgnoreCase("soon"))
            return 3;

        return -1;
    }


    private boolean isValidStatusIndex(int statusIndex) {
        return statusIndex >= 0 && statusIndex <= 3;
    }


    private void sendInvalidStatusMessage() {

        String prefix = Main.i.getPrefix();
        String message = ChatFarby.dekoduj("&c The entered status '%s' is invalid, valid ones are: 'online', 'offline', 'maintenance', 'soon'."
                .replace("%s", status));

        sender.sendMessage(prefix + " " + message);
    }


    private void setStatusInConfig(int statusIndex) {

        final String editedServerName = server.toLowerCase();

        Main.i.getConfig().set(editedServerName, statusIndex);
        Main.i.saveConfig();
    }

    private void sendSuccessMessage() {

        final String editedServerName = server.toUpperCase();
        final String editedStatusName = status.toUpperCase();

        String prefix = Main.i.getPrefix();
        String message = ChatFarby.dekoduj("&fSuccessfully set the status of &a%se&f to &a%st&f."
                .replace("%se", editedServerName)
                .replace("%st", editedStatusName));

        sender.sendMessage(prefix + " " + message);
    }

}
