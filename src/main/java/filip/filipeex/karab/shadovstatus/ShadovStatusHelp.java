package filip.filipeex.karab.shadovstatus;

import filip.filipeex.karab.Main;
import filip.filipeex.karab.util.ChatFarby;
import org.bukkit.command.CommandSender;

public class ShadovStatusHelp {

    public static void sendHelpMessage(CommandSender sender) {

        String prefix = Main.i.getPrefix();
        String sprava = ChatFarby.dekoduj("&cUsage: /shadovstatus <server|reload> [status]");

        sender.sendMessage(prefix + " " + sprava);
    }

}
