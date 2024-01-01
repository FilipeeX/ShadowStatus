package filip.filipeex.karab.shadovstatus;

import filip.filipeex.karab.Main;
import filip.filipeex.karab.util.ChatFarby;
import org.bukkit.command.CommandSender;

public class ShadovStatusReload {


    public static void reloadConfig(CommandSender sender) {

        Main.i.reloadConfig();

        sendSuccessMessage(sender);
    }


    private static void sendSuccessMessage(CommandSender sender) {

        String prefix = Main.i.getPrefix();
        String message = ChatFarby.dekoduj("&aSuccessfully reloaded the configuration.");

        sender.sendMessage(prefix + " " + message);
    }


}
