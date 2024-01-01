package filip.filipeex.karab.cmds;

import filip.filipeex.karab.Main;
import filip.filipeex.karab.shadovstatus.ShadovStatusReload;
import filip.filipeex.karab.shadovstatus.ShadovStatusSet;
import filip.filipeex.karab.shadovstatus.ShadovStatusHelp;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.SoundCategory;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ShadovStatusCmd implements TabExecutor {


    Random r = new Random();


    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command cmd, @NotNull String label, @NotNull String[] args) {

        if (!sender.hasPermission("shadovstatus.admin")) {
            sender.sendMessage(Main.i.getPrefix() + " &cYou don't have permission to use that command! (permission needed: 'shadovstatus.admin')");
        }

        if (args.length < 1 || args.length > 2) {
            ShadovStatusHelp.sendHelpMessage(sender);
            return true;
        }

        if (args.length == 1) {
            ShadovStatusReload.reloadConfig(sender);
            return true;
        }

        String server = args[0];
        String status = args[1];
        ShadovStatusSet shadovStatusSet = new ShadovStatusSet(sender, server, status);

        shadovStatusSet.setStatus();

        return true;
    }


    @Nullable
    @Override
    public List<String> onTabComplete(@NotNull CommandSender sender, @NotNull Command cmd, @NotNull String label, @NotNull String[] args) {

        if (!isPlayer(sender))
            return null;
        Player p = (Player) sender;

        Location l = p.getLocation();
        float volume = 0.5f;
        float pitch = r.nextFloat(0.6f, 1.6f);

        p.playSound(l, Sound.UI_BUTTON_CLICK, SoundCategory.MASTER, volume, pitch);

        return new ArrayList<String>();
    }


    private boolean isPlayer(CommandSender sender) {
        return (Player) sender != null;
    }


}
