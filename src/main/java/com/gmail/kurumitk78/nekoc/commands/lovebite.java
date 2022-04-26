package com.gmail.kurumitk78.nekoc.commands;

import com.gmail.kurumitk78.nekoc.Config;
import org.bukkit.command.*;
import org.bukkit.entity.*;
import com.gmail.kurumitk78.nekoc.NekoC;
import org.bukkit.*;

public class Lovebite implements CommandExecutor {
    public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
        if (!(sender instanceof Player)) {
            return false;
        }
        if (args.length == 0 || Bukkit.getPlayer(args[0]) == null) {
            sender.sendMessage(Config.PluginPrefix + ChatColor.LIGHT_PURPLE + " Invalid Input");
            return false;
        }
        if (NekoC.isNeko(Bukkit.getPlayer(args[0]))) {
            sender.sendMessage(Config.PluginPrefix + ChatColor.LIGHT_PURPLE + " Nekos can't lovebite another neko!");
        } else {
            final Player p = (Player) sender;
            final String PlayerName = p.getName();
            final Player player = Bukkit.getPlayer(args[0]);
            if (Config.GlobalCommandMessages) {
                Bukkit.broadcastMessage(Config.PluginPrefix + ChatColor.YELLOW + p.getDisplayName() + ChatColor.LIGHT_PURPLE + " has lightly bit the finger of " + ChatColor.YELLOW + player.getName());
            } else {
                sender.sendMessage(Config.PluginPrefix + ChatColor.LIGHT_PURPLE + " You lightly bite the finger of " + ChatColor.YELLOW + args[0] + ChatColor.LIGHT_PURPLE + " to show them how much you love them.");
                player.sendMessage(Config.PluginPrefix + ChatColor.YELLOW + " You feel a sharp set of teeth softly bite your finger, then see" + ChatColor.YELLOW + PlayerName + ChatColor.LIGHT_PURPLE + " looking up at you.");
            }
        }
        return true;
    }
}
