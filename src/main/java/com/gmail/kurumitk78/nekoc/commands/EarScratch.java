package com.gmail.kurumitk78.nekoc.commands;

import com.gmail.kurumitk78.nekoc.Config;
import org.bukkit.command.*;
import org.bukkit.*;
import com.gmail.kurumitk78.nekoc.NekoC;
import org.bukkit.entity.*;

public class EarScratch implements CommandExecutor {
    public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
        if (args.length == 0 || Bukkit.getPlayer(args[0]) == null) {
            sender.sendMessage(Config.PluginPrefix + ChatColor.LIGHT_PURPLE + " Invalid Input");
            return false;
        }
        if (sender.getName().equals(args[0])) {
            sender.sendMessage(Config.PluginPrefix + ChatColor.LIGHT_PURPLE + " You cannot scratch yourself behind the ear.");
            return true;
        }
        if (NekoC.isNeko(Bukkit.getPlayer(args[0])) && sender instanceof Player) {
            final Player p = (Player) sender;
            final String PlayerName = p.getDisplayName();
            final Player player = Bukkit.getPlayer(args[0]);
            if (Config.GlobalCommandMessages) {
                Bukkit.broadcastMessage(Config.PluginPrefix + ChatColor.YELLOW + PlayerName + ChatColor.LIGHT_PURPLE + " has scratched behind the ear of " + player.getDisplayName());
            } else {
                sender.sendMessage(Config.PluginPrefix + ChatColor.LIGHT_PURPLE + " You have scratched " + ChatColor.YELLOW + player.getDisplayName() + ChatColor.LIGHT_PURPLE + " behind the ear");
                player.sendMessage(Config.PluginPrefix + ChatColor.YELLOW + PlayerName + ChatColor.LIGHT_PURPLE + " has scratched you behind the ear");
            }
        } else {
            sender.sendMessage(Config.PluginPrefix + ChatColor.LIGHT_PURPLE + " You can only scratch a Neko behind the ear!");
        }
        return true;
    }
}
