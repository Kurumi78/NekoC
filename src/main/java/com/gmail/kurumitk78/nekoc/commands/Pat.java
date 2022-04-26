package com.gmail.kurumitk78.nekoc.commands;

import com.gmail.kurumitk78.nekoc.Config;
import org.bukkit.command.*;
import org.bukkit.*;
import com.gmail.kurumitk78.nekoc.NekoC;
import org.bukkit.entity.*;

public class Pat implements CommandExecutor {
    public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
        if (args.length == 0 || Bukkit.getPlayer(args[0]) == null) {
            sender.sendMessage(Config.PluginPrefix + ChatColor.LIGHT_PURPLE + " Invalid Input");
            return false;
        }
        if (sender.getName().equals(args[0])) {
            sender.sendMessage(Config.PluginPrefix + ChatColor.LIGHT_PURPLE + " You cannot pat yourself.");
            return true;
        }
        final Player target = Bukkit.getPlayer(args[0]);
        if (NekoC.isNeko(target) && sender instanceof Player) {
            final Player player = (Player) sender;
            if (Config.GlobalCommandMessages) {
                Bukkit.broadcastMessage(Config.PluginPrefix + ChatColor.LIGHT_PURPLE + player.getDisplayName() + ChatColor.LIGHT_PURPLE + " has pet " + target.getDisplayName());
            } else {
                sender.sendMessage(Config.PluginPrefix + ChatColor.LIGHT_PURPLE + " You have pet " + target.getDisplayName());
                target.sendMessage(Config.PluginPrefix + ChatColor.YELLOW + player.getDisplayName() + ChatColor.LIGHT_PURPLE + " has pet you");
            }
        } else {
            sender.sendMessage(Config.PluginPrefix + ChatColor.LIGHT_PURPLE + " You can only pat a Neko!");
        }
        return true;
    }
}
