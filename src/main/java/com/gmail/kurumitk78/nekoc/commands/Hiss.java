package com.gmail.kurumitk78.nekoc.commands;

import com.gmail.kurumitk78.nekoc.Config;
import org.bukkit.command.*;
import org.bukkit.entity.*;
import com.gmail.kurumitk78.nekoc.NekoC;
import org.bukkit.*;

public class Hiss implements CommandExecutor {
    public boolean onCommand(final CommandSender sender, final Command command, final String s, final String[] args) {
        if (!(sender instanceof Player)) {
            return false;
        }
        if (args.length == 0 || Bukkit.getPlayer(args[0]) == null) {
            sender.sendMessage(Config.PluginPrefix + ChatColor.LIGHT_PURPLE + " Invalid Input");
            return false;
        }

        final Player target = Bukkit.getPlayer(args[0]);
        final Player player = ((Player) sender).getPlayer();
        if (NekoC.isNeko(player)) {
            if (Config.GlobalCommandMessages) {
                Bukkit.broadcastMessage(Config.PluginPrefix + ChatColor.LIGHT_PURPLE + ChatColor.YELLOW + player.getDisplayName() + ChatColor.LIGHT_PURPLE + " is hissing at " + target.getName());
            } else {
                player.sendMessage(Config.PluginPrefix + ChatColor.LIGHT_PURPLE + " You have hissed at " + ChatColor.YELLOW + target.getDisplayName() + "!");
                target.sendMessage(Config.PluginPrefix + ChatColor.LIGHT_PURPLE + " You hear " + ChatColor.YELLOW + player.getDisplayName() + ChatColor.LIGHT_PURPLE + " hiss at you!");
            }
        }
        else{player.sendMessage(Config.PluginPrefix + ChatColor.LIGHT_PURPLE + " Only Nekos can hiss" + "!");}

        return true;
    }
}
